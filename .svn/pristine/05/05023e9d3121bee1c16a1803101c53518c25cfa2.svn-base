package com.cxft.onlinemarket.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodeUtil {
	
	
	/**
	 * 转化为utf-8
	 * @param str
	 * @return
	 */
	public static String ToUtf8(String str){
		try {
			return URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;		
	}
	
	/**
	 * 将ISO-8859-1转化为utf-8
	 * @param str
	 * @return
	 */
	public static String decodeUtf8(String str){
		try {
			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return str;
		}
	}

}
