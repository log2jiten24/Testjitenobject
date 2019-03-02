package Newpackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import functionlibrary.*;
import com.google.common.io.Files;
import org.apache.tools.ant.util.FileUtils;
public class Testngpractice {

	static WebDriver driver ;
	String baseUrl = "https://www.google.co.in/";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	@Test (priority = 1 , description = "open the url" , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);	
    //take the screenshot of url opened
	Reusablefunctions.capturescreenshot(driver, "Googlepageopened");
	
	System.out.println ("Screenshot captured while opening google page");
	
	}
	
	@Test (priority = 2 ,description = "search of testing ",enabled = true)
	public void clickurl () {
	//type the keyword
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testing");
	//implicit wait 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//capturescreenshot
	Reusablefunctions.capturescreenshot(driver, "Testing text typed");
	System.out.println ("Screenshot captured while typing testing");
	}
	
   @Test (priority = 3 , description = "click on testing definition", enabled = true)
    public void clickontesting () {
	   
//   List <WebElement> allelements = driver.findElements(By.xpath("//b"))	 ;  
//   //iterate through each element and click on testing definition 
//   for (WebElement items : allelements) {
//  
//   if (allelements.toString().equalsIgnoreCase("testing definition"))
//   {
//	   items.click();
//	   //takescreenshot for the testing definition to be clicked
    driver.findElement(By.xpath("//b[contains(text(),'jobs in sydney')]")).click();
    Reusablefunctions.capturescreenshot(driver, "click done successfully");
    
	System.out.println ("Screenshot captured while typing testing");   
   }
       
   @AfterTest
 //  public void close (ITest result) {
   
   public void close () {
	   
//	  if (ITestResult.FAILURE == result.getTestName())
//	  {
//		  
//	  }
	   
	//close the browser 
	driver.quit();	   
	   
   }
}
