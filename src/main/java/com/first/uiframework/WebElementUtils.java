package com.first.uiframework;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.first.uiframework.Locator.ByType;
import com.first.utils.xmlUtils;

public class WebElementUtils extends DriverUtils{

	protected HashMap<String,Locator> locatorMap;
	protected String path;
	
	public WebElementUtils(WebDriver driver) {
		super(driver);
		path=System.getProperty("user.dir")+"/webelementdata/"
				+this.getClass().getSimpleName()+".xml"; 
		locatorMap=xmlUtils.readElementInfo(path);
	}

	
	//1.获取元素getElemennt
	public WebElement getElement(Locator locator){
		WebElement el = null;
		ByType type=locator.getBytype();
		try{ 
		switch(type){
		case id:
			el=driver.findElement(By.id(locator.getLocatorInfo()));
			break;
		case name:
			el=driver.findElement(By.name(locator.getLocatorInfo()));
			break;
		case className: 
			el=driver.findElement(By.className(locator.getLocatorInfo()));
			break;
		case xpath:
			el=driver.findElement(By.xpath(locator.getLocatorInfo()));
			break;
		case cssSelector:
			el=driver.findElement(By.cssSelector(locator.getLocatorInfo()));
			break;
		case linkText:
			el=driver.findElement(By.linkText(locator.getLocatorInfo()));
			break;
		case tagName:
			el=driver.findElement(By.tagName(locator.getLocatorInfo()));
			break;
		case partialLinkText:
			el=driver.findElement(By.partialLinkText(locator.getLocatorInfo()));
			break;
		}}catch(Exception e){
			takeScreenShot("findElementErrorImage");
			log.info("元素:"+locator.getElementName()+"识别异常");
			Assert.fail("查找元素异常，退出当前测试用例");
		}
		return el;
	}
	
	//2.使用显示等待方法，查找元素
	public WebElement findElement(final Locator locator){
		WebDriverWait wait=new WebDriverWait(driver,locator.getTimeOut());
		WebElement el=wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return getElement(locator);
			}
		});
		return el; 
}
	
//	点击、输入、提交、查找元素、获取元素属性、获取元素文本
	
	
	//3.click：单击对象
	public void click(Locator locator){
		WebElement e=findElement(locator);
		e.click();
		log.info("点击元素  "+locator.getElementName());
	} 
	//4.sendkeys:输入
	public void input(Locator locator,String content){
		WebElement e=findElement(locator);
		e.sendKeys(content);
		log.info("在元素  "+locator.getElementName()+"输入"+content);

	}
	
	//5.gettext:获取元素文本
	public String getText(Locator locator){
		WebElement e=findElement(locator);
		log.info("获取元素：  "+locator.getElementName()+"文本值");

		return e.getText();
	}
	//6.getattibute:获取元素属性
	public String getAttribute(Locator locator,String attribute){
		WebElement e=findElement(locator);
		return e.getAttribute(attribute);
	}
	//7.sunmit:提交
	public void submit(Locator locator){
		WebElement e=findElement(locator);
		e.submit();
	}
	 public Locator getLocator(String locatorName){
		 Locator locator=locatorMap.get(locatorName);
		 return locator;
	 }
		
}
