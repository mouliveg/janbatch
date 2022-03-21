package com.training.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondClass {
	
	
	@BeforeTest
	
	public void beforeTest() {
		
		System.out.println("Second Class - I am in the Before Test method");
		
	}
	
	
	@Test
	public void test2() {
		
		System.out.println("Second Class - I am in Method2");
	}

	

	
}
