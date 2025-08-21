package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import BaseTest.Base_Test;
import CommonUtilities.Testutils;

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
	private WebElement email_field;

	@FindBy(css = "span#continue")
	@CacheLookup
	private WebElement continue_btn;

	@FindBy(css = ".a-icon-logo")
	private WebElement logo;

	@FindBy(css = "input[name='password']")
	@CacheLookup
	private WebElement password;

	@FindBy(css = "input#signInSubmit")
	@CacheLookup
	private WebElement signbtn;

	@FindBy(xpath = "//h5[contains(text(),'New to Amazon?')]")
	private WebElement newToAmazonText;

	@FindBy(css = "#createAccountSubmit")
	private WebElement creatent_account;

	// Test Methods

	public boolean amazon_logo() {
		testutils.wait.until(ExpectedConditions.visibilityOf(logo));
		testutils.highlightElement(logo, 2000);
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
			throws InterruptedException, FileNotFoundException, IOException {
		email_field.sendKeys(un);
		continue_btn.click();
		password.sendKeys(pass);
		signbtn.click();
		// System.out.println("Login Successful");
		return new DashboardPage();
	}

	// After login it return object for youaccount page
	public YourAccountPage logining(String un, String pass)
			throws InterruptedException, FileNotFoundException, IOException {
		email_field.sendKeys(un);
		continue_btn.click();
		password.sendKeys(pass);
		signbtn.click();
		// System.out.println("Login Successful");
		return new YourAccountPage();
	}

}
