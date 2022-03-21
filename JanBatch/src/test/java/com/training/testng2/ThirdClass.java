package com.training.testng2;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ThirdClass {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Third Class - I am in Before Suite");
	}
	
	@Test
	public void test2() {
		
		System.out.println("I am in Method3");
		
	}

}
