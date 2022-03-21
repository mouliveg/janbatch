package com.training.selenium;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	static WebDriver driver;
	static Actions action;

	public static void login() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/input[1]"));
		email.sendKeys("admin123@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='email_field']//following::input"));
		password.sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
	}

	public static void openWindows() {

		action = new Actions(driver);

		WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SwitchTo));
		action.moveToElement(SwitchTo).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
	}

	

	public static void openTabs() {

		action = new Actions(driver);
		WebElement SwitchToTab = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SwitchToTab));
		action.moveToElement(SwitchToTab).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Tabs')]")).click();
	}


	
	public static void Tooltip() {
		
		String PageTitle = driver.getTitle();
		
		String ExpectedTitle ="Selenium";
		
		AssertJUnit.assertEquals(PageTitle, ExpectedTitle);
		
		action = new Actions(driver);
		WebElement Interactions = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Interactions));
		action.moveToElement(Interactions).build().perform();
		
		WebElement mousehover = driver.findElement(By.linkText("Mouse")); 
		action.moveToElement(mousehover).build().perform();
		
		/*
		 * WebElement toolTipLink=
		 * driver.findElement(By.xpath("//a[normalize-space()='Tool Tip']"));
		 * wait.until(ExpectedConditions.visibilityOf(toolTipLink));
		 * toolTipLink.click();
		 * 
		 * WebElement toolTipRight = driver.findElement(By.className("tooltipr"));
		 * action.moveToElement(toolTipRight).build().perform();
		 * 
		 * WebElement toolTipRightText =
		 * driver.findElement(By.className("tooltiptextl")); String ToolTipText =
		 * toolTipRightText.getText(); System.out.println(ToolTipText); String
		 * ExpectedToolTip = "Right"; Assert.assertEquals(ToolTipText, ExpectedToolTip);
		 */

	}
	
	
	public static void autocomplete(String auto, String Country ) {
		
		action = new Actions(driver);
		WebElement Widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Widget));
		action.moveToElement(Widget).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]")).click();
		driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys(auto);
		List<WebElement> countryList = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
		
		  for(int i=0; i<countryList.size();i++) {
		  System.out.println(countryList.get(i).getText());
		  
		  String ExpCountry = countryList.get(i).getText();
		  if(ExpCountry.equalsIgnoreCase(Country)) { countryList.get(i).click(); }
		  
		 		  
		  
		  }
		 
	}
	
	
public static void autocomplete(String auto, int position ) {
		
		action = new Actions(driver);
		WebElement Widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Widget));
		action.moveToElement(Widget).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]")).click();
		driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys(auto);
		List<WebElement> countryList = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
		countryList.get(position).click();
		takeScreenShot(driver);
		 
	}


public static void takeScreenShot(WebDriver driver){
	
	TakesScreenshot screenShot = ((TakesScreenshot)driver);
		File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
	
	 Date currentDate = new Date();
	 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
	 String fileSeperator = System.getProperty("file.separator");
	 String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "ScreenShots";
	 String reportFileName = "ScreenShort"+timeStamp+".png";
	 String filePath = reportFilepath+fileSeperator+reportFileName;
	 File destFile = new File(filePath);
	 try {
		FileUtils.copyFile(scrFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
}


public static void table() {
	
	action = new Actions(driver);
	WebElement Widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(Widget));	
	action.moveToElement(Widget).build().perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
	
	List<WebElement> tableHeader = driver.findElements(By.xpath("//th"));
	displayTableData(tableHeader);
	List<WebElement> firstrow = driver.findElements(By.xpath("//tr[2]/td"));
	
	for(WebElement element:firstrow) {
		System.out.println(element.getAttribute("value"));
	}
	
	//displayTableData(firstrow);
	
	
	//table[@id='customers']/tbody/tr[2]/td
	
	
}


public static void displayTableData(List<WebElement> elementList) {
	
Iterator<WebElement> iter = elementList.iterator();

while (iter.hasNext()) {
	System.out.println(iter.next().getText());
	System.out.println("\t");
	
}
	
}


public static void windowsExample() {
	
	action = new Actions(driver);
	WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(SwitchTo));	
	action.moveToElement(SwitchTo).build().perform();
	driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();

	driver.findElement(By.xpath("(//button[contains(text(),'Click To Open New')])[2]")).click();
	String parentwindow= driver.getWindowHandle();
	System.out.println(parentwindow);
	
	System.out.println(driver.getWindowHandles().size());
	
	for(String handle:driver.getWindowHandles()) {
		System.out.println("No of Handles" +handle);
		driver.switchTo().window(handle);
	}
	
	driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.switchTo().window(parentwindow);
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

}





	

}
