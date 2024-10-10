package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.devtools.v127.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.Assert;
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
		active();
		loginpage = new LoginPage();
		dashboardpage =loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		//productdetailspage = new DashboardPage().click_product(pr.getProperty("product"));
		//switchToNewWindow();
		yourorderspage = new YourOrdersPage();
		
	}
	
	@Test(priority = 1, description ="Verify title of page")
	public void check_title()
	{
		yourorderspage.get_title_of_yourorderpage();
	}
	
	@Test(priority = 2, description ="Validate user is correctly landed on Yours order page by validating text ")
	public void check_page()
	{
		Assert.assertTrue(yourorderspage.Verify_YourOrdersPage());
	}
	
	
	
	
	@AfterMethod
	public void quite()
	{
		driver.quit();
		
	}
}
