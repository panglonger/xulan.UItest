package com.first.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.first.configs.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;
import com.first.utils.xmlUtils;

public class LoginPage extends BasePage{ 
	

//	private WebElement usernameInputBox;
//	private WebElement passwordInputBox;
//	private WebElement loginButton;
	private Alert alert;
	Locator usernameInputbox=getLocator("usernameInputbox");
	Locator passwordInputbox=getLocator("passwordInputbox");
	Locator loginButton=getLocator("loginButton");
	
//	Locator usernameInputbox=xmlUtils.readElementInfo("LoginPage.xml").get("usernameInputbox");
//	Locator passwordInputbox=xmlUtils.readElementInfo("LoginPage.xml").get("passwordInputbox");
//	Locator loginButton=xmlUtils.readElementInfo("LoginPage.xml").get("loginButton");

	
	public WebDriver getDriver(){
		return driver; 
	}
	//构造函数
	public LoginPage(WebDriver driver){
		
		super(driver); 
		openWeb(LocalConfig.URL);
//		driver.get(LocalConfig.URL);
		
//		usernameInputBox=findElement("css","input#account");		
//		passwordInputBox=findElement("css","input[name='password']");	
//		loginButton=findElement("css","button#submit");
				
	}
	
	
	
	//登录成功业务
	public MainPage loginOperate(String name,String password){
		input(usernameInputbox,name);//usernameInputBox.sendKeys(name);
		input(passwordInputbox,password);//passwordInputBox.sendKeys(password);
		click(loginButton);//loginButton.click();
		wait(3);
		return new MainPage(driver);
	}
	//登录失败业务
	public String loginFailOperate(String name,String password){
		input(usernameInputbox,name);//usernameInputBox.sendKeys(name);
		input(passwordInputbox,password);//passwordInputBox.sendKeys(password);
		click(loginButton);//loginButton.click();
		wait(3);
		
		String value=getalertText();
		
		
//		alert=driver.switchTo().alert();
//		String value=alert.getText();
//		System.out.println(value);
		//alert.accept();
		return value;
	}
	
	
	
}
