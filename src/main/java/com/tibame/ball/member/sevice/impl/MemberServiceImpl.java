package com.tibame.ball.member.sevice.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.ball.member.dao.MemberDAO;
import com.tibame.ball.member.sevice.MemberService;
import com.tibame.ball.member.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	@Override
	@Transactional
	public List<MemberVO> getAll() {
		return dao.getAll();
	}

	@Override
	@Transactional
	public MemberVO insert(MemberVO member) {
		String username = member.getUsername();
		if(username == null && username.isEmpty()) {
			member.setMessage("帳號不能為空");
			member.setSuccessful(false);
			return null;
		}
		String password = member.getPassword();
		if(password == null && password.trim().isEmpty()) {
			member.setMessage("密碼不能為空");
			member.setSuccessful(false);
			return null;
		}else if(!(password.trim().matches("^\\w{4,15}$"))){
			 member.setMessage("請輸入14個英文或數字");
			 member.setSuccessful(false);
			 return null;
		}
		String nickname = member.getNickname();
		if(nickname == null && nickname.trim().isEmpty()) {
			member.setMessage("姓名不能為空");
			member.setSuccessful(false);
			return null;
		}
		LocalDate birthday = member.getBirthday();
		String img = member.getBase64img();
//		member.setBase64img(base.Encoder(img));
//		member.setImg(base.Decoder(member.getBase64img()));
		
		member.setMessage("註冊成功");
		member.setSuccessful(true);
		dao.insert(member);
		return member;
	}
	
	@Override
	@Transactional
	public MemberVO update(MemberVO member) {
		String password = member.getPassword();
		if(password == null && password.trim().isEmpty()) {
			member.setMessage("請勿空白");
			member.setSuccessful(false);
		}
		String nickname = member.getNickname();
		if(nickname == null && nickname.trim().isEmpty()) {
			member.setMessage("請勿空白");
			member.setSuccessful(false);
		}
		String img = member.getBase64img();
		
		
		member.setSuccessful(true);
		MemberVO memberVO = dao.update(member);
		return memberVO;
	}

	@Override
	@Transactional
	public MemberVO delete(Integer id) {
		if(id != null) {
			MemberVO memberVO = dao.delete(id);
			return memberVO;
		}
		return null;
	}

	@Override
	public MemberVO findById(Integer id) {
		return null;
	}

}
