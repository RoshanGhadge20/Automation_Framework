package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import BaseTest.Base_Test;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.YourOrdersPage;

public class YourOrdersPageTest extends Base_Test
{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	YourOrdersPage yourorderspage;
	
	
	public YourOrdersPageTest() throws IOException, FileNotFoundException
	{
		super();
	}

	@BeforeMethod
	public void initiate()
	{
		active();
		
	}
	
	
	@AfterMethod
	public void quite()
	{
		driver.quit();
		
	}
}
