package com.d_time.prj.member.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
	private String author;
	private char state;
	
	private String check; //login or search status
	
	
}
