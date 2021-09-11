package com.nopccomerce.login;

import commons.BaseTest;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_14_Register_Login_Log_Extent_Report extends BaseTest {
    WebDriver driver;
    String emailAddress, password;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    LoginPageObject loginPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        emailAddress = generateRandomEmail();
        password = "1234aa";
    }

    @Test
    public void Login_01_Register(Method method) {
    	ExtentTestManager.startTest(method.getName(), "Login_01_Register");
    	ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 01: Verify Home Page is displayed");
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isHomePageSliderDisplayed());

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 03: Click to Male radio  button");
        registerPage.clickToGenderMaleRadioButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 04: Input to Firstname textbox");
        registerPage.inputToFirstnameTextbox("John");

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 05: Input to Lasttname textbox");
        registerPage.inputToLastnameTextbox("Terry");

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 06: Input to Email textbox");
        registerPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 07: Input to Password textbox");
        registerPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 08: Input to Confirmation textbox");
        registerPage.inputToConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 09: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 10: Verify Success message is displayed");
        verifyTrue(registerPage.isSuccessMessageDisplay());

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 11: Click to Logout link");
        homePage = registerPage.clickToLogoutLink();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Steps 12: Verify Home Page Slider is displayed");
        verifyFalse(homePage.isHomePageSliderDisplayed());
        
        ExtentTestManager.endTest();
    }

    @Test
    public void Login_02_Login(Method method) {
    	ExtentTestManager.startTest(method.getName(), "Login_02_Login");
        ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Register - Steps 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Register - Steps 02: Input to Email textbox with value: " + emailAddress);
        loginPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Register - Steps 03: Input to Password textbox with value: " + password);
        loginPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Register - Steps 05: Click to Login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Register - Steps 05: Verify Home Page Slider is displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
        
        ExtentTestManager.endTest();
    }

    @AfterClass
    public void afterClass() {
        ExtentTestManager.getTest().log(LogStatus.INFO, "Post-Condition: Close browser");
        driver.quit();
    }
}
