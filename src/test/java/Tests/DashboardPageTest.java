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
	
	@Test(priority = 1 , groups = {"Sanity"})
	public void get_title()
	{
		dashboardpage.get_page_title();
	}
	
	@Test(priority = 2, groups = {"Sanity"})
	public void check_logo()
	{
		Assert.assertEquals(true, dashboardpage.verify_dashboard_logo());
	}
	
	
	
	@Test(priority = 3, groups = {"Sanity"})
	public void get_elements()
	{
		dashboardpage.dash_pg_navbar();
	}
	
	@Test(priority = 4, groups = {"Regression"})
	public void search_products()
	{
		dashboardpage.search_product(pr.getProperty("product"));
	}
	
	
	
	@AfterMethod
	public void tdown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	
}
