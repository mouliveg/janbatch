package com.training.selenium;

import java.util.Iterator;
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

public class TableExample {

	
	public static void main(String[] args) throws AWTException, InterruptedException  {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		displayTableData(tableHeader);
	
		
		
		List<WebElement> firstrow = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
		displayTableData(firstrow);
		
		List<WebElement> secondRow = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[3]/td"));
		displayTableData(secondRow);
		
		List<WebElement> TableData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
		validatetableData(TableData,"Yoshi Tannamuri");
		
		
		
	}
	
	public static void validatetableData(List<WebElement> elementList, String Expectedvalue) {
		
		Iterator<WebElement> iter = elementList.iterator();

				while (iter.hasNext()) {
					String Actualvalue = iter.next().getText();
					if(Actualvalue.equalsIgnoreCase(Expectedvalue)) {
						System.out.println("Expected Value present in the table"+Actualvalue);
						
					}
					System.out.print("\t");
					
				}
				System.out.println();
			
		}


	public static void displayTableData(List<WebElement> elementList) {
		
	Iterator<WebElement> iter = elementList.iterator();

			while (iter.hasNext()) {
				System.out.print(iter.next().getText());
				System.out.print("\t");
				
			}
			System.out.println();
		
	}
}
