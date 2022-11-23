package com.tibame.ball.Json;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.User;

/*
 * 將JSONString轉換為List
 */
@SpringBootTest
public class JSONStringToList {

	@Test
	public void testJSONStringToList() throws JsonMappingException, JsonProcessingException {
		String jSONString = "[{\"id\":1,\"user\":\"tony\",\"password\":\"1111\",\"birthday\":\"2022-11-21\"},{\"id\":2,\"user\":\"jack\",\"password\":\"66666\",\"birthday\":\"2022-11-21\"}]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		List<User>userList =   objectMapper.readValue(jSONString,new TypeReference<List<User>>(){});
		System.out.println(userList);
	}
}
