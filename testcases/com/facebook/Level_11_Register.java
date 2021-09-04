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

public class Level_11_Register extends BaseTest {
    WebDriver driver;
    RegisterPageObject registerPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void Register_01_Element_Displayed() {
        //Displayed : Visible on UI + Exist in DOM
        Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
        registerPage.inputToEmailTextbox("henry@gmail.com");
        Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void Register_02_Element_Undisplayed_In_DOM() {
        registerPage.inputToEmailTextbox("");
        // Undisplayed: Invisible on UI + Exist in DOM
        registerPage.sleepInSecond(2);
        Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());

        Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
    }
    @Test
    public void Register_03_Element_Undisplayed_Not_In_DOM() {
        Assert.assertFalse(registerPage.isLoginButtonDisplayed());
    }
    @Test
    public void Register_04_Element_Undisplayed_Not_In_DOM() {
        Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
