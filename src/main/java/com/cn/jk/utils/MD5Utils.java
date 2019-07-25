package com.cn.jk.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 完成密码加密
 */
public class MD5Utils {
	 public static String getMD5(String str) {

	        try {

	            // 生成一个MD5加密计算摘要

	            MessageDigest md = MessageDigest.getInstance("MD5");

	            // 计算md5函数

	            md.update(str.getBytes());

	            return new BigInteger(1, md.digest()).toString(16);

	        } catch (Exception e) {

	           e.printStackTrace();

	           return null;

	        }

	    }


	    public static String MD5(String s) {
	    	
	    	if(s==null) {
                s="0";
            }
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

	 

	        try {

	            byte[] btInput = s.getBytes();

	            // 获得MD5摘要算法的 MessageDigest 对象

	            MessageDigest mdInst = MessageDigest.getInstance("MD5");

	            // 使用指定的字节更新摘要

	            mdInst.update(btInput);

	            // 获得密文

	            byte[] md = mdInst.digest();

	            // 把密文转换成十六进制的字符串形式

	            int j = md.length;

	            char str[] = new char[j * 2];

	            int k = 0;

	            for (int i = 0; i < j; i++) {

	                byte byte0 = md[i];

	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];

	                str[k++] = hexDigits[byte0 & 0xf];

	            }

	            return new String(str);

	        } catch (Exception e) {

	            e.printStackTrace();

	            return null;

	        }

	    }

	 

	     public static void main(String[] args) {

	         String md5 = MD5Utils.MD5("root");

	         System.out.println(md5);

	         String md52 = MD5Utils.getMD5("123456");

	         System.out.println(md52);

	    }

	 

	}
