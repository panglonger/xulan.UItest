package com.first.testcase;

import org.testng.annotations.Test;

import com.first.pages.LoginPage;
import com.first.pages.MainPage;
import com.first.uiframework.DriverFactory;
import com.first.utils.AssertUtils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils;
 
	@BeforeMethod
	public void beforeMethod() {
		try{
		assertUtils=new AssertUtils();
		driver=DriverFactory.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}catch(Exception e){
			Assert.fail("测试初始化报错");
	}
		} 
 
 
	@Test
	public void loginTest01() {
		LoginPage lp=new LoginPage(driver);
		MainPage mp=lp.loginOperate("admin", "123456");
		String value=mp.getLoginUserName();
	
		Assert.assertEquals(value.contains("admin"), true,"登陆测试失败");
  }
    
	@Test 
	public void loginTest02(){
		LoginPage lp=new LoginPage(driver);
		String value=lp.loginFailOperate("admin", "123");
		assertUtils.checkContains(value, "登录失败","登陆测试失败");
//		Assert.assertEquals(value.contains("登录失败"), true,"登陆测试失败");

  }
  

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
  }

}
