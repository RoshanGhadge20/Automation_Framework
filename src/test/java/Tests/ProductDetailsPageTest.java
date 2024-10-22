package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
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
import io.github.bonigarcia.wdm.managers.VoidDriverManager;

public class ProductDetailsPageTest extends Base_Test
{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductDetailsPage productdetailspage;
	
	public ProductDetailsPageTest() throws IOException, FileNotFoundException
	{
		super();
	}
	
	@BeforeMethod
	public void initiate() throws FileNotFoundException, IOException, Exception
	{
		dashboardpage = new LoginPage().do_login(pr.getProperty("username"), pr.getProperty("password"));
		productdetailspage = new DashboardPage().click_product(pr.getProperty("product"));
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
	
	@Test(priority = 1, description = "Verifying Page title on Product details screen", groups = {"Sanity"})
	public void check_title_page()
	{
		testreports.test_details("Verifying Page title on Product details screen");
		productdetailspage.check_title_page();
	}

	@Test(priority = 2, description = "Validate user redirects to correct product details screen", groups = {"Sanity"})
	public void verify_productdetailscreen()
	{
		testreports.test_details("Validate user redirects to correct product details screen");
	 Assert.assertEquals((productdetailspage.Verify_Productdetail_page()),true);
	}
	
	@AfterMethod
	public void terminate(ITestResult result)
	{
		testreports.getresult(result);
	}
	
}

