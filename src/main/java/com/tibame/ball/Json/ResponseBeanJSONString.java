package com.tibame.ball.Json;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.ResponseBean;
import com.tibame.ball.member.vo.User;

public class ResponseBeanJSONString {

	public void testResponseBeanJSONString() throws JsonProcessingException {
		//Boolean
		ObjectMapper objectMapper = new ObjectMapper();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		ResponseBean<Boolean> responseBean = new ResponseBean<>();
		responseBean.setFlag(true);
		responseBean.setDateT(Boolean.TRUE);
		//轉換成String
		String responseBeanJSONString = objectMapper.writeValueAsString(responseBean);
		System.out.println(responseBeanJSONString);
		
		/*
		 * 將ResponseBean對象轉換成JSONString
		 */
		
		ResponseBean<User> responseBeanUser = new ResponseBean<>(Boolean.TRUE);
		
		User user = new User();
		user.setId(1);
		user.setUser("Eason");
		user.setPassword("1111");
		user.setBirthday(LocalDate.now());
		
		responseBeanUser.setDateT(user);
		//轉換成String
		responseBeanJSONString = objectMapper.writeValueAsString(responseBeanUser);
		System.out.println(responseBeanJSONString);
	}
}
