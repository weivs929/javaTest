/*  
 * @(#)DESPlus.java     1.0 2011/05/31      
 *      
 * Copyright (c) 2010 SHANGHAI BINGKUN DIGITAL TECHNOLOGY CO.,LTD       
 * All rights reserved      
 *      
 * This software is the confidential and proprietary information of         
 * SHANGHAI BINGKUN.("Confidential Information").  You shall not        
 * disclose such Confidential Information and shall use it only in      
 * accordance with the terms of the license agreement you entered into      
 * with SHANGHAI BINGKUN.       
 */

import java.security.Key;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public class DESPlus_pk {
	private static String strDefaultKey = "national";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 * @author <a href="mailto:leo841001@163.com">LiGuoQing</a>
	 */
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 默认构造方法，使用默认密钥
	 * 
	 * @throws Exception
	 */
	public DESPlus_pk() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * 指定密钥构造方法
	 * 
	 * @param strKey
	 *            指定的密钥
	 * @throws Exception
	 */
	public DESPlus_pk(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strKey.getBytes());

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**
	 * 加密字节数组
	 * 
	 * @param arrB
	 *            需加密的字节数组
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**
	 * 加密字符串
	 * 
	 * @param strIn
	 *            需加密的字符串
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public String encrypt(String strIn) throws Exception {
		return byteArr2HexStr(encrypt(strIn.getBytes()));
	}

	/**
	 * 解密字节数组
	 * 
	 * @param arrB
	 *            需解密的字节数组
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * 解密字符串
	 * 
	 * @param strIn
	 *            需解密的字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public String decrypt(String strIn) throws Exception {
		return new String(decrypt(hexStr2ByteArr(strIn)));
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 * 
	 * @param arrBTmp
	 *            构成该字符串的字节数组
	 * @return 生成的密钥
	 * @throws java.lang.Exception
	 */
	private Key getKey(byte[] arrBTmp) throws Exception {
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Map<String, String> testMap = new HashMap<String, String>();
			testMap.put("urlCherry",
							"jdbc:jtds:sqlserver://192.168.102.100:1433;DatabaseName=Cherry_PK;useLOBs=false");
			testMap.put("urlCherryConfig",
			"jdbc:jtds:sqlserver://192.168.102.100:1433;DatabaseName=CherryConfig;useLOBs=false");
			testMap.put("urlWitpos",
			"jdbc:jtds:sqlserver://192.168.102.100:1433;DatabaseName=witpos_pk;useLOBs=false");
			testMap.put("urlWitposIF",
			"jdbc:jtds:sqlserver://192.168.102.100:1433;DatabaseName=brand;useLOBs=false");
			testMap.put("DBuserName", "sa");
			testMap.put("DBpassWord", "0018$0018bBAQL");
			testMap.put("urlMQ","tcp://localhost:61616");
			testMap.put("MQuserName", "mq");
			testMap.put("MQpassWord", "binkun1234");
			testMap.put("MongoUserName", "webon");
			testMap.put("MongoPassWord", "webon1234");

			// String test = "Webon1234,.";
			// DESPlus des = new DESPlus();//默认密钥
			//String key1 = "f5a4897fsb778gkbi52ziou6nphq2syz0dpzb83hyrv0l9rrx4p3t37x77puv8extg9pb894kz5488ql5sgcb1zve6b88kv8iifmj9ptxquxke79x1q506wckzw81war";
			String key2 = "binkun";
			DESPlus des = new DESPlus(key2);// 自定义密钥
			//System.out.println("Mongo_User=" + des.decrypt("5b613728762b92a2770aa998f2ed46b5"));
		//	System.out.println("jdtsUrl=" + des.decrypt("659a1be40ac0502da6c61c943868548c87eea0cbe3f27be46b84fa8506028369664b7638972c8f996e1a545fe41709a7937321254b204ad0640c354d6126af8c20be1a18b4bc46b9"));
			// System.out.println(Integer.MAX_VALUE);
			for (Map.Entry<String, String> en : testMap.entrySet()) {
				System.out.println("加密前的字符：" + en.getKey() + "="
						+ en.getValue());
				System.out.println("加密后的字符：" + en.getKey() + "="
						+ des.encrypt(en.getValue()));
			//	System.out.println("解密后的字符：" + en.getKey() + "="+ des.decrypt(des.encrypt(en.getValue())));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
