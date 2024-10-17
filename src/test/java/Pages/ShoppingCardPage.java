package Pages;

import java.awt.ItemSelectable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
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
	
	@FindBy(css = "div[data-name='Active Items']")
	WebElement active_items_Area;
	
	@FindBy(css = "input[name='proceedToRetailCheckout']")
	WebElement Proceed_to_buy_btn;
	
	@FindBy(xpath = "//h1[contains(text(),'Checkout')]")
	WebElement checkout_title;

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
	
	public void list_of_items_addedinto_shopping_cart()
	{
		Cart.click();
		List<WebElement> elements= active_items_Area.findElements(By.xpath("//div[contains(@class, 'sc-list-item-content')]//span[@class='a-truncate-full a-offscreen']"));
		for(WebElement element:elements)
		{
			System.out.println("Items " + element.getAttribute("innerHTML"));
		}
		
	}
	
	public void proceed_to_buy()
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(Cart));
		Cart.click();
		Proceed_to_buy_btn.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(checkout_title));
		System.out.println("Redirected to checkout page");
	}
}
