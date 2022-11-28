package com.tibame.ball.Encrypt;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 
 * @author linfuli
 * toString與new String區別
 */
public class TestString {
	public static void main(String[] args) {
		String str = "5reh5rC0";
		
		String str1 = new String(Base64.decodeBase64(str));
		
		String str2 = Base64.decodeBase64(str).toString();
		
		System.out.println("new String:"+ str1);
		
		System.out.println("toString:" + str2);
	}
}
