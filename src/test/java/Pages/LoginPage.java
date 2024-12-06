package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.Base_Test;
import CommonUtilities.Extent_Reports;
import CommonUtilities.Testutils;
import lombok.With;

public class LoginPage extends Base_Test {
	Testutils testutils;

	public LoginPage() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
		testutils = new Testutils();
	}

	// object pool ( Weblements )
	
	@FindBy(css = "input#ap_email")
	@CacheLookup
	WebElement email_field;

	@FindBy(css = "span#continue")
	@CacheLookup
	WebElement continue_btn;

	@FindBy(css = ".a-icon-logo")
	WebElement logo;

	@FindBy(css = "input[name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(css = "input#signInSubmit")
	@CacheLookup
	WebElement signbtn;

	@FindBy(xpath = "//h5[contains(text(),'New to Amazon?')]")
	WebElement newToAmazonText;

	@FindBy(css = "#createAccountSubmit")
	WebElement creatent_account;

	public boolean amazon_logo() {
		testutils.wait.until(ExpectedConditions.visibilityOf(logo));
		int height = logo.getRect().getHeight();
		int width = logo.getRect().getWidth();
		Assert.assertEquals(height, 31);
		Assert.assertEquals(width, 103);
		return logo.isDisplayed();
	}

	public boolean check_create_account_option() {
		testutils.wait.until(ExpectedConditions.visibilityOf(creatent_account));
		return true;
	}

	// After login it return object of dashboard page
	public DashboardPage do_login(String un, String pass)
			throws InterruptedException, FileNotFoundException, IOException
	{
		email_field.sendKeys(un);
		continue_btn.click();
		password.sendKeys(pass);
		signbtn.click();
		// System.out.println("Login Successful");
		return new DashboardPage();
	}

}
