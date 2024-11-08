package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;

import org.openqa.selenium.devtools.v127.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	
	
	public YourOrdersPageTest() throws IOException, FileNotFoundException, InterruptedException
	{
		super();
	}

	@BeforeMethod
	public void initiate() throws FileNotFoundException, IOException, InterruptedException
	{
		loginpage = new LoginPage();
		dashboardpage =loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		yourorderspage = new YourOrdersPage();
		
	}
	
	/** 
	 * Verify title of page on Yourorders page
	 */
	@Test(priority = 1, groups = "Sanity")
	public void check_title()
	{
		testreports.test_details("Verify title of page");
		yourorderspage.get_title_of_yourorderpage();
	}
	
	/**
	 * Validate user is correctly landed on Yours order page by validating text ( Your Orders )
	 */
	@Test(priority = 2, groups = {"Sanity", "Regression"})
	public void check_page()
	{
		testreports.test_details("Validate user is correctly landed on Yours order page by validating text");
		Assert.assertTrue(yourorderspage.Verify_YourOrdersPage());
	}
	
	/**
	 * Verify listing of all options available on your orders page
	 */
	@Test(priority = 3,  groups = "Sanity")
	public void get_yourorders_options() throws InterruptedException
	{
		testreports.test_details("Verifying all list of options available on your orders page");
		yourorderspage.order_options();
	}
	
	/**
	 * Check if correct path gets shown in your order page
	 */
	@Test(priority = 4, groups = {"Sanity", "Regression"})
	public void check_path() throws InterruptedException
	{
		testreports.test_details("Verify correct path gets shown in your orders page");
		yourorderspage.validate_path();
	}
	
	
	@AfterMethod
	public void quite(ITestResult result)
	{
		testreports.getresult(result);
	}
}
