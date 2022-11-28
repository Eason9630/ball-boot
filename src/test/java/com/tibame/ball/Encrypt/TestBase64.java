package com.tibame.ball.Encrypt;

import org.apache.tomcat.util.codec.binary.Base64;

public class TestBase64 {
	public static void main(String[] args) {
		//1表示一個字節，不夠三個字節
		//MQ==：需要注意，在使用Base64，進行編碼的時候，如果字節不夠3個字節，需要使用=補齊
		System.out.println(Base64.encodeBase64String("1".getBytes()));
		//如果是兩個字節，就補齊一個=
		System.out.println(Base64.encodeBase64String("12".getBytes()));
		System.out.println(Base64.encodeBase64String("123".getBytes()));
		//中文在UTF-8佔3個字節，剛好可以整除就不用補=
		System.out.println(Base64.encodeBase64String("淡水".getBytes()));
	}
}
