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
import CommonUtilities.Testutils;
import Pages.DashboardPage;
import Pages.LoginPage;
import ScreenRecording.CaptureVideo;

public class DashboardPageTest extends Base_Test {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	CaptureVideo capturevideo;
	Testutils testutils;

	public DashboardPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {

		dashboardpage = new LoginPage().do_login(pr.getProperty("username"), pr.getProperty("password"));
		capturevideo = new CaptureVideo();
		testutils = new Testutils();
	}

	/**
	 * Verify title of dashboard page
	 */
	@Test(priority = 1, groups = { "Sanity" }, retryAnalyzer = Listners.Retry.class)
	public void get_title() {
		testreports.test_details("Verify title of dashboard page");
		String title_page = testutils.get_pagetitle();
		logger.info("DashboardTest get_title executed");
	}

	/**
	 * Verify the apperance of logo & size on dashboard page
	 */
	@Test(priority = 2, groups = { "Sanity" })
	public void check_logo() {
		testreports.test_details("verify appearnace of logo in dashboard page");
		Assert.assertEquals(true, dashboardpage.verify_dashboard_logo());
		logger.info("DashboardTest check_logo executed");
	}

	/**
	 * Verify all the navbar options from dashboard page as expected
	 */
	@Test(priority = 3, groups = { "Sanity" })
	public void get_elements() {
		testreports.test_details("Validate all navbar options in dashboard page");
		dashboardpage.dash_pg_navbar();
		logger.info("DashboardTest get_elements executed");
	}

	/**
	 * Check if user is able to search product on dashboard page
	 */
	@Test(priority = 4, groups = { "Regression" }, retryAnalyzer = Listners.Retry.class)
	public void search_products() {
		// capturevideo.StartRecording();
		testreports.test_details("Verify user is able to search product");
		dashboardpage.search_product(pr.getProperty("product"));
		logger.info("DashboardTest search_products executed");
		// capturevideo.StopRecording();
	}

	/**
	 * Validate profile details & all listing of options from sidebar
	 */
	@Test(priority = 5, groups = { "Sanity" })
	public void check_user_name() {
		testreports.test_details("Verify user profile details name on all section");
		Assert.assertEquals(true, dashboardpage.verify_profile_details());
		logger.info("DashboardTest check_user_name executed");
	}

	@AfterMethod
	public void tdown(ITestResult result) {
		testreports.getresult(result);
	}

}
