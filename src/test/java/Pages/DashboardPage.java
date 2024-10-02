package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class DashboardPage extends Base_Test
{
	
	LoginPage loginpage;
	Testutils testutils;
	

	public DashboardPage() throws IOException, FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
		testutils= new Testutils();
	}
	
	@FindBy (css = "a#nav-logo-sprites")
	WebElement Dashboardlogo;
	

	public boolean verify_dashboard_logo() 
	{
	
		testutils.wait.until(ExpectedConditions.visibilityOf(Dashboardlogo));
		return Dashboardlogo.isDisplayed();
	}
	
	public void get_page_title() {
	}
	{
		System.out.println("Dashboard page title "+(driver.getTitle()));
	}
	
	
	
	
	
	


}
