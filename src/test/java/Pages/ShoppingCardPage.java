package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class ShoppingCardPage extends Base_Test 
{
	Testutils testutils= new Testutils();

	public ShoppingCardPage() throws IOException, FileNotFoundException
	{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-cart-text-container']")
	WebElement Cart;

	@FindBy(xpath = "//h2[contains(text(),'Shopping Cart')]")
	WebElement shoppingCartText;



	public void verify_title()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(Cart));
		Cart.click();
		System.out.println(driver.getTitle());
	}


	public boolean verify_correct_page()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(Cart));
		Cart.click();
		return shoppingCartText.isDisplayed();
	}
}
