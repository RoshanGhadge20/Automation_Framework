package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.Base_Test;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.YourAccountPage;

public class YourAccountPageTest extends Base_Test
{
	LoginPage loginpage;
	YourAccountPage youraccountpage;
	
	public YourAccountPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void initialize() throws FileNotFoundException, IOException, InterruptedException
	{
		youraccountpage = new LoginPage().logining(pr.getProperty("username"), pr.getProperty("password"));
		
	}
	
	@Test(priority = 1, groups = {"Sanity"})
	public void check_title()
	{
		testreports.test_details("Verify Page Title on your account page");
		System.out.println(youraccountpage.check_page());
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		testreports.getresult(result);
	}
}
