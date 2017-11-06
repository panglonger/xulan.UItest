package com.first.uiframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtils{

	public BasePage(WebDriver dr){
		super(dr);
	}
	
	//获取网页源代码、js弹窗的问题 、frame...
	
	//1.获取网页源代码
	public String getPageSource(){
		wait(3);
		return driver.getPageSource();
	}
	//2.js提示框:确认
	public void alertAccpet(){
		Alert alert=driver.switchTo().alert();
		alert.accept();	
	}
	//3.js提示框:取消
	public void alertDismiss(){
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	//4.js提示框:输入数据
	public void inputAlert(String value){
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	//5.获取提示信息
	public String getalertText(){
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	
	
}
