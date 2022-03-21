package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
		//xpath = //*[@attribute='value']
		//Xpath = //*[contains(@type,'values')]
		// starts-with 
		// text()   - //button[text()='Login to Account']
		////h3[text()=' Web login ']
		////input[@id='email_field']//following::button[1]
		
		
		// id , name , cssSelector , xpath 
		
		WebElement email= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/input[1]"));
		email.sendKeys("admin123@gmail.com");
		WebElement password= driver.findElement(By.xpath("//input[@id='email_field']//following::input"));
		password.sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.cssSelector("#name")).sendKeys("Jnanesh");
		driver.findElement(By.id("lname")).sendKeys("Jnanesh");
		driver.findElement(By.id("personaladdress")).sendKeys("Jnanesh");
		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		
		WebElement citydropdown = driver.findElement(By.id("city"));
		
		Select City = new Select(citydropdown);
		City.selectByVisibleText("GOA");
		City.selectByValue("newdelhi");
		City.selectByIndex(4);
		
		  
		
		
		
	}
	

}
