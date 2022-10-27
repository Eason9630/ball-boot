package com.tibame.ball.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.ball.member.sevice.impl.MemberServiceImpl;
import com.tibame.ball.member.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(path = {"/api"})
public class Delete {
	@Autowired
	private MemberServiceImpl service;
	
	@DeleteMapping(path = {"/delete"})
	public Integer deleteMember(@RequestBody MemberVO member) {
		Integer id = member.getId();
		
		MemberVO memberVO = service.delete(id);
		return memberVO.getId();
		
	}
}
