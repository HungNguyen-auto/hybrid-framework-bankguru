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

public class Level_16_Register_Login_Pattern_Object extends BaseTest {
    WebDriver driver;
    String emailAddress, password, date, month, year;
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
        date = "27"; 
        month = "March";
        year = "1997";
    }

    @Test
    public void Login_01_Register() {
        log.info("User_01_Register - Steps 01: Verify Home Page is displayed");
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isHomePageSliderDisplayed());

        log.info("User_01_Register - Steps 02: Click to Register Link");
        homePage.openHeaderPageByName(driver, "Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        log.info("User_01_Register - Steps 03: Click to Male radio  button");
        registerPage.clickToGenderMaleRadioButton();
        registerPage.clickToRadioByID(driver, "gender-male");

        log.info("User_01_Register - Steps 04: Input to Firstname textbox");
        registerPage.inputToTextboxByID(driver, "FirstName", "John");

        log.info("User_01_Register - Steps 05: Input to Lasttname textbox");
        registerPage.inputToTextboxByID(driver, "LastName", "Terry");

        log.info("User_01_Register - Steps 06: Input to Email textbox");
        registerPage.inputToTextboxByID(driver, "Email", emailAddress);

        log.info("User_01_Register - Steps 07: Input to Password textbox");
        registerPage.inputToTextboxByID(driver, "Password", password);

        log.info("User_01_Register - Steps 08: Input to Confirmation textbox");
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
        
        log.info("User_01_Register - Steps 09: Select item in Date dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
        
        log.info("User_01_Register - Steps 10: Select item in Month dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
        
        log.info("User_01_Register - Steps 11: Select item in Year dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

        log.info("User_01_Register - Steps 12: Click to Register button");
        registerPage.clickToButtonByText(driver, "Register");

        log.info("User_01_Register - Steps 13: Verify Success message is displayed");
        verifyTrue(registerPage.isSuccessMessageDisplay());

        log.info("User_01_Register - Steps 14: Click to Logout link");
        registerPage.openHeaderPageByName(driver, "Log out");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("User_01_Register - Steps 15: Verify Home Page Slider is displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void Login_02_Login() {
        log.info("User_02_Register - Steps 01: Click to Login link");
        homePage.openHeaderPageByName(driver, "Log in");
        loginPage = PageGeneratorManager.getLoginPage(driver);

        log.info("User_02_Register - Steps 02: Input to Email textbox with value: " + emailAddress);
        loginPage.inputToTextboxByID(driver, "Email", emailAddress);

        log.info("User_02_Register - Steps 03: Input to Password textbox with value: " + password);
        loginPage.inputToTextboxByID(driver, "Password", password);

        log.info("User_02_Register - Steps 05: Click to Login button");
        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("User_02_Register - Steps 05: Verify Home Page Slider is displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        log.info("Post-Condition: Close browser");
        driver.quit();
    }
}
