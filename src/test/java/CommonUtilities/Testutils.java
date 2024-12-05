package CommonUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v127.log.model.LogEntry;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseTest.Base_Test;

public class Testutils extends Base_Test {

	public Testutils() throws IOException, FileNotFoundException {
		super();
	}

	// Added JavascriptExecutor & cascaded with driver obj
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Implemented Webdriver wait (Explicit Wait)
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	// Implementing TakeScreenshot Utility
	public void TakeScreenShot() throws IOException {
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date d = new Date();
		// String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = "E://Automation_Framework//POM//Screenshot//" + "ScreenShot" + df.format(d) + ".png";
		TakesScreenshot TS = (TakesScreenshot) driver;
		File fs = TS.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(fs, des);
	}

	// Implemented select option utility
	public void select(WebElement element, String sel_element) {
		Select sc = new Select(element);
		sc.selectByVisibleText(sel_element);
	}

	// Implemented window handle functionality
	public void window_handles() {
		String parent_win = driver.getWindowHandle();
		Set<String> win_handle = driver.getWindowHandles();
		Iterator<String> it = win_handle.iterator();
		while (it.hasNext()) {
			String win = it.next();
			System.out.println(win);
		}
		driver.switchTo().window(parent_win);
	}

	// Implementing Page ScrollDown / ScrollUp
	public void scroll_down(int x, int y) {
		js.executeScript("window.scrollBy(x,y)", "");
	}

	// Added scrollintoview for element
	public void scroll_to_element(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Added Alert Utility
	public void accept_alert() {
		driver.switchTo().alert().accept();
	}

	public void dismiss_alert() {
		driver.switchTo().alert().dismiss();
	}

	public void get_text_alert() {
		String alert_text = driver.switchTo().alert().getText();
		System.out.println("Alert Text :- " + alert_text);
	}

	// Highlight an element during testing for debugging
	public void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// File Upload Utility
	public void upload_file(WebElement element, String file_path) {
		element.sendKeys(file_path);
	}

}
