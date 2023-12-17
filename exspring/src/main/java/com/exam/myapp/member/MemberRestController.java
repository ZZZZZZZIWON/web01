package com.exam.myapp.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MemberRestController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	public List<MemberVo> list() {	
		
		List<MemberVo> list = memberService.selectMemberList();	
		
		return list;
	}
	
	@PostMapping("/members")
	public HashMap<String, Object> add(@RequestBody @Valid MemberVo vo, BindingResult result) {
		if(result.hasErrors()) {	
			
			throw new RuntimeException("회원정보검증오류");
		}
		
		int num = memberService.insertMember(vo);	

		System.out.println(num + "명의 회원 추가");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return map;			
	}
	
	@GetMapping("/members/{memId}")
	public MemberVo editform(@PathVariable String memId) {
		
		MemberVo vo = memberService.selectMember(memId);
		
		return vo;
	}
	
	@PatchMapping("/members/{memId}")
	public ResponseEntity<Map<String,Object>> edit(@RequestBody MemberVo vo) {
		
		int num = memberService.updateMember(vo);	
		System.out.println(num + "명의 회원 수정");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/members/{memId}")
	public HashMap<String, Object> del(@PathVariable String memId) {
		
		int num = memberService.deleteMember(memId);
		System.out.println( num + "명의 회원 삭제");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		
		return map;		
	}
	
}

