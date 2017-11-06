package com.first.uiframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.first.configs.LocalConfig;
import com.first.utils.Log;

public class DriverFactory {
	private static WebDriver driver;
	static Runtime runtime=Runtime.getRuntime();
	private static Log log=new Log(DriverFactory.class);
	
	public static WebDriver getChromeDriver(){
		
		try {
			runtime.exec("taskkill /F /IM chromr.exe");
			log.info("杀死chrome浏览器进程成功");
		} catch (IOException e) {
			log.error("杀进程出现异常");
		}
		
		 //读取去掉所在的路径
		String driverPath=System.getProperty("user.dir")+LocalConfig.CHROME_PATH;
		System.setProperty("webdriver.chrome.driver",driverPath);
		
		//去黄条
		ChromeOptions options=new ChromeOptions();
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type","--start-maximized");
		
		driver=new ChromeDriver(options);
		
		return driver;
		
	
	}
}
 