package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExample {
	
	public static void main(String[] args) {
		
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.switchTo().frame("marketing");
		
		driver.findElement(By.xpath("(//div[contains(@class,'btn-container')])[1]")).click();
		
		
	}
	

}
