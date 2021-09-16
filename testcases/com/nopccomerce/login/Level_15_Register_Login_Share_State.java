package com.nopccomerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_15_Register_Login_Share_State extends BaseTest {
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
        
        homePage = PageGeneratorManager.getHomePage(driver);
    }
    
    @Test
    public void Login_01_Login() {
        log.info("User_02_Register - Steps 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("User_02_Register - Steps 02: Set Login page cookie");
        loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);

        log.info("User_02_Register - Steps 03: Click to HomePage image");
        homePage = loginPage.openHomePage();
        
        log.info("User_02_Register - Steps 04: Verify Home Page Slider is displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }
    
    @Test
    public void Login_02_Create() {
    	
    }
    
    @Test
    public void Login_03_Edit() {
    	
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        log.info("Post-Condition: Close browser");
        cleanBrowserAndDriverIntances();
    }
}
