package com.training.test;

import org.testng.annotations.Test;

import com.training.selenium.BaseTest;

public class LoginTest extends BaseTest {
	
	
	@Test
	public static void verifyLogin() {
		login();
	}
	
	@Test
	public static void verifywindowsFunctionality() {
		login();
		openWindows();
		
	}
	
	@Test
	public static void verifyToolTip() {
		login();
		Tooltip();
		
	}
	
	@Test
	public static void verifytab() {
		login();
		openTabs();
		
	}
	
	
	@Test
	public static void verifyAutocomplete() {
		login();
		//autocomplete("I","India");
		autocomplete("Uni",2);
		
		
	}
	

	@Test
	public static void verifyWindows() {
		login();
		windowsExample();	
		
	}
	
	
	
}
