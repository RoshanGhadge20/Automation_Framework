package Tests;

import static org.testng.Assert.fail;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseTest.Base_Test;
import CommonUtilities.Extent_Reports;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ShoppingCardPage;
import ScreenRecording.CaptureVideo;

public class ShoppingCardPageTest extends Base_Test {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	ShoppingCardPage shoppingcardpage;
	CaptureVideo capturevideo;

	public ShoppingCardPageTest() throws IOException, FileNotFoundException {
		super();
	}

	@BeforeClass
	public void ensureTestReportsInitialized() {
		if (testreports == null) {
			testreports = new Extent_Reports();
			testreports.start_reporter();
		}
	}

	@BeforeMethod
	public void initiate_all() throws FileNotFoundException, IOException, InterruptedException {
		loginpage = new LoginPage();
		dashboardpage = loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		productdetailspage = new ProductDetailsPage();
		shoppingcardpage = new ShoppingCardPage();
		capturevideo = new CaptureVideo();
	}

	/**
	 * Verify title of page on shopping card page
	 */
	@Test(priority = 1, groups = { "Sanity" })
	public void Verify_title_of_page() {
		testreports.test_details("Verify title of page");
		shoppingcardpage.verify_title();
		logger.info("ShoppingCardPageTest verify_title_of_page executed");
	}

	/**
	 * Verify if user correctly land on shopping card page
	 */
	@Test(priority = 2, groups = { "Sanity" })
	public void check_page() {
		testreports.test_details("Validate user lands on correct page");
		shoppingcardpage.verify_correct_page();
		logger.info("ShoppingCardPageTest check_page executed");
	}

	/**
	 * Check if user is able to search product & add it into shopping cart page
	 */
	@Test(priority = 3, groups = { "Sanity", "Regression" }, enabled = false)
	public void add_product() throws IOException, Exception 
	{
		//capturevideo.StartRecording();
		testreports.test_details("Select a product and add it to the shopping cart");
		// dashboardpage.search_product(pr.getProperty("product"));
		productdetailspage.add_to_shoppingcart();
		logger.info("ShoppingCardPageTest add_product executed");
		//capturevideo.StopRecording();
	}

	/**
	 * Getting list of items added into shopping cart page
	 */
	@Test(priority = 4, groups = "Sanity")
	public void list_of_items() 
	{
		//capturevideo.StartRecording();
		testreports.test_details("fetching list of items added into shoppingcart");
		shoppingcardpage.list_of_items_addedinto_shopping_cart();
		logger.info("ShoppingCardPageTest list_of_items executed");
		//capturevideo.StopRecording();
	}

	/**
	 * Check if user is able to proceed to checkout
	 */
	@Test(priority = 5, groups = "Regression")
	public void do_checkout() 
	{
		//capturevideo.StartRecording();
		testreports.test_details("Verify Checkout Functionality");
		shoppingcardpage.proceed_to_buy();
		logger.info("ShoppingCardPageTest do_checkout executed");
		//capturevideo.StopRecording();
	}

	@AfterMethod
	void quite_all(ITestResult result) {
		testreports.getresult(result);
	}

}
