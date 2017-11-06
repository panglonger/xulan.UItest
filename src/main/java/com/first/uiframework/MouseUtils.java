package com.first.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {
	
//	private WebDriver driver;
	private Actions action;
	
	
	public MouseUtils(WebDriver driver){
//		 this.driver=driver;
		 this.action=new Actions(driver);
	}
	
		//右击
	public void rightClick(WebElement e){
		action.contextClick(e).perform();
	}
	
	//双击
	public void doubleClick(WebElement e){
		action.doubleClick(e).perform();
	}
	//拖动
	
	//悬停
	
	
	
}



