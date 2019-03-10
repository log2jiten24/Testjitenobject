package Functionlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Reusablefunctions {
	
public static void capturescreenshot (WebDriver driver ,String screenshotname)
{
	try {
	//TakesScreenshot is an interface ,we are typecasting interface to create object
	TakesScreenshot ts = (TakesScreenshot)driver  ;
	//getScreenshotAs - method to take screenshot and store in the memory
	File src = ts.getScreenshotAs(OutputType.FILE) ;
	//store the source file into the destination
	
	Files.copy(src, new File("./Screenshots/+ "+screenshotname+".png"));
	
	System.out.println ("Screenshots taken");
	} catch (Exception e) 
	{
	System.out.println("Screenshot failure :" + e.getMessage());
	}
}
}
