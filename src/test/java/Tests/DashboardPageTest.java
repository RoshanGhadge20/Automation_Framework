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
	
	@Test(priority = 1 , groups = {"Sanity"}, description = "Verify title of dashboard page")
	public void get_title()
	{
		testreports.test_details("Verify title of dashboard page");
		dashboardpage.get_page_title();
	}
	
	@Test(priority = 2, groups = {"Sanity"} , description = "Verify appearnace of logo and size in dashboard page")
	public void check_logo()
	{
		testreports.test_details("verify appearnace of logo in dashboard page");
		Assert.assertEquals(true, dashboardpage.verify_dashboard_logo());
	}
	
	
	@Test(priority = 3, groups = {"Sanity"}, description = "Validate all navbar options in dashboard page")
	public void get_elements()
	{
		testreports.test_details("Validate all navbar options in dashboard page");
		dashboardpage.dash_pg_navbar();
	}
	
	@Test(priority = 4, groups = {"Regression"}, description = "Verify user is able to search product")
	public void search_products()
	{
		testreports.test_details("Verify user is able to search product");
		dashboardpage.search_product(pr.getProperty("product"));
	}
	
	@Test(priority = 5, groups = "Sanity", description = "Verify user profile details name on all section")
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
