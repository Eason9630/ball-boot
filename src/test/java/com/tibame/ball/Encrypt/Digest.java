package com.tibame.ball.Encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 
 * @author linfuli 
 * 消息摘要算法 
 * Exception
 * 常見算法有：MD5,SHA-1,SHA-256,SHA-512
 */
public class Digest {
	public static void main(String[] args) throws Exception {
		// 原文 JdVa0oOqQAr0ZMdtcTwHrQ==
		String input = "12345678";
		// 算法 MD5
		String algorithmMD5 = "MD5";
		String MD5 = getDigest(input, algorithmMD5);
		System.out.println("MD5:" + MD5);
		// 算法 SHA-1
		String algorithmSHA1 = "SHA-1";
		String SHA1 = getDigest(input, algorithmSHA1);
		System.out.println("SHA1:" +SHA1);
		// 算法 SHA-256
		String algorithmSHA256 = "SHA-256";
		String SHA256 = getDigest(input, algorithmSHA256);
		System.out.println("SHA256:" +SHA256);
		// 算法 SHA-512
		String algorithmSHA512 = "SHA-512";
		String SHA512 = getDigest(input, algorithmSHA512);
		System.out.println("SHA512:" +SHA512);


	}
	/**
	 * 獲取數字摘要
	 * @param input 原文
	 * @param algorithm 算法
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getDigest(String input, String algorithm) throws NoSuchAlgorithmException {
		// 創建消息摘要對象
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		// 執行消息摘要算法
		byte[] bytes = digest.digest(input.getBytes());
		
		return toHex(bytes);
	}

	public static String toHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();

		// 對密文進行迭代
		for (byte b : bytes) {
			// 把密文轉成16進位
			String string = Integer.toHexString(b & 0xff);
			// 判斷密文如果嘗試是1需要在高位捕0
			if (string.length() == 1) {
				string = "0" + string;
			}
			sb.append(string);
		}

		return sb.toString();
	}
}
