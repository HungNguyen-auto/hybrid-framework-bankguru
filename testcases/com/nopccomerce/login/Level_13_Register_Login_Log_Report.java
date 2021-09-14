package com.nopccomerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_13_Register_Login_Log_Report extends BaseTest {
    WebDriver driver;
    String emailAddress, password;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    LoginPageObject loginPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
        driver = getBrowserDriver(browserName, appUrl);
        emailAddress = generateRandomEmail();
        password = "1234aa";
    }

    @Test
    public void Login_01_Register() {
        log.info("User_01_Register - Steps 01: Verify Home Page is displayed");
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isHomePageSliderDisplayed());

        log.info("User_01_Register - Steps 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        log.info("User_01_Register - Steps 03: Click to Male radio  button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("User_01_Register - Steps 04: Input to Firstname textbox");
        registerPage.inputToFirstnameTextbox("John");

        log.info("User_01_Register - Steps 05: Input to Lasttname textbox");
        registerPage.inputToLastnameTextbox("Terry");

        log.info("User_01_Register - Steps 06: Input to Email textbox");
        registerPage.inputToEmailTextbox(emailAddress);

        log.info("User_01_Register - Steps 07: Input to Password textbox");
        registerPage.inputToPasswordTextbox(password);

        log.info("User_01_Register - Steps 08: Input to Confirmation textbox");
        registerPage.inputToConfirmPasswordTextbox(password);

        log.info("User_01_Register - Steps 09: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - Steps 10: Verify Success message is displayed");
        verifyTrue(registerPage.isSuccessMessageDisplay());

        log.info("User_01_Register - Steps 11: Click to Logout link");
        homePage = registerPage.clickToLogoutLink();

        log.info("User_01_Register - Steps 12: Verify Home Page Slider is displayed");
        verifyFalse(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void Login_02_Login() {
        log.info("User_02_Register - Steps 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("User_02_Register - Steps 02: Input to Email textbox with value: " + emailAddress);
        loginPage.inputToEmailTextbox(emailAddress);

        log.info("User_02_Register - Steps 03: Input to Password textbox with value: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("User_02_Register - Steps 05: Click to Login button");
        loginPage.clickToLoginButton();

        log.info("User_02_Register - Steps 05: Verify Home Page Slider is displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        log.info("Post-Condition: Close browser");
        driver.quit();
    }
}
