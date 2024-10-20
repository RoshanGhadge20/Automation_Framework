package Tests;

import java.io.IOException;
import java.security.PublicKey;

import org.openqa.selenium.devtools.v127.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;

import BaseTest.Base_Test;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends Base_Test
{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	
	public DashboardPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void initialize() throws IOException, InterruptedException
	{
		active();
		dashboardpage = new LoginPage().do_login(pr.getProperty("username"), pr.getProperty("password"));
		
	}
	
	@Test(priority = 1 , groups = {"Sanity"}, description = "verify title of page in dashboard screen ")
	public void get_title()
	{
		dashboardpage.get_page_title();
	}
	
	@Test(priority = 2, groups = {"Sanity"} , description = "verify appearnace of logo in dashboard page")
	public void check_logo()
	{
		Assert.assertEquals(true, dashboardpage.verify_dashboard_logo());
	}
	
	
	@Test(priority = 3, groups = {"Sanity"}, description = "validate all navbar options from dashboard page")
	public void get_elements()
	{
		dashboardpage.dash_pg_navbar();
	}
	
	@Test(priority = 4, groups = {"Regression"}, description = "Verify user is able to search product")
	public void search_products()
	{
		dashboardpage.search_product(pr.getProperty("product"));
	}
	
	@Test(priority = 5, groups = "Sanity", description = "Verify user profile details name on all section ")
	public void check_user_name()
	{
		Assert.assertEquals(true, dashboardpage.verify_profile_details());
	}
	
	
	
	
	@AfterMethod
	public void tdown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
}
