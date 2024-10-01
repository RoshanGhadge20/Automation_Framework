package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.Base_Test;

public class LoginPage extends Base_Test {

	public LoginPage() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// object pool ( Weblements )
	@FindBy(css = "input#ap_email")
	WebElement email_field;

	@FindBy(css = "span#continue")
	WebElement continue_btn;

	@FindBy(css = ".a-icon-logo")
	WebElement logo;

	public String getpagetitle() {
		return driver.getTitle();
	}

	public boolean amazon_logo() {
		wait.until(ExpectedConditions.visibilityOf(logo));
		return logo.isDisplayed();
	}

	public void do_login(String un) throws InterruptedException {
		email_field.sendKeys(un);
		Thread.sleep(2000);
		continue_btn.click();
		System.out.println("Login Successful");
	}

}
