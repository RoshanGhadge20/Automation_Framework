package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class YourOrdersPage extends Base_Test 
{

	Testutils testutils = new Testutils();
	
	public YourOrdersPage() throws IOException, FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	// Object Pool Webelement
	
	@FindBy(xpath = "//span[contains(text(),'Returns')]")
	@CacheLookup
	WebElement Return_Order;
	
	@FindBy(xpath = "//h1[contains(text(),'Your Orders')]")
	@CacheLookup
	WebElement YouOrderText;
	
	@FindBy(xpath = "//ul[@role='tablist']//li")
	List<WebElement> your_orders_options;
	
	@FindBy(xpath   = "//span[@class='a-color-state']")
	@CacheLookup
	WebElement page_path;
	

	// Test Methods
	
	public void get_title_of_yourorderpage() 
	{
		Return_Order.click();
		System.out.println("Title of Page :- "+ testutils.get_pagetitle());
	}

	public boolean Verify_YourOrdersPage() 
	{
		Return_Order.click();
		return YouOrderText.isDisplayed();
	}
	
	public void order_options() throws InterruptedException
	{
		Return_Order.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(YouOrderText));
		for(WebElement element : your_orders_options)
		{
			System.out.println("Options are :- " + element.getText());
			Thread.sleep(1000);
		}
	}
	
	public void validate_path() throws InterruptedException 
	{
		Return_Order.click();
		Thread.sleep(5000);
		testutils.wait.until(ExpectedConditions.visibilityOf(YouOrderText));
		String path= page_path.getText();
		if (path.contains("Your Orders")) 
		{
			System.out.println("Correct Page Path");
		}
		else
		{
			System.out.println("Incorrect Page Path");
		}
	}
}
