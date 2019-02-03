package Newpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demopractice {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	    //WebDriver driver = new FirefoxDriver() ;
	    WebDriver driver = new ChromeDriver() ;
		String baseUrl = "https://www.google.co.in/";
		
		driver.manage().window().maximize(); 
		
		driver.get(baseUrl);
		
		Thread.sleep(5000);
		
		System.out.println(baseUrl);
		
		driver.close();
   }
}
