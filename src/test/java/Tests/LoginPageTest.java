package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseTest.Base_Test;
import CommonUtilities.ExcelUtility;
import Pages.LoginPage;
import ScreenRecording.*;
public class LoginPageTest extends Base_Test {

    LoginPage loginpage;
    CaptureVideo capturevideo;
    

    public LoginPageTest() throws IOException, FileNotFoundException 
    {
        super();
    }

    @BeforeMethod
    public void initialize() throws IOException 
    {
        loginpage = new Pages.LoginPage();
        capturevideo = new CaptureVideo();
    }

    @Test(priority = 1, groups = {"Sanity"}, description = "Title of Login Page")
    public void check_title() throws IOException 
    {
        testreports.test_details("Check title of login page");
        String titleString = loginpage.getpagetitle();
        Assert.assertEquals(titleString, "Amazon Sign In", "Title does not match");
    }

    @Test(priority = 2, groups = {"Sanity"}, description = "Validate appearance & size of logo")
    public void check_logo() 
    {
        testreports.test_details("Verify Amazon logo displays on login page");
        Assert.assertTrue(loginpage.amazon_logo(), "Logo is not displayed");
    }

    @Test(priority = 3, groups = {"Sanity", "Regression"}, description = "login with valid credentials")
    public void login() throws InterruptedException, IOException 
    {
    	capturevideo.StartRecording();
        testreports.test_details("Verify user can log in with valid credentials");
        capturevideo.StopRecording();
        loginpage.do_login(pr.getProperty("username"), pr.getProperty("password"));
    }
    
    @Test(priority = 4, groups = {"Sanity"}, description = "Verify Create_account option in login page")
    public void verify_createaccount_option()
    {
    	testreports.test_details("Verify Create_account option in login page");
    	Assert.assertTrue(loginpage.check_create_account_option());
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        testreports.getresult(result);  
    }
}
