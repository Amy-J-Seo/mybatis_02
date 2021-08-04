package com.d_time.prj.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d_time.prj.board.service.BoardService;
import com.d_time.prj.board.serviceImpl.BoardServiceImpl;
import com.d_time.prj.common.Command;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// sns목록 가져오기
		
		BoardService boardDao = new BoardServiceImpl();
//		List<SnsVO> list = new ArrayList<SnsVO>();
//		list = boardDao.snsSelectList();
//		request.setAttribute("lists",list);
		
		request.setAttribute("list", boardDao.snsSelectList());
		return "board/snsList";
	}

}
