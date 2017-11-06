package com.first.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;



public class MainPage extends BasePage{  
	
	
	
	public MainPage(WebDriver driver){
		super(driver);
		
	}
	Locator userMenu=getLocator("userMenu");
	public String getLoginUserName(){
		wait(3);
		return getText(userMenu);
	}
}
