package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    public void initialize() throws IOException {
        active();
        loginpage = new Pages.LoginPage();
    }
    
    @Test(priority = 1, groups = {"Sanity"} , description = "check title of page on login page ")
    public void check_title() {
        String titleString = loginpage.getpagetitle();
        Assert.assertEquals(titleString, "Amazon Sign In", "Title of login page does not match");
    }
    
    @Test(priority = 2 , groups = {"Sanity"}, description = "Check amazon logo shown in login page")
    public void check_logo() {
        Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
    }
    
    @Test(priority = 3, groups = {"Sanity", "Regression"}, description = "verify user is able to login with valid credentials ")
    public void login() throws InterruptedException, FileNotFoundException, IOException {
        loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
