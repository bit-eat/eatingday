package com.eat.vo;

import lombok.Data;

@Data

public class MemberVO {

	private Long id;
	private String userId;
	private String userPw;
	private String userName;
	private String PhoneNumber;
	private String grade;
	private Data regisDate;
	private Data modifiDate;
}
