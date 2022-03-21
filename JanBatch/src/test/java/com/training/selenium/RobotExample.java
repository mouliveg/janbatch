package com.training.selenium;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import java.awt.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotExample {

	
	public static void main(String[] args) throws AWTException, InterruptedException  {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Robot robot = new Robot();
		Thread.sleep(10000);
		robot.mouseMove(525,525);
		
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.mouseWheel(10);
		
		
		
		
		
	}
}
