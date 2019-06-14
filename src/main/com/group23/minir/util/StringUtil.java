package com.group23.minir.util;

/**
 * �ַ���������
 * @author Group 23
 * @version 1.0
 */

public class StringUtil {
	/**
	 * �ж��ַ��������Ƿ��ǿ�
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return result �жϽ�������ַ�������Ϊ���򷵻�true�����򷵻�false
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж��ַ��������Ƿ�Ϊ��
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return result �жϽ�������ַ������ݲ�Ϊ���򷵻�true�����򷵻�false
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
