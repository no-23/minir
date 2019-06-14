package com.group23.minir.core;

import static org.junit.Assert.*;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

/**
* @author Group 23
* @createDate 2019年6月12日 下午10:52:30
*/
public class RenamerTest {

	@Test
	public void testStart() {
		int result = 0;
		
		try {
			result = new Renamer("C:\\Users\\Faraday\\Documents\\testDir", ".*", 0, 1, "", "").start();
			assertEquals(16, result);
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			result = new Renamer("C:\\Users\\Faraday\\Documents\\testDir", "vdsavfsdafvasdfff", 0, 1, "", "").start();
			assertEquals(0, result);
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			result = new Renamer("C:\\Users\\Faraday\\Documents\\testDir", "2.*", 0, 1, "aa", "").start();
			assertEquals(1, result);
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
