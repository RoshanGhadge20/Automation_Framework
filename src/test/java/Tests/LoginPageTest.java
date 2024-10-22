package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseTest.Base_Test;
import Pages.LoginPage;

public class LoginPageTest extends Base_Test {

    LoginPage loginpage;

    public LoginPageTest() throws IOException, FileNotFoundException {
        super();
    }

    @BeforeMethod
    public void initialize() throws IOException 
    {
        // Call parent method to initialize WebDriver and navigate to URL
        //active();
        loginpage = new Pages.LoginPage();
    }

    @Test(priority = 1, groups = {"Sanity"}, description = "Check title of login page")
    public void check_title() {
        testreports.test_details("Check title of login page");
        String titleString = loginpage.getpagetitle();
        Assert.assertEquals(titleString, "Amazon Sign In", "Title of login page does not match");
    }

    @Test(priority = 2, groups = {"Sanity"}, description = "Check Amazon logo is displayed on login page")
    public void check_logo() {
        testreports.test_details("Check Amazon logo displayed on login page");
        Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
    }

    @Test(priority = 3, groups = {"Sanity", "Regression"}, description = "Verify user can log in with valid credentials")
    public void login() throws InterruptedException, IOException {
        testreports.test_details("Verify user can log in with valid credentials");
        loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        testreports.getresult(result);  // Log the result of the current test
       // deactive();  // Quit the driver after each test
    }
}
