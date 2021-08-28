package com.nopccomerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

public class Level_07_Register_Login_Switch_Page extends BaseTest {
    WebDriver driver;
    String emailAddress, password;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    SearchPageObject searchPage;
    OrdersPageObject ordersPage;
    MyAccountPageObject myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        System.out.println(appUrl);
        driver = getBrowserDriver(browserName, appUrl);
        emailAddress = generateRandomEmail();
        password = "1234aa";
    }

    @Test
    public void Login_01_Register() {
        homePage = PageGeneratorManager.getHomePage(driver);

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
    @Test
    public void Login_03_Switch_Page_At_Footer() {
        // Home -> Search Page
        searchPage = homePage.openSearchPage(driver);

        // Search -> My Account Page
        myAccountPage = searchPage.openMyAccountPage(driver);

        // My Account -> Order
        ordersPage = myAccountPage.openOrdersPage(driver);

        // Order -> My Account
        myAccountPage = ordersPage.openMyAccountPage(driver);

        // -> search
        searchPage = myAccountPage.openSearchPage(driver);

        /// -> Order
        ordersPage = searchPage.openOrdersPage(driver);

    }
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
}
