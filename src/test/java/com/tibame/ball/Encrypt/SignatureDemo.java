package com.tibame.ball.Encrypt;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import org.apache.tomcat.util.codec.binary.Base64;

public class SignatureDemo {
	public static void main(String[] args) throws Exception {
		String g = "淡水";
		
		PublicKey publicKey = RSA.getPublicKeyKey("a.pub", "RSA");
		PrivateKey privateKey = RSA.getPrivateKey("a.pri", "RSA");
		//獲取數字簽名
		String signatureData = getSingnture(g,"sha256withrsa",privateKey);
		System.out.println(signatureData);
		//校驗簽名
		boolean b = verifySignature(g,"sha256withrsa",publicKey,signatureData);
		System.out.println(b);
	}
	
	/**
	 * 校驗簽名
	 * @param input	原文
	 * @param algorithm 表示算法
	 * @param publicKey	公鑰key
	 * @param signatureData	簽名密文
	 * @return
	 */
	
	public static boolean verifySignature(String input, String algorithm, PublicKey publicKey, String signatureData) throws Exception{
		//獲取簽名對象
		Signature signature = Signature.getInstance(algorithm);
		//初始化效驗
		signature.initVerify(publicKey);
		//傳入原文
		signature.update(input.getBytes());
		//校驗數據
		return signature.verify(Base64.decodeBase64(signatureData));
	}
	/**
	 * 生成數字簽名
	 * @param input	原文
	 * @param algorithm	表示算法
	 * @param privateKey	私鑰key
	 * @return
	 * @throws Exception 
	 */
	public static String getSingnture(String input, String algorithm, PrivateKey privateKey) throws Exception {
		//獲取簽名對象
		Signature signature = Signature.getInstance(algorithm);
		//初始化簽名
		signature.initSign(privateKey);
		//傳入原文
		signature.update(input.getBytes());
		//開始簽名
		byte[] sign = signature.sign();
		
		return Base64.encodeBase64String(sign);
	}
}
