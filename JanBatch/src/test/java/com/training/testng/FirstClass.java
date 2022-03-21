package com.training.testng;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass {
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod() {
		
		System.out.println("First Class - Before Method");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Test1");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("First Class -After Method");		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("First Class - I am in After  Suite");
		
	}
	
	
	
	@Test (priority =2)
	@Parameters({"url","username","password","browser"})
	public void  test1(String url, String username,String password ,String browser ) {
		
		System.out.println("First Class - I am in Method1");
		System.out.println("URL ::: " +url);
		System.out.println("Username ::: " +username);
		System.out.println("password ::: " +password);
		
		
		Log.info("First Class - I am in Method1");
		Log.info("URL ::: " +url);
		Log.error("Password is Incorrect");
		Log.fatal("Some Fatel information - Database didnt connect");
		
		/*
		 * if(browser.equalsIgnoreCase("Chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * 
		 * } else {
		 * 
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * 
		 * }
		 */		
		Log.info("TEST IS PASSED");
	}
	
	@Test(priority =1)
	public void  test2() {
		
		System.out.println("First Class I am in Method2 ");
		
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("First Class After Test ");
		
	}
	
	

}
