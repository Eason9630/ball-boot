package com.tibame.ball.Json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tibame.ball.member.vo.ResponseBean;
import com.tibame.ball.member.vo.User;
/*
 * 將RsponseBean對象轉成ListJSONString
 */
@SpringBootTest
public class ResponseBeanUserListDataJSONString {
	
	@Test
	public void testResponseBeanUserListDataJSONString() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<User>userList = new ArrayList<>();
		//呼叫方法先使格式轉換
		objectMapper.findAndRegisterModules();
		ResponseBean<List<User>> responseBeanUser = new ResponseBean<>(Boolean.TRUE);
		
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
		
		userList.add(tony);
		userList.add(jack);
		
		responseBeanUser.setDateT(userList);
		//轉換成String
		String responseBeanUserListDataJSONString = objectMapper.writeValueAsString(responseBeanUser);
		System.out.println(responseBeanUserListDataJSONString);
	}
}
