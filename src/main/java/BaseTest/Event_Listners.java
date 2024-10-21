package BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import BaseTest.Base_Test;

public class Event_Listners implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert get accepted");

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert get dismissed");
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on element" + element.getText());

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Webelement get fetched");

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("Screenshot Taken");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to url " + driver.getCurrentUrl());
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forword to url " + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page Refreshed");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to URL " + driver.getCurrentUrl());

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Switched to window " + windowName);

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception get caught" + throwable.getMessage());

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	}

}
