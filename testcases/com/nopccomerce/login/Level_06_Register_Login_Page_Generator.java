package com.nopccomerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_06_Register_Login_Page_Generator extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    HomePageObject homePage;
    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    //test commit testtttttttttttttt
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        System.out.println(appUrl);
        driver = getBrowserDriver(browserName, appUrl);
        emailAddress = generateRandomEmail();
        password = "1234aa";

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Login_01_Register() {

        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToGenderMaleRadioButton();

        registerPage.inputToFirstnameTextbox("John");

        registerPage.inputToLastnameTextbox("Terry");

        registerPage.inputToEmailTextbox(emailAddress);

        registerPage.inputToPasswordTextbox(password);

        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertTrue(registerPage.isSuccessMessageDisplay());

        homePage = registerPage.clickToLogoutLink();

        Assert.assertTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void Login_02_Login() {
        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(emailAddress);

        loginPage.inputToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isHomePageSliderDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
