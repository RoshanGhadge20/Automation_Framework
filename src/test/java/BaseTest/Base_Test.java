package BaseTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import CommonUtilities.Extent_Reports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base_Test {

	public static WebDriver driver;
	public static Properties pr;
	public static Extent_Reports testreports;
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.Base_Test.class);

	public Base_Test() throws IOException, FileNotFoundException {
		// Load configuration properties
		pr = new Properties();
		FileReader fin = new FileReader(
				"E://Automation_Framework//POM//src//test//java//Configurations//config.properties");
		pr.load(fin);
	}

	@BeforeSuite
	public void setupReport() {
		testreports = new Extent_Reports();
		testreports.start_reporter();
	}

	@BeforeMethod
	public void active() {
		logger.info("Initialize WebDriver based on the browser property");
		String browser = pr.getProperty("browser").toLowerCase();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		// Setting up behaviour of chromedriver
		/*
		 * options.addArguments("Headless"); String downloadpath="E://"; HashMap<String,
		 * Object> chromepref=new HashMap<String, Object>();
		 * chromepref.put("profile.default_content_setting_popup", 0); c
		 * hromepref.put("download.default_directory", downloadpath);
		 */

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				logger.info("ChromeDriver initiated");
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("FirefoxDriver initiated");
			}
		} catch (Exception e) {
			logger.info("Exception is caught while initializing the driver :- " + e.getMessage());
			System.out.println("Webdriver not initialized");
		}

		// logger.info("URL with exception handling");
		try {
			driver.get(pr.getProperty("URL"));
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Unable to load URL: " + e.getMessage());
		}
		logger.info("Fetched URL Successfully ");
	}

	@AfterMethod
	public void deactive() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
			logger.info("After method all cookies are cleared & driver close");
		}
	}

	@AfterSuite
	public void tearDownReport() {
		testreports.tear_down();
	}

}
