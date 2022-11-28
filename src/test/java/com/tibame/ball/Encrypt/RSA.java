package com.tibame.ball.Encrypt;

import java.io.File;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * RSA
 * @author linfuli
 * throws Exception 
 */
public class RSA {
	public static void main(String[] args) throws Exception {
		String input = "淡水";
		//創建密鑰對
		//KeyPairGenerator
		String algorithm = "RSA";
		
//		//生成密鑰對並保存在本地文件中
//		generateKeyToFile(algorithm,"a.pub","a.pri");
		
		//讀取私鑰Key
		PrivateKey privateKey = getPrivateKey("a.pri",algorithm);
		System.out.println(privateKey);
		//讀取公鑰Key
		PublicKey publicKey = getPublicKeyKey("a.pub",algorithm);
		System.out.println(publicKey);
		
//		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
//		//生成密鑰對
//		KeyPair keyPair = keyPairGenerator.generateKeyPair();
//		//生成私鑰
//		PrivateKey privateKey = keyPair.getPrivate();
//		//生成公鑰
//		PublicKey publicKey = keyPair.getPublic();
//		//獲取私鑰得字節數組
//		byte[] privateKeyEncode = privateKey.getEncoded();
//		//獲取公鑰得字節數組
//		byte[] publicKeyEncode = publicKey.getEncoded();
//		//使用Base64進行轉碼
//		String privateEncodeString = Base64.encodeBase64String(privateKeyEncode);
//		String publicEncodeString = Base64.encodeBase64String(publicKeyEncode);
		//印出來
//		System.out.println("私鑰："+ privateEncodeString);
//		System.out.println("公鑰："+ publicEncodeString);
		
		//JAVA加密核心：Cipher
//		String encrypt = encryptRSA(algorithm, privateKey, input);
//		System.out.println(encrypt);
//		String decrypt = decryptRSA(algorithm, publicKey, encrypt);
//		System.out.println(decrypt);

	}
	/**
	 * 讀取公鑰
	 * @param pubPath 	公鑰路徑
	 * @param algorithm	算法
	 * @return
	 */
	public static PublicKey getPublicKeyKey(String pubPath, String algorithm)throws Exception {
		String publicKeyString = FileUtils.readFileToString(new File(pubPath),Charset.defaultCharset());
		//創建key工廠
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		//創建公鑰規則
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
		
		return keyFactory.generatePublic(keySpec);
	}
	/**
	 * 讀取私鑰
	 * @param priPath	私鑰路徑
	 * @param algorithm	算法
	 * @return	返回私鑰的Key對象
	 * @throws Exception 
	 */
	public static PrivateKey getPrivateKey(String priPath, String algorithm) throws Exception {
		String privateKeyString = FileUtils.readFileToString(new File(priPath),Charset.defaultCharset());
		//創建key工廠
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		//創建私鑰key的規則
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
		//返回私鑰對像
		return keyFactory.generatePrivate(keySpec);
	}
	/**
	 * 解密數據
	 * @param algorithm	：算法
	 * @param encrypted	：密文
	 * @param key	：密鑰
	 * @return :原文
	 * @throws Exception
	 */
		public static String decryptRSA(String algorithm,Key publicKey,String encrypted)throws Exception{
			//創建加密對象
			Cipher cipher = Cipher.getInstance(algorithm);
			//私鑰解密
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			//使用Base64轉碼
			byte[] decode = Base64.decodeBase64(encrypted);
			byte[] bytes1 = cipher.doFinal(decode);
			return new String(bytes1);
		}
	
	/**
	 * 使用密鑰加密數據
	 * @param algorithm	：算法
	 * @param input	：原文
	 * @param key	：密鑰
	 * @return :密文
	 * @throws Exception
	 */
		public static String encryptRSA(String algorithm,Key privateKey,String input)throws Exception{
			//創建加密對象
			Cipher cipher = Cipher.getInstance(algorithm);
			//對加密進行初始化
			//第一個參數：加密模式
			//第二個參數：想使用哪把鑰匙加密
			//使用私鑰加密
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			//使用私鑰進行加密
			byte[] bytes = cipher.doFinal(input.getBytes());
			return Base64.encodeBase64String(bytes);
		}
	
	
	
	
	/**
	 * 保存公鑰與私鑰保存在根目錄
	 * @param algorithm 算法
	 * @param pubPath 公鑰路徑
	 * @param priPath 私鑰路徑
	 * @throws Exception 
	 */
	private static void generateKeyToFile(String algorithm, String pubPath, String priPath) throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
		//生成密鑰對
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		//生成私鑰
		PrivateKey privateKey = keyPair.getPrivate();
		//生成公鑰
		PublicKey publicKey = keyPair.getPublic();
		//獲取私鑰得字節數組
		byte[] privateKeyEncode = privateKey.getEncoded();
		//獲取公鑰得字節數組
		byte[] publicKeyEncode = publicKey.getEncoded();
		//使用Base64進行轉碼
		String privateEncodeString = Base64.encodeBase64String(privateKeyEncode);
		String publicEncodeString = Base64.encodeBase64String(publicKeyEncode);
		//把公鑰與私鑰把存在根目錄
		FileUtils.writeStringToFile(new File(pubPath), publicEncodeString,Charset.forName("UTF-8"));
		FileUtils.writeStringToFile(new File(priPath), privateEncodeString,Charset.forName("UTF-8"));
	}
}
