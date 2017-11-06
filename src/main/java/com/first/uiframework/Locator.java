package com.first.uiframework;

import com.first.uiframework.Locator.ByType;

public class Locator {
	
	public enum ByType{
		xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName;
	}
	private String elementName;
	private String locatorInfo;
	private int timeOut;
	private ByType byType;
	
	public Locator(String elementName,ByType byType, String locatorInfo,int timeOut){
		this.elementName=elementName;
		this.locatorInfo=locatorInfo;
		this.timeOut=timeOut;
		this.byType=byType;
	}

	public String getElementName() {
		return elementName;
	}

	public String getLocatorInfo() {
		return locatorInfo;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public ByType getBytype() {
		return byType;
	}
	
	
	
}
