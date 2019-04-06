package practicejava;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWait {
	
//1-Fluent wait is a class and is part of org.openqa.selenium.support.ui Package
//2-It is an implementation of Wait interface.
//3-Each fluent wait instance defines the maximum amount of time to wait for a condition and 
//we can give the frequency with which to check the condition.
//Fluent wait defines the maximum amount of time to wait for the condition to appear and we 
//can give the frequency with which to check the condition .
	
	
	static WebDriver driver ;
	String baseUrl = "http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
		driver.navigate().to(baseUrl);
	}
	
	@Test (description = "verifying the FLuent wait changes")
	public void verifyfluentwait () {
	//Click on start timer
	WebElement timer = driver.findElement(By.xpath("//button[@onclick='timedText()']"))	;
	timer.click();
	//it will fail - no such element found exceprion , but its getting passed 
//	boolean status = driver.findElement(By.xpath("//p[contains(text(),'WebDriver')]")).isDisplayed() ;
//	if (status)
//	System.out.println ("Test case passed")	;	
//	}
	
	// Create object of FluentWait class and pass webdriver as input
	 
   //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	org.openqa.selenium.support.ui.FluentWait<WebDriver>wait =
	new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver) ;

    // It should poll webelement after every single second
    wait.pollingEvery(1, TimeUnit.SECONDS);
   // Max time for wait- If conditions are not met within this time frame then it will fail the script
    wait.withTimeout(10, TimeUnit.SECONDS);
 // we are creating Function here which accept webdriver and output as WebElement-
    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
 
    	public WebElement apply(WebDriver arg0) 
    	{
    	  // find the element
    	 WebElement ele = arg0.findElement(By.xpath("//p[@id='demo']"));
    	 // Will capture the inner Text and will compare will WebDriver
    	 // If condition is true then it will return the element and wait will be over
    	  if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) 
    	   {
          System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
    	 return ele ;
 // If condition is not true then it will return null and it will keep checking until condition is not true
    	   }else {
    	        System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
    	 return null;
    	 }
    	  }
    	  });
    	 // If element is found then it will display the status
  System.out.println("Final visible status is >>>>> " + element.isDisplayed());
    	 
    	     
	}
	
	@AfterTest
	public void closebrowser() 
	{
	driver.close();	
	}
	  }

