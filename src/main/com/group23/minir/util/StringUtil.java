package com.group23.minir.util;

/**
 * 字符串工具类
 * @author Group 23
 * @version 1.0
 */

public class StringUtil {
	/**
	 * 判断字符串内容是否是空
	 * @param str 需要判断的字符串
	 * @return result 判断结果，若字符串内容为空则返回true，否则返回false
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串内容是否不为空
	 * @param str 需要判断的字符串
	 * @return result 判断结果，若字符串内容不为空则返回true，否则返回false
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
