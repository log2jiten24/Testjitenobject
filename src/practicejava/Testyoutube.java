package practicejava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Flash.FlashObjectWebDriver;

public class Testyoutube {

	
	static WebDriver driver ;
	String baseUrl = "https://www.youtube.com/";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
}
	

@Test (priority = 1 , description = "test the youtube video" , enabled = true)
public void openurl() throws Exception 
{
//launching the url	
driver.get(baseUrl);

Thread.sleep(5000);

//click on bindeshi taara online 
driver.findElement(By.xpath("//*[@id=\"video-title\"]")).click();
Thread.sleep(5000);

//This is seperate class which is available inside jar which i attached
FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "movie_player");

//let the video load
		 while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3){
		 Thread.sleep(1000L);
		 
		 
		 // Play the video for 10 seconds
		 Thread.sleep(5000);
		 flashApp.callFlashObject("pauseVideo");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("playVideo");
		 Thread.sleep(5000);
		 // Seek to is method which will forword video to 140 second
		 flashApp.callFlashObject("seekTo","140","true");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("mute");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("setVolume","50");
		 Thread.sleep(5000);


}
}
  @AfterTest
//  public void close (ITest result) {
  
  public void close () {
	
	driver.close();
}

}