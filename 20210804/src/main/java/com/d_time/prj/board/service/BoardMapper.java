package com.d_time.prj.board.service;

import java.util.List;


import com.d_time.prj.board.vo.CommentsVO;
import com.d_time.prj.board.vo.SnsVO;

public interface BoardMapper {
	List<SnsVO> snsSelectList();
	
	List<SnsVO> snsSelect(SnsVO vo);
	CommentsVO commentsSelect(CommentsVO vo);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelete(CommentsVO vo);
}
