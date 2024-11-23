package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.Base_Test;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import ScreenRecording.CaptureVideo;

public class ProductDetailsPageTest extends Base_Test {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	CaptureVideo capturevideo;

	public ProductDetailsPageTest() throws IOException, FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void initiate() throws FileNotFoundException, IOException, Exception {
		dashboardpage = new LoginPage().do_login(pr.getProperty("username"), pr.getProperty("password"));
		productdetailspage = new DashboardPage().click_product(pr.getProperty("product"));
		capturevideo = new CaptureVideo();
		switchToNewWindow();
	}

	public void switchToNewWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	/**
	 * Verify page title on product detail page
	 */
	@Test(priority = 1, groups = { "Sanity" }, retryAnalyzer = Listners.Retry.class)
	public void check_title_page() {
		testreports.test_details("Verifying Page title on Product details screen");
		productdetailspage.check_title_page();
		logger.info("ProductDetailsPage check_title_page executed");
	}

	/**
	 * Verify if user is able to redirects to correct product details page after
	 * searching & clicking on respective product
	 */
	@Test(priority = 2, groups = { "Sanity" })
	public void verify_productdetailscreen() 
	{
		//capturevideo.StartRecording();
		testreports.test_details("Validate user redirects to correct product details screen");
		Assert.assertEquals((productdetailspage.Verify_Productdetail_page()), true);
		logger.info("ProductDetailsPage verify_productdetailscreen executed");
		//capturevideo.StopRecording();
	}

	/**
	 * Getting all product details from its details page
	 */
	@Test(priority = 3, groups = "Sanity", retryAnalyzer = Listners.Retry.class)
	public void about_product() 
	{
		testreports.test_details("Fetch details about product");
		productdetailspage.get_product_details();
		logger.info("ProductDetailsPage about_product executed");
	}

	@AfterMethod
	public void terminate(ITestResult result) {
		testreports.getresult(result);
	}

}
