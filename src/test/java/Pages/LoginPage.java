package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
	WebElement email_field;

	@FindBy(css = "span#continue")
	WebElement continue_btn;

	@FindBy(css = ".a-icon-logo")
	WebElement logo;
	
	@FindBy(css ="input[name='password']")
	WebElement password;
	
	@FindBy (css = "input#signInSubmit")
	WebElement signbtn;

	public String getpagetitle() {
		return driver.getTitle();
	}

	public boolean amazon_logo() {
		testutils.wait.until(ExpectedConditions.visibilityOf(logo));
		return logo.isDisplayed();
	}

	// After login it return object of dashboard page 
	public DashboardPage do_login(String un, String pass) throws InterruptedException, FileNotFoundException, IOException {
		email_field.sendKeys(un);
		continue_btn.click();
		password.sendKeys(pass);
		signbtn.click();
		//System.out.println("Login Successful");
		return new DashboardPage();
	}

}
