package com.tibame.ball.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.ball.member.sevice.impl.MemberServiceImpl;
import com.tibame.ball.member.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping( path = {"api"})
public class GetAll {

		@Autowired
		private MemberServiceImpl service;
		
		@GetMapping(path = {"/getAll"})
		public List <MemberVO> All() {
			List<MemberVO> list = service.getAll();
			return list;
		}
}
