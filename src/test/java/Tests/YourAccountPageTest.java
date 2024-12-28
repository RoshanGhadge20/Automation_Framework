package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.devtools.v127.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseTest.Base_Test;
import Pages.LoginPage;
import Pages.YourAccountPage;

public class YourAccountPageTest extends Base_Test {
	LoginPage loginpage;
	YourAccountPage youraccountpage;

	public YourAccountPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void initialize() throws FileNotFoundException, IOException, InterruptedException {
		youraccountpage = new LoginPage().logining(pr.getProperty("username"), pr.getProperty("password"));

	}

	@Test(priority = 1, groups = {"Sanity"})
	public void check_title() {
		testreports.test_details("Verify Page Title on your account page");
		System.out.println(youraccountpage.check_page());
	}

	@Test(priority = 2, groups = {"Sanity"})
	public void check_options() {
		testreports.test_details("Verify options on your account page");
		youraccountpage.list_of_options();
	}

	@Test(priority = 3, groups = {"Regression"})
	public void check_links()
	{
		testreports.test_details("Checking links on page");
		youraccountpage.verify_redirection_of_links();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		testreports.getresult(result);
	}
}
