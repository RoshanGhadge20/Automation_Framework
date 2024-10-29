package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import BaseTest.Base_Test;
import CommonUtilities.Testutils;
import io.github.bonigarcia.wdm.managers.VoidDriverManager;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class DashboardPage extends Base_Test
{

	LoginPage loginpage;
	Testutils testutils;

	public DashboardPage() throws IOException, FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
		testutils= new Testutils();
	}

	@FindBy (css = "a#nav-logo-sprites")
	WebElement Dashboardlogo;

	@FindBy(css = "div#navbar")
	@CacheLookup
	WebElement navbarElement;

	@FindBy (css = "input#twotabsearchtextbox")
	@CacheLookup
	WebElement search_bar;

	@FindBy(css = "input#nav-search-submit-button")
	@CacheLookup
	WebElement search_icon;

	@FindBy(css = "div[data-cy='title-recipe']")
	List<WebElement> list_of_product;

	@FindBy(css = "span.hm-icon-label")
	WebElement all_menu_option;

	@FindBy(css = "#hmenu-customer-name b")
	WebElement UserProfile;
	


	public boolean verify_dashboard_logo() 
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(Dashboardlogo));
		int height= Dashboardlogo.getRect().getHeight();
		int width= Dashboardlogo.getRect().getWidth();
		Assert.assertEquals(height, 31);
		Assert.assertEquals(width, 103);
		return Dashboardlogo.isDisplayed();
	}

	public void get_page_title() 
	{
		System.out.println("Dashboard page title "+(driver.getTitle()));
	}

	public void dash_pg_navbar() 
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(navbarElement));
		String element=navbarElement.getText();
		System.out.println("Elements from Navbar"+ element);
	}	

	public void search_product(String product_name)
	{
		search_bar.clear();
		search_bar.sendKeys(product_name);
		search_icon.click();

		for(WebElement element:list_of_product)
		{
			System.out.println("list of suggested product"+element.getText());
		}

	}

	public boolean verify_profile_details() 
	{
		testutils.wait.until(ExpectedConditions.visibilityOf(all_menu_option));
		all_menu_option.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(UserProfile));
		String nameString = UserProfile.getText();
		System.out.println("nameString "+ nameString);
		if(nameString.equalsIgnoreCase("Hello, Roshan"))
		{ 
			return true;
		}
		else {
			return false;
		}


	}

	public ProductDetailsPage click_product(String product_name) throws Exception, IOException 
	{
		search_bar.clear();
		search_bar.sendKeys(product_name);
		search_icon.click();
		for(WebElement element:list_of_product)
		{
			if((element.getText().equalsIgnoreCase("realme 10 Pro 5G (Dark Matter, 6GB RAM, 128GB Storage)")))
			{
				element.click();
			}
		}
		return new ProductDetailsPage();
	}


}
