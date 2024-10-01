package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        loginpage = new LoginPage();
    }
    
    @Test(priority = 1)
    public void check_title() {
        String titleString = loginpage.getpagetitle();
        Assert.assertEquals(titleString, "Amazon Sign In", "Title of login page does not match");
    }
    
    @Test(priority = 2)
    public void check_logo() {
        Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
    }
    
    @Test(priority = 3)
    public void login() throws InterruptedException {
        loginpage.do_login(pr.getProperty("username"));
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
