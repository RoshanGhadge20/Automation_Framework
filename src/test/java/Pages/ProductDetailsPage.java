package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Base64;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class ProductDetailsPage extends Base_Test 
{	
	Testutils testutils;

	public ProductDetailsPage() throws IOException, FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
		testutils= new Testutils();
		
	}
	

	@FindBy(xpath = "//span[@id='submit.buy-now']")
	WebElement BuyNowBtn;
	
	public void check_title_page()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		System.out.println("Page Title on Product details page "+driver.getTitle());
	}
	

	public boolean Verify_Productdetail_page()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		return BuyNowBtn.isDisplayed();
	}
		
}
