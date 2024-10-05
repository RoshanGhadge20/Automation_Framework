package CommonUtilities;

import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.security.auth.login.FailedLoginException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.Base_Test;

public class Testutils extends Base_Test
{	

	public Testutils() throws IOException, FileNotFoundException 
	{
		super();

	}

	// Implemented Webdriver wait (Explicit Wait)
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Implementing TakeScreenshot Utility
	public void TakeScreenShot() throws IOException 
	{
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path= "E://Automation_Framework//POM//Screenshot//"+ FileName;
		TakesScreenshot TS= (TakesScreenshot) driver;
		File fs= TS.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		FileUtils.copyFile(fs,des);
	}


	public void select(WebElement element, String  sel_element)
	{
		Select sc= new Select(element);
		sc.selectByVisibleText(sel_element);
	}


	public void window_handles()
	{
		String parent_win=driver.getWindowHandle();
		Set<String> win_handle=driver.getWindowHandles();
		Iterator<String> it=win_handle.iterator();
		while (it.hasNext()) 
		{
			String win =it.next();
			System.out.println(win);
		}
		driver.switchTo().window(parent_win);
		
	}	
	




}
