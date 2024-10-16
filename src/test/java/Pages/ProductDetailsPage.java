package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseTest.Base_Test;
import CommonUtilities.Testutils;
import Tests.ProductDetailsPageTest;

public class ProductDetailsPage extends Base_Test 
{
	Testutils testutils;
	
	DashboardPage dashboardpage = new DashboardPage();
	ProductDetailsPageTest productdetailspagetest= new ProductDetailsPageTest();

	public ProductDetailsPage() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
		testutils = new Testutils();
	}

	@FindBy(xpath = "//span[@id='submit.buy-now']")
	WebElement BuyNowBtn;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement AddToCard;


	public void check_title_page() {
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		System.out.println("Page Title on Product details page " + driver.getTitle());
	}

	public boolean Verify_Productdetail_page() {
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		return BuyNowBtn.isDisplayed();
	}

	public void add_to_shoppingcart() throws IOException, Exception
	{
		dashboardpage.click_product(pr.getProperty("product"));
		productdetailspagetest.switchToNewWindow();
		testutils.wait.until(ExpectedConditions.elementToBeClickable(AddToCard));
		AddToCard.click();
		System.out.println("Item added to card successfully");
	}

}
