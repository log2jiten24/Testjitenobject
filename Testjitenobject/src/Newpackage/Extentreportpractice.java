package Newpackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import functionlibrary.*;

public class Extentreportpractice  {
	
	static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	public ExtentReports report;
	public ExtentTest logger ;
	
	
	
	
//	@BeforeMethod
//	public void beforemethod() {
//	//create object of ExtentHTMLTeporter
//	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OpenHRMpage.html")) ;
//	report = new ExtentReports ();
//	report.attachReporter(extent);	
//	}
	
	@BeforeTest ( description = "launching of  chrome browser")
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
	
	//logger.info("Launching of url");
    //take the screenshot of url opened
	Reusablefunctions.capturescreenshot(driver, "OrangeHRM page opened");
	
	System.out.println ("Screenshot captured while opening HRM  page");
	
//	Reusablefunctions.ExtentReports();
//	logger = report.createTest("Opening the OrangeHRM url");	
//	logger.pass("URL Launched succesfully");

	}
	
	@Test (priority = 2 , description = "login hrm page " , enabled = true)
	public void loginOrangeHRM() throws Exception 
	{
	
		
	//add implicit wait 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
	//input username
	driver.findElement(By.xpath("//*[@id = 'txtUsername']")).sendKeys("Admin");
	//input password
	driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
	
	//take the screenshot of entering details
	Reusablefunctions.capturescreenshot(driver, "OrangeHRM login details entered");
	System.out.println ("Screenshot captured while entering  HRM  page details");
	
	//click on login button
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click(); 
	Thread.sleep(3000);
//	Reusablefunctions.ExtentReports();
//	logger = report.createTest("Login HRM login page");	
//	logger.info("login details entered");
//	logger.pass("Login happened successfully");
	}
	
	@Test (priority = 3, description = "click on welcome admin and logout" , enabled = true)
	public void logoutHRM() throws Exception 
	{
		
	//take the screenshot of entering details
	Reusablefunctions.capturescreenshot(driver, "orangehrm page login happened");
	System.out.println ("login happened successfully");	
	
	//store the webelement 
	WebElement element = driver.findElement(By.xpath("//a[@id='welcome']")) ;
			
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element) );
	
	//click the element 
	element.click();
	Thread.sleep(2000);
	
	//click on logout 
	WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]")) ;
	logout.click();
//	Reusablefunctions.ExtentReports();
//	logger = report.createTest("Logout HRM  page");
//	
//	logger.info("Logout of hrm page");
//	logger.pass("logout happened successfully");
	
	//take the screenshot of entering details
    Reusablefunctions.capturescreenshot(driver, "logout successfully  happened");
    System.out.println ("logout  happened successfully");	
	
    String actualTitle = driver.getTitle();
    String expectedTitle = "OrangeHRM";
    Assert.assertEquals(expectedTitle,actualTitle);
    System.out.println("driver title :" + actualTitle) ;
    
	
	}
	
	@AfterTest(description = "close the browser")
	public void closebrowser () {
		
	driver.close();	
	
	//report.flush(); 
	}
	
	
}
