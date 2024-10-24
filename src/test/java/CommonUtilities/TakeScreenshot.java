package CommonUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BaseTest.Base_Test;

public class TakeScreenshot extends Base_Test {
	public TakeScreenshot() throws IOException, FileNotFoundException {
		super();
	}

	public void Takescreenhots() throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("E:/Automation_Framework/POM//Screenshot/FailedTC.png");
		FileUtils.copyFile(source, dest);
		System.out.println("screenshot saved");
	}
}
