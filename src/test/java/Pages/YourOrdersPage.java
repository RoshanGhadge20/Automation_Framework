package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.Base_Test;

public class YourOrdersPage extends Base_Test 
{

	
	public YourOrdersPage() throws IOException, FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Your Orders')]")
	WebElement YouOrderText;
	

	public void get_title_of_yourorderpage() 
	{
		System.out.println("Title of Your Order Page"+driver.getTitle());
	}
	

	public boolean Verify_YourOrdersPage() 
	{
		return YouOrderText.isDisplayed();
	}
	
	

}