package com.training.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWait {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		WebDriver driver; 
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@id='email_field']//following::input")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		Actions action = new Actions(driver);
		
		WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOf(SwitchTo));
		 */
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(20,TimeUnit.SECONDS);
		wait.pollingEvery(200,TimeUnit.MILLISECONDS);
		
		
		
		wait.until(ExpectedConditions.visibilityOf(SwitchTo));
		
		action.moveToElement(SwitchTo).build().perform();
		wait.until(ExpectedConditions.visibilityOf(SwitchTo));
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]")).click();
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]")).click();
		
		//driver.switchTo().alert().sendKeys("Jnanesh");
		
		driver.switchTo().alert().accept();
	}

}
