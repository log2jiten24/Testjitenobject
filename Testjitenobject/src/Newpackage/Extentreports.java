package Newpackage ;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.reuablefunctionmaven.Reusablefunctions;
//import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import functionlibrary.*;



public class Extentreports {

	public ExtentReports report;
	public ExtentTest logger ;
	
	static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeSuite(description = "launching extent report")
	public void setup() {
	
		Reporter.log("Setting up reports and starting", true);
//		create object of ExtentHTMLTeporter
		//it will generate different reports as per different timestamp
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OpenHRMpage+"
       +Reusablefunctions.getCurrentDateTime() +".html")) ;
		report = new ExtentReports ();
		report.attachReporter(extent);	
		
		Reporter.log("Setting done and reporting started", true);
	}
	
	@BeforeTest ( description = "launching of  chrome browser")
	public void launchbrowser () {
		
		Reporter.log("Setting up reports and starting url and browser", true);
		
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		
		Reporter.log("Setting up reports and starting url and browser done ", true);
		
	}
	
	@Test (priority = 1 ,description = "open orange hrm page")
	public void openurl () {
		
		logger = report.createTest("Opening the OrangeHRM url");
		
		driver.get(baseUrl);
		 //take the screenshot of url opened
		Reusablefunctions.capturescreenshot(driver, "OrangeHRM page opened");
		
		System.out.println ("Screenshot captured while opening HRM  page");
		logger.info("Launching of url");
		logger.pass("URL Launched succesfully");
	}
	
	
	@Test (priority = 2 , description = "login hrm page " , enabled = true)
	public void loginOrangeHRM() throws Exception 
	{
	
	logger = report.createTest("Login HRM login page");
		
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
		
	logger.info("login details entered");
	logger.pass("Login happened successfully");
	
	}
	
	@Test (priority = 3, description = "click on welcome admin and logout" , enabled = true)
	public void logoutHRM() throws Exception 
	{
	
	logger = report.createTest("Logout HRM  page");	
		
	//take the screenshot of entering details
	Reusablefunctions.capturescreenshot(driver, "orangehrm page login happened");
	System.out.println ("login happened successfully");	
	
	//store the webelement 
	WebElement element = driver.findElement(By.xpath("//a[@id='welcome']")) ;
	
	//to add failure screenshot
	//logger.fail("logout didnt happened successfully") ;
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element) );
	
	//click the element 
	element.click();
	Thread.sleep(2000);
	
	//click on logout 
	WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]")) ;
	logout.click();
	
//	logger.fail("logout didnt happened successfully") ;
	
	//take the screenshot of entering details
    Reusablefunctions.capturescreenshot(driver, "logout successfully  happened");
   
	
    logger.info("Logout of hrm page");
    logger.pass("logout happened successfully");
	
	
	
    String actualTitle = driver.getTitle();
    String expectedTitle = "OrangeHRM";
    Assert.assertEquals(expectedTitle,actualTitle);
    System.out.println("driver title :" + actualTitle) ;
    
	
	}
	@AfterMethod
	public void addextentreport(ITestResult result) throws Exception {
	//adding extent report after each test 
	
		if (result.getStatus() == ITestResult.FAILURE) {
	//Reusablefunctions.capturescreenshot(driver, "failure screenshots");
	logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Reusablefunctions.takeScreenshot(driver)).build()) ;
	
		}	
	else if (result.getStatus()== ITestResult.SUCCESS) {
	logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Reusablefunctions.takeScreenshot(driver)).build());	
			
		}
	else if (result.getStatus()== ITestResult.SKIP)	{
	logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Reusablefunctions.takeScreenshot(driver)).build())	; 	
		}
		
		//adding test to the same report
	report.flush();
	
	}
	
	@AfterTest
	public void closebrowser () {
	
	driver.close();	
		
	}
}
