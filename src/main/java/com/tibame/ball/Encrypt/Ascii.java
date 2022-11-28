package com.tibame.ball.Encrypt;


public class Ascii {
	public static void main(String[] args) {
		String a = "aaAAc";
		char[] c = a.toCharArray();
		for(char cc : c) {
			int ascii = cc;
			System.out.print(ascii);
		}
	}
}
