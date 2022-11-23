package com.tibame.ball.Json;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.ResponseBean;
import com.tibame.ball.member.vo.User;

/*
 * 將JSONString轉換成Response,data為List
 */
@SpringBootTest
public class JSONStringToResponseBeanListData {

	@Test
	public void testJSONStringToResponseBoolean() throws JsonMappingException, JsonProcessingException {
		String JsonString ="{\"flag\":true,\"dateT\":[{\"id\":1,\"user\":\"tony\",\"password\":\"1111\",\"birthday\":\"2022-11-21\"},{\"id\":2,\"user\":\"jack\",\"password\":\"66666\",\"birthday\":\"2022-11-21\"}],\"errString\":null}";
		ObjectMapper objectMapper = new ObjectMapper();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		
		ResponseBean responseBean = objectMapper.readValue(JsonString ,new TypeReference<ResponseBean<List<User>>>() {
		});
		
		List<User> userList = (List<User>) responseBean.getDateT();
		for(User user :userList) {
			System.out.println(user);
		}
		System.out.println("responseBean.getFlag = "+ responseBean.getFlag());
		System.out.println("responseBean.getErrString = "+ responseBean.getErrString());
	
	}
}
