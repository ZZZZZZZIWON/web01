package com.exam.myapp.member;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberApiController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/list")
	public List<MemberVo> list() {	
		
		List<MemberVo> list = memberService.selectMemberList();	
		
		return list;
	}
	
	@PostMapping("/member/add")
	public HashMap<String, Object> add(@Valid MemberVo vo, BindingResult result) {
		if(result.hasErrors()) {	
			
			throw new RuntimeException("회원정보검증오류");
		}
		
		int num = memberService.insertMember(vo);	

		System.out.println(num + "명의 회원 추가");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return map;			
	}
	
	@GetMapping("/member/edit")
	public MemberVo editform(String memId) {
		
		MemberVo vo = memberService.selectMember(memId);
		
		return vo;
	}
	
	@PostMapping("/member/edit")
	public HashMap<String, Object> edit(MemberVo vo) {
		
		int num = memberService.updateMember(vo);	
		System.out.println(num + "명의 회원 수정");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return map;			
	}
	
	@GetMapping("/member/del")
	public HashMap<String, Object> del(String memId) {
		
		int num = memberService.deleteMember(memId);
		System.out.println( num + "명의 회원 삭제");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return map;		
	}
	
}

