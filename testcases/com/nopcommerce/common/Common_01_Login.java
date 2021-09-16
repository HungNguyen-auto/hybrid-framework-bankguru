package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Common_01_Login extends BaseTest {
	  WebDriver driver;
	    String emailAddress, password;
	    HomePageObject homePage;
	    RegisterPageObject registerPage;
	    LoginPageObject loginPage;
	    public static Set<Cookie> loginPageCookie;
	    
	    @Parameters({"browser", "url"})
	    @BeforeTest
	    public void beforeClass(String browserName, String appUrl) {
	        log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
	        driver = getBrowserDriver(browserName, appUrl);
	        emailAddress = generateRandomEmail();
	        password = "1234aa";

	        log.info("Common_01 - Steps 01: Verify Home Page is displayed");
	        homePage = PageGeneratorManager.getHomePage(driver);
	        verifyTrue(homePage.isHomePageSliderDisplayed());

	        log.info("Common_01 - Steps 02: Click to Register Link");
	        registerPage = homePage.clickToRegisterLink();

	        log.info("Common_01 - Steps 03: Click to Male radio  button");
	        registerPage.clickToGenderMaleRadioButton();

	        log.info("Common_01 - Steps 04: Input to Firstname textbox");
	        registerPage.inputToFirstnameTextbox("John");

	        log.info("Common_01 - Steps 05: Input to Lasttname textbox");
	        registerPage.inputToLastnameTextbox("Terry");

	        log.info("Common_01 - Steps 06: Input to Email textbox");
	        registerPage.inputToEmailTextbox(emailAddress);

	        log.info("Common_01 - Steps 07: Input to Password textbox");
	        registerPage.inputToPasswordTextbox(password);

	        log.info("Common_01 - Steps 08: Input to Confirmation textbox");
	        registerPage.inputToConfirmPasswordTextbox(password);

	        log.info("Common_01 - Steps 09: Click to Register button");
	        registerPage.clickToRegisterButton();

	        log.info("Common_01 - Steps 10: Verify Success message is displayed");
	        verifyTrue(registerPage.isSuccessMessageDisplay());

	        log.info("Common_01 - Steps 11: Click to Logout link");
	        homePage = registerPage.clickToLogoutLink();

	        log.info("Common_01 - Steps 12: Verify Home Page Slider is displayed");
	        verifyFalse(homePage.isHomePageSliderDisplayed());

	        log.info("Common_01 - Steps 13: Click to Login link");
	        loginPage = homePage.clickToLoginLink();

	        log.info("Common_01 - Steps 14: Input to Email textbox with value: " + emailAddress);
	        loginPage.inputToEmailTextbox(emailAddress);

	        log.info("Common_01 - Steps 15: Input to Password textbox with value: " + password);
	        loginPage.inputToPasswordTextbox(password);

	        log.info("Common_01 - Steps 16: Click to Login button");
	        loginPage.clickToLoginButton();

	        log.info("Common_01 - Steps 17: Verify Home Page Slider is displayed");
	        verifyTrue(homePage.isHomePageSliderDisplayed());
	        
	        log.info("Common_01 - Steps 18: Get all login page cookies");
	        loginPageCookie = homePage.getAllCookies(driver);
	        
	        cleanBrowserAndDriverIntances();
	        
	    }
}
