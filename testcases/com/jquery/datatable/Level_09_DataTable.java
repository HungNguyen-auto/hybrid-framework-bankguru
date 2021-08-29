package com.jquery.datatable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void Table_01_Paging() {
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActived("15"));

        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageActived("10"));
    }

    //@Test
    public void Table_02_Input_Header_Textbox() {
        homePage.inputToHeaderTextboxByName("Females", "43400");
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Males", "45100");
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Country", "Syrian Arab Rep");
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void Table_03_Click_Icon() {
        homePage.clickToIconByCountryName("Afghanistan", "remove");
        homePage.sleepInSecond(3);

        homePage.clickToIconByCountryName("Angola", "remove");
        homePage.sleepInSecond(3);

        homePage.clickToIconByCountryName("Aruba", "edit");
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);

        homePage.clickToIconByCountryName("Armenia", "edit");
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void Table_04_Verify_Row_Values() {
        homePage.inputToHeaderTextboxByName("Country", "Afghanistan");

        Assert.assertTrue(homePage.isExpectedRowDisplayed("384187", "Afghanistan", "407124", "791312"));
        homePage.sleepInSecond(3);
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void Table_05_Input_To_Row_Textbox() {
        homePage.inputToTextboxByRowNumber("Contact Person", "3", "Cardi B");
        homePage.inputToTextboxByRowNumber("Order Placed", "1", "5");
        homePage.inputToTextboxByRowNumber("Company", "2", "Nexdev");
        homePage.inputToTextboxByRowNumber("Member Since", "2", "03/27/1997");
    }

    @Test
    public void Table_06_Click_To_Icon() {
        homePage.clickToIconByTitle("Move Up", "2");
        homePage.sleepInSecond(2);
        homePage.clickToIconByTitle("Move Up", "3");
        homePage.sleepInSecond(2);
        homePage.clickToIconByTitle("Remove Current Row", "3");
        homePage.sleepInSecond(2);
        homePage.clickToIconByTitle("Insert Row Above", "2");
        homePage.sleepInSecond(2);
        homePage.clickToIconByTitle("Move Down", "1");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

