package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.Base_Test;
import BaseTest.Extent_Reports;
import Pages.LoginPage;

public class LoginPageTest extends Base_Test {

    LoginPage loginpage;
    Extent_Reports testreports; // Declare Extent_Reports here

    public LoginPageTest() throws IOException, FileNotFoundException {
        super();
    }

    @BeforeClass
    public void setupReport() {
        testreports = new Extent_Reports(); // Initialize Extent_Reports once
        testreports.start_reporter(); // Start the reporter once before all tests
    }

    @BeforeMethod
    public void initialize() throws IOException {
        active(); // Initialize WebDriver and navigate to the URL
        loginpage = new Pages.LoginPage();
    }

    @Test(priority = 1, groups = {"Sanity"}, description = "Check title of page on login page")
    public void check_title() {
        testreports.test_details("Check title of login page"); // Log test details
        String titleString = loginpage.getpagetitle();
        Assert.assertEquals(titleString, "Amazon Sign In", "Title of login page does not match");
    }

    @Test(priority = 2, groups = {"Sanity"}, description = "Check amazon logo shown in login page")
    public void check_logo() {
        testreports.test_details("Check amazon logo shown in login page"); // Log test details
        Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
    }

    @Test(priority = 3, groups = {"Sanity", "Regression"}, description = "Verify user is able to login with valid credentials")
    public void login() throws InterruptedException, FileNotFoundException, IOException {
        testreports.test_details("Verify user is able to login with valid credentials"); // Log test details
        loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        testreports.getresult(result);  // Log the result of the current test in the report
        deactive(); // Quit the driver after each test
    }
    
    @AfterClass
    public void tearDownReport() {
        testreports.tear_down();  // Finalize report generation once after all tests
      
    }
}
