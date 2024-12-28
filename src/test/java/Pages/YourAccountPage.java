package Pages;

import java.awt.RenderingHints.Key;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(css = "a.ya-card__whole-card-link")
	List<WebElement> linksElements;
	
	

	// Actions class
	Actions act = new Actions(driver);

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

	public void verify_redirection_of_links() throws IOException
	{
		YourAccount.click();
		testutils.wait.until(ExpectedConditions.visibilityOf(PageText));
		for (WebElement element: linksElements) 
		{
			//act.keyDown(Keys.CONTROL).click(element).build().perform();
			
			String href = element.getAttribute("href");
			
			if (href == null || href.isEmpty()) {
                System.out.println("Skipping link: href is null or empty");
                continue; // Skip invalid links
            }
			
			try {
				
			 URL url = new URL(href);

	            // Open an HTTP connection to the URL
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            // Set request method to HEAD for faster response
	            connection.setRequestMethod("HEAD");

	            // Connect to the URL
	            connection.connect();

	            // Get the response code
	            int responseCode = connection.getResponseCode();

	            // Print or log the response code
	            if (responseCode >= 200 && responseCode < 300) {
	                System.out.println(href + " is valid with response code: " + responseCode);
	            } else {
	                System.out.println(href + " is broken with response code: " + responseCode);
	            }
	            
			}
	            catch (Exception e) {
	            		System.out.println("Exception Caught "+ e.getMessage());
				}
		}
	

	}
}
