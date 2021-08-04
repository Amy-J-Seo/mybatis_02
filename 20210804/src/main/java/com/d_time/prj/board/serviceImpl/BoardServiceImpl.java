package com.d_time.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.d_time.prj.board.service.BoardService;
import com.d_time.prj.board.service.BoardMapper;
import com.d_time.prj.board.vo.CommentsVO;
import com.d_time.prj.board.vo.SnsVO;
import com.d_time.prj.common.DataSource;

public class BoardServiceImpl implements BoardService{
	//마이바티스를 통해 데이터베이스 연결
	private SqlSession sqlSession = DataSource.getInstance().openSession();
	//맵퍼를 쓰기 위해서
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	
	@Override
	public List<SnsVO> snsSelectList() {
		// TODO Auto-generated method stub
		
		return map.snsSelectList();
	}

	@Override
	public List<SnsVO> snsSelect(SnsVO vo) {
		// TODO Auto-generated method stub
		return  map.snsSelect(vo);
	}

	@Override
	public CommentsVO commentsSelect(CommentsVO vo) {
		// TODO Auto-generated method stub
		return  map.commentsSelect(vo);
	}

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsInsert(vo);
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsInsert(vo);
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsUpdate(vo);
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsUpdate(vo);
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsDelete(vo);
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsDelete(vo);
	}

}
