package com.first.uiframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardUtils {
	private Actions action;
	
	public KeyBoardUtils(WebDriver driver){
		action=new Actions(driver);
	}
	
	//向下的按键
	public void pressDown(int times){
		try {
			Robot robot=new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
}
