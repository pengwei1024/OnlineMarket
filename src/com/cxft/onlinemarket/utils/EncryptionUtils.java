package com.cxft.onlinemarket.utils;

import java.util.Random;


/**
 * 加密类
 * 密码和token的加密算法
 * @author pengwei
 *
 */
public class EncryptionUtils {
	
	/**
	 * 加密密码
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public static String createPwd(String uid,String pwd){
		String uidEncode = Sha1Util.encode(uid).substring(0,10);
		String sign="cxft";
		String pwdEncode = Sha1Util.encode(pwd).substring(10,20);
		return Sha1Util.encode(uidEncode+sign+pwdEncode);
	}
	
	/**
	 * 加密啊token
	 * @param uid
	 * @return
	 */
	public static String createToken(String uid){
		String time = String.valueOf(TimeUtil.getCurrentTime());
		Random rd=new Random();
		int num = rd.nextInt(100000);
		return Sha1Util.encode(time+"%"+uid+"&"+time+"*"+num);
	}
	
}
