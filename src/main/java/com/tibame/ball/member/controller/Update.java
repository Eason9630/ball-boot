package com.tibame.ball.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.ball.member.sevice.impl.MemberServiceImpl;
import com.tibame.ball.member.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(path = "/api")
public class Update {
	@Autowired private MemberServiceImpl service;
	
	@PutMapping(path = "update")
	public MemberVO updateMember(@RequestBody MemberVO member) {
		
		return service.update(member);
		
	}
}
