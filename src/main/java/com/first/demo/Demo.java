package com.first.demo;

import org.openqa.selenium.WebDriver;

import com.first.uiframework.DriverFactory;

public class Demo {

	public static void main(String[] args) {
//		PropertiesUtils propertiesUtils= new PropertiesUtils("local.properties");
//		String url=PropertiesUtils.getPropertieValue("url");
//		System.out.println(url);	
		
	WebDriver driver = DriverFactory.getChromeDriver();
	driver.get("https://www.baidu.com");
	
//		String path =System.getProperty("user.dir");
//		System.out.println(path+"\\WebDriver");
		 
		
		
	}

}
