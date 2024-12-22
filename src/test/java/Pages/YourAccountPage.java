package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseTest.Base_Test;
import CommonUtilities.Testutils;

public class YourAccountPage extends Base_Test {

	Testutils testutils = new Testutils();

	public YourAccountPage() throws IOException, FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}

	// Object Pool of Webelements

	@FindBy(xpath = "//a[@aria-labelledby='Account & Lists']")
	WebElement YourAccount;

	@FindBy(xpath = "//h1[contains(text(),' Your Account')]")
	WebElement PageText;

	@FindBy(css = "div.a-box-inner")
	List<WebElement> Youraccount_options;

	// Test Methods

	public void navigate_to_youraccount() {
		YourAccount.click();
	}

	public WebElement check_page() {
		YourAccount.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(PageText));
		return PageText;
	}

	public void list_of_options() {
		int i = 1;
		YourAccount.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(PageText));
		for (WebElement ele : Youraccount_options) {
			System.out.println("Options in Your Account Page" + ele.getText() + i);
			i++;
		}
	}

}
