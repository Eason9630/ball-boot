package com.tibame.ball.member.dao;

import java.util.List;

import com.tibame.ball.member.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> getAll();
	
	public MemberVO insert(MemberVO member);
	
	public MemberVO update(MemberVO member);
	
	public MemberVO delete(Integer id);
	
	public MemberVO findById(Integer id);
	
	
}
