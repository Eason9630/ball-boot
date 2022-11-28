package com.tibame.ball.Json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.User;

public class UserListJSONString {
	/*
	 * 將List轉換為JSONString
	 */
	public void testUserListJSONString() throws JsonProcessingException {
		User tony = new User();
		tony.setId(1);
		tony.setUser("tony");
		tony.setPassword("1111");
		tony.setBirthday(LocalDate.now());
		
		User jack = new User();
		jack.setId(2);
		jack.setUser("jack");
		jack.setPassword("66666");
		jack.setBirthday(LocalDate.now());
		
		List<User>userList = new ArrayList<>();
		userList.add(tony);
		userList.add(jack);
		ObjectMapper objectMapper = new ObjectMapper();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		//轉換成String
		String userListJSONString = objectMapper.writeValueAsString(userList);
		System.out.println(userListJSONString);
	}
}
