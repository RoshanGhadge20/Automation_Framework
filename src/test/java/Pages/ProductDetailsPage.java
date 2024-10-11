package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class ProductDetailsPage extends Base_Test {
	Testutils testutils;

	public ProductDetailsPage() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
		testutils = new Testutils();

	}

	@FindBy(xpath = "//span[@id='submit.buy-now']")
	WebElement BuyNowBtn;

	@FindBy(xpath = "//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[37]/div[1]/span[1]/span[1]/span[1]/input[1]")
	WebElement AddToCard;

	public void check_title_page() {
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		System.out.println("Page Title on Product details page " + driver.getTitle());
	}

	public boolean Verify_Productdetail_page() {
		testutils.wait.until(ExpectedConditions.visibilityOf(BuyNowBtn));
		return BuyNowBtn.isDisplayed();
	}

	public void add_to_shoppingcart()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(AddToCard));
		AddToCard.click();
		System.out.println("Item added to card successfully");
	}

}
