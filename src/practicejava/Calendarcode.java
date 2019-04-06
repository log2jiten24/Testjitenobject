package practicejava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import functionlibrary.*;

public class Calendarcode {

	static WebDriver driver ;
	String baseUrl = "http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html";
	
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
	
	@Test (description = "verifying the calendar changes")
	public void verifycalendar () throws Exception {
	
	//Add implicit wait
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
    
    //click on calendar
    WebElement calendar = driver.findElement(By.xpath("//input[@type='text']")) ;
    calendar.click();
    
    List <WebElement> alldates = driver.findElements(By.xpath("//a[@class='ui-state-default']")) ;
	
    for (WebElement dates : alldates)
    {
    if (dates.getText().equalsIgnoreCase("10")) {
    dates.click();
    Thread.sleep(5000);
    Reusablefunctions.capturescreenshot(driver, "click date successfull");
    break ;
    }
    System.out.println ("all dates present:" + dates.getText()) ;
    }
		
	}
	
	@AfterTest
	public void closebrowser() 
	{
	driver.close();	
	}	
}
