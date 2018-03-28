package com.guo.goldenpenguin.encryption;

import java.security.MessageDigest;

/**
 * MD5加密
 * @Description:
 * @author:ZhongGaoYong 
 * @see:   
 * @since:      
 * @copyright www.wozhongla.com
 * @Date:2014-12-5
 */
public class MD5 {

	/**
	 * MD5加密
	 * @Description:
	 * @param str
	 * @return
	 * @see: 
	 * @since: 
	 * @author:www.wozhongla.com
	 * @date:2014-12-5
	 */
	public static String getMd5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	// 可逆的加密算法
	public static String encryptmd5(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'l');
		}
		String s = new String(a);
		return s;
	}
}