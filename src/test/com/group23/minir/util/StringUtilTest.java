package com.group23.minir.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Group 23
* @createDate 2019年6月12日 下午10:18:01
* @version 1.0
*/
public class StringUtilTest {

	@Test
	public void testIsEmpty() {
		assertEquals(false, StringUtil.isEmpty("aaaaa"));
		assertEquals(true, StringUtil.isEmpty(null));
		assertEquals(true, StringUtil.isEmpty(""));
		assertEquals(true, StringUtil.isEmpty("    "));
	}

	@Test
	public void testIsNotEmpty() {
		assertEquals(true, StringUtil.isNotEmpty("aaaaa"));
		assertEquals(false, StringUtil.isNotEmpty(null));
		assertEquals(false, StringUtil.isNotEmpty(""));
		assertEquals(false, StringUtil.isNotEmpty("    "));
	}

}
