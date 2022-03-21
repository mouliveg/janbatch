package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSelenium {

	public static void main(String[] args) {

		/*
		 * Hyperlink radio button checkbox dropdown textbox button image
		 * 
		 * type of address name id xpath
		 * xpath
		 * 
		 * //tagname[@attribute='value']
		 * 
		 */

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jnanesh.m@tekarch.com");
		driver.findElement(By.name("pw")).sendKeys("password");
		driver.findElement(By.id("rememberUn1")).click();
		
	}

}
