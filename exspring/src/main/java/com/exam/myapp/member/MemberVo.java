package com.exam.myapp.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberVo {

//	@NotNull @Size(max = 50, min = 1)
	private String memId;
//	@NotNull @Size(max = 50, min = 1)
	private String memPass;
//	@NotNull @Size(max = 50, min = 1)
	private String memName;
//	@Digits(integer =10, fraction=0)
	private int    memPoint;
	

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
}
