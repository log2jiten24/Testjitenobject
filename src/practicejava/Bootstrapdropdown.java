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

public class Bootstrapdropdown {
	
	static WebDriver driver ;
	String baseUrl = "http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";
	
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
	public void verifydropdown () {
   //Add implicit wait	
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
   //click on Tutorials
   WebElement tutorial = driver.findElement(By.xpath("//button[@type='button']")) ;
   //click on tutorial link
   tutorial.click();
   
   //take down the relative xpath fo all the dropdown box inside the list 
   
   List <WebElement> alllist = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']//li/a")) ;
   
//   for (int i = 0 ; i < alllist.size(); i++) {
//   WebElement elements = alllist.get(i);
//   String text = elements.getAttribute("innerHTML");
//   
//  if (text.contentEquals("JavaScript")) {
//	elements.click();
////take screenshot	
//Reusablefunctions.capturescreenshot(driver, "dropdownboxclicked");
//   break ;
//	 }
//   System.out.println ("values from downlist :" + text) ;
//   }

   //using for each loop
   
   for (WebElement menu : alllist) {

	if (menu.getAttribute("innerHTML").contentEquals("JavaScript"))  {
	menu.click();
////take screenshot	
  Reusablefunctions.capturescreenshot(driver, "dropdownboxclicked");
  break ;
	}
	System.out.println ("values from downlist :" + menu.getAttribute("innerHTML")) ;
   }
   
	}
	
	@AfterTest
	public void closebrowser() 
	{
	driver.close();	
	}	
}
