package com.first.utils;

import junit.framework.Assert;
 
public class AssertUtils {
	
	//1.比较整数
	public void checkIntNUm(int actual,int expected,String...com){
		try{
			Assert.assertEquals(actual, expected);
			}catch(AssertionError e){
			Assert.fail("断言失败");
			}
		
	}
	
	//2.比较字符串
	public void checkString(String actual,String expected,String...com){
		Assert.assertEquals(expected, actual);
	} 
	
	//3.比较字符串包含
	public void checkContains(String actual,String expected,String...com){
		Assert.assertEquals(true, actual.contains(expected));
	}
	//4.非空
	public void checkNotNull(Object actual,String...com){
		Assert.assertNotNull(actual);
	}
	//实型
	
}
