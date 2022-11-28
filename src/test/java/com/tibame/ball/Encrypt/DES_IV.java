package com.tibame.ball.Encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;



/**
 * DES
 * @author linfuli
 * 對稱加密
 */
public class DES_IV {
	public static void main(String[] args) throws Exception {
		//原文 如果使用NoPadding模式，那麼原文必須是8個字節的整數倍
		String input = "淡水12";
		//定義Key
		//如果使用DES加密，必須是8個字節
		String key = "12345678";
		//算法 gdaVWMnwqck=
//		String transformation = "DES";
		//ECB：表示加密模式
		//PKCS5Padding：表示填充模式 gdaVWMnwqck= 
		//只寫DES默認就是 DES/ECB/PKCS5Padding
//		String transformation = "DES/ECB/PKCS5Padding";
		//aXxmAXOB9hE=
//		String transformation = "DES/CBC/PKCS5Padding";
		//7wzML66Ix9U=
		String transformation = "DES/CBC/NoPadding";
		//加密類型
		String algorithm = "DES";
		//指定獲取密鑰的算法
		String result = encrypt(input, key, transformation, algorithm);
		System.out.println(result);
		//指定解開密藥的算法
		String answer = decrypt(result,key,transformation,algorithm);
		System.out.println(answer);
	}
	
	/**
	 * DES解密數據
	 * @param result 加密文
	 * @param key	鑰匙
	 * @param transformation 算法
	 * @param algorithm	類型
	 * @return
	 * @throws Exception 
	 */
	private static String decrypt(String result, String key, String transformation, String algorithm) throws Exception {
		Cipher cipher = Cipher.getInstance(transformation);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
		//創建Iv向量是使用到CBC加密模式才需要
		//使用Iv向量進行加密時，也必須是8個字節
		IvParameterSpec iv = new IvParameterSpec("87654321".getBytes());
		//Cipher.DECRYPT_MODE:表示解密
		//解密規則
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,iv);
		
		//解密，傳入密文
		byte[] bytes =  cipher.doFinal(Base64.decodeBase64(result));
		
		return new String(bytes);
	}
	/**
	 * DES加密數據
	 * @param input 原文
	 * @param key	鑰匙
	 * @param transformation 算法
	 * @param algorithm		類別
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String input, String key, String transformation, String algorithm)
			throws Exception {
		//創建加密對象
		Cipher cipher = Cipher.getInstance(transformation);
		//加密規則
		//第一個參數代表key的字節
		//第二個參數代表加密類型
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
		//創建Iv向量是使用到CBC加密模式才需要
		//使用Iv向量進行加密時，也必須是8個字節
		IvParameterSpec iv = new IvParameterSpec("87654321".getBytes());
		//進行加密初始化
		//第一個參數代表模式，加密模式、解密模式
		//第二個參數代表加密規則
		cipher.init(cipher.ENCRYPT_MODE,secretKeySpec,iv);
		//調用方法
		//參數表示原文的字節陣列
		byte[] bytes = cipher.doFinal(input.getBytes());
//		for (byte b : bytes) {
//			System.out.println(b);
//		}
//		//印出密文
//		//如果直接印會出現亂碼
//		//因為在ascii碼沒有所以亂碼
//		System.out.println(new String(bytes));
		//創Base64對象，透過Base64把亂碼重翻
		//輸出加密後的數據
		String encode = Base64.encodeBase64String(bytes);
		return encode;
	}
}
