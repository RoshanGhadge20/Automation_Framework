package CommonUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	// Implementing TakeScreenshot Utility
	public void TakeScreenShot() throws IOException 
	{
		DateFormat df= new SimpleDateFormat("dd-mm-yyyy h-m-s");	
		Date d = new Date();
		//String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path= "E://Automation_Framework//POM//Screenshot//"+"ScreenShot" + df.format(d)+".png";
		TakesScreenshot TS= (TakesScreenshot) driver;
		File fs= TS.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		FileUtils.copyFile(fs,des);
	}

	// Implemented select option utility
	public void select(WebElement element, String  sel_element)
	{
		Select sc= new Select(element);
		sc.selectByVisibleText(sel_element);
	}

	// Implemented window handle functionality
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
