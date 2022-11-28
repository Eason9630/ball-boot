package com.tibame.ball.Encrypt;

public class Kaiser {
	public static void main(String[] args) {
		String string = "Hello World";
		int key = 5;
		// 凱薩加密
		String result = encryptKaiser(string, key);
		System.out.println("加密：" + result);
		String answer = decryptKaiser(result, key);
		System.out.println("解密：" + answer);
	}

	/*
	 * 解密
	 * @param result 密文
	 * @key 密鑰
	 * @return
	 */
	private static String decryptKaiser(String result, int key) {
		char[] chars = result.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			int b = c;
			b -= key;
			char newb = (char) b;
			sb.append(newb);
		}
		return sb.toString();

	}

	/*
	 * 加密
	 * @param string 原密碼
	 * @return
	 */
	private static String encryptKaiser(String string, int key) {
		char[] chars = string.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			int b = c;
			b += key;
			char newb = (char) b;
			sb.append(newb);
		}
		return sb.toString();
	}
}
