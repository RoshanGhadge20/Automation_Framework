package Tests;

import java.io.IOException;
import java.security.PublicKey;

import org.openqa.selenium.devtools.v127.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.Assert;
import org.testng.ITestResult;
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
		dashboardpage = new LoginPage().do_login(pr.getProperty("username"), pr.getProperty("password"));
	}
	
	
	/**
	 * Verify title of dashboard page
	 */
	@Test(priority = 1 , groups = {"Sanity"})
	public void get_title()
	{
		testreports.test_details("Verify title of dashboard page");
		dashboardpage.get_page_title();
	}
	
	/**
	 * Verify the apperance of logo & size on dashboard page
	 */
	@Test(priority = 2, groups = {"Sanity"})
	public void check_logo()
	{
		testreports.test_details("verify appearnace of logo in dashboard page");
		Assert.assertEquals(true, dashboardpage.verify_dashboard_logo());
	}
	
	
	/**
	 * Verify all the navbar options from dashboard page as expected
	 */
	@Test(priority = 3, groups = {"Sanity"})
	public void get_elements()
	{
		testreports.test_details("Validate all navbar options in dashboard page");
		dashboardpage.dash_pg_navbar();
	}
	
	/**
	 * Check if user is able to search product on dashboard page
	 */
	@Test(priority = 4, groups = {"Regression"})
	public void search_products()
	{
		testreports.test_details("Verify user is able to search product");
		dashboardpage.search_product(pr.getProperty("product"));
	}
	
	/**
	 * Validate profile details & all listing of options from sidebar
	 */
	@Test(priority = 5, groups = {"Sanity"})
	public void check_user_name()
	{
		testreports.test_details("Verify user profile details name on all section");
		Assert.assertEquals(true, dashboardpage.verify_profile_details());
	}
	
	@AfterMethod
	public void tdown(ITestResult result)
	{
	testreports.getresult(result);	
	}
	
}
