package com.d_time.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d_time.prj.board.service.BoardService;
import com.d_time.prj.board.serviceImpl.BoardServiceImpl;
import com.d_time.prj.board.vo.SnsVO;
import com.d_time.prj.common.Command;

public class SnsSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 원글과 댓글 가져오기
		BoardService boardDao = new BoardServiceImpl();
		SnsVO vo = new SnsVO();
		
		vo.setSNo(Integer.valueOf(request.getParameter("sno")));
		
		request.setAttribute("list", boardDao.snsSelect(vo));
		return "board/snsSelect";
	}

}
