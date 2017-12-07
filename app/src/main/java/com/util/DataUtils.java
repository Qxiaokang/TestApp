package com.util;

import android.content.Context;
import android.content.res.Resources;

import java.util.regex.Pattern;

public class DataUtils{

	
	/**将16进制byte转为string显示*/
	public static String byte2Hex(byte[] data) {
		if ((data != null) && (data.length > 0)) {
			StringBuilder sb = new StringBuilder(data.length);
			byte[] arrayOfByte = data;
			int j = data.length;
			for (int i = 0; i < j; i++) {
				byte tmp = arrayOfByte[i];
				sb.append(String.format("%02X ", new Object[] { Byte.valueOf(tmp) }));
			}
			return sb.toString();
		}
		return "no data";
	}
	
	/**16进制字符串转换成byte[]*/
	public static byte[] hexStringToBytes(String hexString) {
	    if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }  
	    hexString = hexString.toUpperCase(); 
	    
	    int length = hexString.length() / 2; 
	    char[] hexChars = hexString.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	} 
	
	/**将int类型的数据转为16进制的byte数据*/
	public static byte int2byte(int data) {
		return (byte)(data&0xff);
	}
	
	private static byte charToByte(char c) {  
		return (byte) "0123456789ABCDEF".indexOf(c);  
	}  
	
	/**得到resouce对象*/
	public static Resources getResources(Context context) {
		return context.getResources();
	}
	
	/**
	 * dp-->px
	 * @param dp
	 * @return
	 */
	/*public static int dip2Px(int dp) {
		float density = getResources(getContext()).getDisplayMetrics().density;
		System.out.println("density:" + density);
		int px = (int) (dp * density + .5f);
		return px;
	}*/

	/**
	 * px-->dp
	 * @param
	 * @return
	 */
	/*public static int px2Dp(int px) {
		// px/dp = density;
		float density = getResources(getContext()).getDisplayMetrics().density;
		System.out.println("density:" + density);
		int dp = (int) (px / density + .5f);
		return px;
	}*/

	/**
	 * 匹配正则
	 * 获取需要的值
	 * @param str
	 * @return
	 */
	public static String matchRegex(String str, String regEx) {
		System.out.print("过滤前："+str);
		if(str==null||str.equals(""))
			return "";
		if(regEx==null||regEx.equals(""))
			return str;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if(!Pattern.matches(regEx, sb.toString())) {// 如果不匹配, 删掉最后一个
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		System.out.print("\n过滤后："+sb.toString());
		return sb.toString();
	}

}
