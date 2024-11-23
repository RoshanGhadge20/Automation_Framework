package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseTest.Base_Test;
import CommonUtilities.ExcelUtility;
import Pages.LoginPage;
import ScreenRecording.*;

public class LoginPageTest extends Base_Test {

	LoginPage loginpage;
	CaptureVideo capturevideo;

	public LoginPageTest() throws IOException, FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void initialize() throws IOException {
		loginpage = new Pages.LoginPage();
		capturevideo = new CaptureVideo();
	}

	/**
	 * To check the title of login page
	 */
	@Test(priority = 1, groups = { "Sanity" }, retryAnalyzer = Listners.Retry.class)
	public void check_title() throws IOException {
		testreports.test_details("Check title of login page");
		String titleString = loginpage.getpagetitle();
		Assert.assertEquals(titleString, "Amazon Sign In", "Title does not match");
		logger.info("LoginTest check_title executed");
	}

	/**
	 * Check amazon logo displayed on login page with it's respective size
	 * 
	 */
	@Test(priority = 2, groups = { "Sanity" })
	public void check_logo() {
		testreports.test_details("Verify Amazon logo displays on login page");
		Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
		logger.info("LoginTest check_logo executed");
	}

	/**
	 * To check if user is able to login with valid credentials
	 */
	@Test(priority = 3, groups = { "Sanity", "Regression" }, retryAnalyzer = Listners.Retry.class)
	public void login() throws InterruptedException, IOException {
		capturevideo.StartRecording();
		testreports.test_details("Verify user can log in with valid credentials");
		loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		logger.info("LoginTest login with valid credentials");
		capturevideo.StopRecording();
	}

	/**
	 * To check that whether create_account option is visible on login page
	 */
	@Test(priority = 4, groups = { "Sanity" })
	public void verify_createaccount_option() {
		testreports.test_details("Verify Create_account option in login page");
		Assert.assertTrue(loginpage.check_create_account_option());
		logger.info("LoginTest verify_createaccount_option gets executed");
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		testreports.getresult(result);
	}
}
