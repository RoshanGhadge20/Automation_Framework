package CommonUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import javax.security.auth.login.FailedLoginException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.Base_Test;

public class Testutils extends Base_Test
{	
	
	public Testutils() throws IOException, FileNotFoundException 
	{
		super();
	
	}
	
	// Implemented Webdriver wait
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	// Implementing TakeScreenshot Utility
	public void TakeScreenShot() throws IOException 
	{
		String path= "E://Automation_Framework//POM//Screenshot//Failed.png";
		TakesScreenshot TS= (TakesScreenshot) driver;
		File fs= TS.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		FileUtils.copyFile(fs,des);
	}
	
	
	
	
	
	
}
