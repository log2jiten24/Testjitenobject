package practicejava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoITimplement {
	
	static  WebDriver driver ;
	static String baseUrl = " https://www.engprod-charter.net/";
	
	public static void main (String[] args) throws Exception{
		
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
		Runtime.getRuntime().exec("E:\\AutoITScripts\\HandleAuthenticationwindow.exe");
		driver.navigate().to(baseUrl);
		//Runtime.getRuntime().exec("E:\\AutoITScripts\\HandleAuthenticationwindow.exe");
	}
	
}	
