package BaseTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {
    public static WebDriver driver;
    public static Properties pr;
    public static Extent_Reports testreports;  // Use static for shared access

    public Base_Test() throws IOException, FileNotFoundException {
        // Load configuration properties
        FileReader fin = new FileReader("E://Automation_Framework//POM//src//test//java//Configurations//config.properties");
        pr = new Properties();
        pr.load(fin);
    }

    public void active() {
        // Initialize WebDriver based on the browser property
        if (pr.getProperty("browser").equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (pr.getProperty("browser").equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Driver object is not yet initialized");
        }

        try {
            driver.get(pr.getProperty("URL"));
        } catch (Exception e) {
            System.out.println("Unable to load URL: " + e.getMessage());
        }

        driver.manage().window().maximize();
    }

    public void deactive() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
      
    }
}
