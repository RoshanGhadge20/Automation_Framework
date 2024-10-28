package BaseTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import CommonUtilities.Extent_Reports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {
    public static WebDriver driver;
    public static Properties pr;
    public static Extent_Reports testreports;

    public Base_Test() throws IOException, FileNotFoundException {
        // Load configuration properties
    	pr = new Properties();
        FileReader fin = new FileReader("E://Automation_Framework//POM//src//test//java//Configurations//config.properties");
        pr.load(fin);
    }

    @BeforeSuite
    public void setupReport() {
        testreports = new Extent_Reports(); 
        testreports.start_reporter();
    }

    @BeforeMethod
    public void active() {
        // Initialize WebDriver based on the browser property
        String browser = pr.getProperty("browser").toLowerCase();
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Webdriver not initialized");
        }

        // Load URL with exception handling
        try {
            driver.get(pr.getProperty("URL"));
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Unable to load URL: " + e.getMessage());
        }
    }

    @AfterMethod
    public void deactive() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        testreports.tear_down(); 
    }
}
