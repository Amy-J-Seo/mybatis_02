package com.d_time.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.d_time.prj.common.DataSource;
import com.d_time.prj.member.service.MemberMapper;
import com.d_time.prj.member.service.MemberService;
import com.d_time.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession SqlSession = DataSource.getInstance().openSession();
	private MemberMapper map = SqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

}
