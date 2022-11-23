package com.tibame.ball.Json;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.User;
/*
 * 將JSONString轉換成User對象
 */
@SpringBootTest
public class JSONStringToUser {
	
	@Test
	public void testJSONStringToUser() throws JsonMappingException, JsonProcessingException {
		String jSONString ="{\"id\":1,\"user\":\"Eason\",\"password\":\"1111\",\"birthday\":\"2022-11-21\"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		User user = objectMapper.readValue(jSONString, User.class);
		System.out.println(user);
	
	
	}
}
