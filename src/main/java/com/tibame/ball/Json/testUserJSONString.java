package com.tibame.ball.Json;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.User;

public class testUserJSONString {
	/*
	 * User對象轉換成JSONString
	 */
	public void testUserJSONString() throws JsonProcessingException {
		User user = new User();
		user.setId(1);
		user.setUser("Eason");
		user.setPassword("1111");
		user.setBirthday(LocalDate.now());
		
		ObjectMapper objectMapper = new ObjectMapper();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		//轉換成String
		String userJSONString = objectMapper.writeValueAsString(user);
		System.out.println(userJSONString);
		
	}
}
