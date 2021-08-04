package com.d_time.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d_time.prj.common.Command;
import com.d_time.prj.member.service.MemberService;
import com.d_time.prj.member.serviceImpl.MemberServiceImpl;
import com.d_time.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId("pip");
		vo.setPassword("54");
		vo.setCheck("login");
		
		request.setAttribute("member", memberDao.memberSelect(vo));
		
		return "member/loginResult";
	}

}
