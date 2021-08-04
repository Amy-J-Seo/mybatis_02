package com.d_time.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d_time.prj.board.serviceImpl.BoardServiceImpl;
import com.d_time.prj.board.vo.SnsVO;
import com.d_time.prj.common.Command;

public class EditMainForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int sNo = Integer.valueOf(request.getParameter("mainNo"));
		request.setAttribute("sNo", sNo);
		return "board/snsMainEditForm";
	}

}
