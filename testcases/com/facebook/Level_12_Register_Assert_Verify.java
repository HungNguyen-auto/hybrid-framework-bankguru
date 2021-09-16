package com.facebook;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Register_Assert_Verify extends BaseTest {
    WebDriver driver;
    RegisterPageObject registerPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        Assert.assertTrue(false);
    }

    @Test
    public void Register_01_Element_Displayed() {
        // Failed lan 1
        verifyFalse(registerPage.isEmailTextboxDisplayed());
        registerPage.inputToEmailTextbox("henry@gmail.com");
        registerPage.sleepInSecond(2);

        //Fail lan 2
        verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
        registerPage.inputToEmailTextbox("");
        // Undisplayed: Invisible on UI + Exist in DOM
        registerPage.sleepInSecond(2);
        verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());

        verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());

        verifyFalse(registerPage.isLoginButtonDisplayed());

        // Failed lan 3
        verifyFalse(registerPage.isLoginButtonUndisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        cleanBrowserAndDriverIntances();
    }
}
