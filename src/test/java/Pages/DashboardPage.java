package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseTest.Base_Test;
import CommonUtilities.Testutils;
import io.github.bonigarcia.wdm.managers.VoidDriverManager;

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
	WebElement navbarElement;
	
	@FindBy (css = "input#twotabsearchtextbox")
	WebElement search_bar;
	
	@FindBy(css = "input#nav-search-submit-button")
	WebElement search_icon;
	
	@FindBy(css = "div[data-cy='title-recipe']")
	List<WebElement> list_of_product;
	
	
	

	public boolean verify_dashboard_logo() 
	{
	
		testutils.wait.until(ExpectedConditions.visibilityOf(Dashboardlogo));
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


}
