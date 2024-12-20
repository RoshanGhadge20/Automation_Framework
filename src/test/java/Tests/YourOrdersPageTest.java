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
import ScreenRecording.CaptureVideo;

public class YourOrdersPageTest extends Base_Test {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	YourOrdersPage yourorderspage;
	CaptureVideo capturevideo;

	public YourOrdersPageTest() throws IOException, FileNotFoundException, InterruptedException {
		super();
	}

	@BeforeMethod
	public void initiate() throws FileNotFoundException, IOException, InterruptedException {
		loginpage = new LoginPage();
		dashboardpage = loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		yourorderspage = new YourOrdersPage();

	}

	/**
	 * Verify title of page on Yourorders page
	 */
	@Test(priority = 1, groups = "Sanity", retryAnalyzer = Listners.Retry.class)
	public void check_title() {
		testreports.test_details("Verify title of page");
		yourorderspage.get_title_of_yourorderpage();
		logger.info("YourOrderPageTest check_title executed");
	}

	/**
	 * Validate user is correctly landed on Yours order page by validating text (
	 * Your Orders )
	 */
	@Test(priority = 2, groups = { "Sanity", "Regression" })
	public void check_page() {
		testreports.test_details("Validate user is correctly landed on Yours order page by validating text");
		Assert.assertTrue(yourorderspage.Verify_YourOrdersPage());
		logger.info("YourOrderPageTest check_page executed");
	}

	/**
	 * Verify listing of all options available on your orders page
	 */
	@Test(priority = 3, groups = "Sanity", retryAnalyzer = Listners.Retry.class)
	public void get_yourorders_options() throws InterruptedException {
		// capturevideo.StartRecording();
		testreports.test_details("Verifying all list of options available on your orders page");
		yourorderspage.order_options();
		logger.info("YourOrderPageTest get_yourorders_options executed");
		// capturevideo.StopRecording();
	}

	/**
	 * Check if correct path gets shown in your order page
	 */
	@Test(priority = 4, groups = { "Sanity", "Regression" })
	public void check_path() throws InterruptedException {
		testreports.test_details("Verify correct path gets shown in your orders page");
		yourorderspage.validate_path();
		logger.info("YourOrderPageTest check_path executed");
	}

	@AfterMethod
	public void quite(ITestResult result) {
		testreports.getresult(result);
	}
}
