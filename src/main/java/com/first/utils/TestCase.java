package com.first.utils;

import java.util.HashMap;
import java.util.Map;

public class TestCase {
	private String caseName=null;
	private String isCheck=null;
	private String expectedResult=null;
	private Map<String,String> testdata=new HashMap<String,String>();

	
	public TestCase(String name,String check,String result,Map<String,String> testDate2){
		this.caseName=name;
		this.isCheck=check;
		this.expectedResult=result;
		this.testdata=testDate2;
	}

	

	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getIsCheck() {
		return isCheck;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	
}
