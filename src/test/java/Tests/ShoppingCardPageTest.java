package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.Base_Test;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ShoppingCardPage;

public class ShoppingCardPageTest extends Base_Test {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	ShoppingCardPage shoppingcardpage;

	public ShoppingCardPageTest() throws IOException, FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void initiate_all() throws FileNotFoundException, IOException, InterruptedException {
		active();
		loginpage = new LoginPage();
		dashboardpage = loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
		productdetailspage = new ProductDetailsPage();
		shoppingcardpage = new ShoppingCardPage();
	}

	@Test(priority = 1, description = "Verify title of page", groups = {"Sanity"})
	public void Verify_title_of_page() {
		shoppingcardpage.verify_title();
	}

	@Test(priority = 2, description = "Validate user lands on correct page", groups = {"Sanity"})
	public void check_page() {
		shoppingcardpage.verify_correct_page();
	}

	
	@Test(priority = 3,description ="Select a product and add it to the shopping cart", groups = {"Sanity", "Regression"})
	public void add_product()
	{
		productdetailspage.add_to_shoppingcart();
	}
	
	@AfterMethod
	public void quite_all() {
		driver.quit();
	}
	
	

}
