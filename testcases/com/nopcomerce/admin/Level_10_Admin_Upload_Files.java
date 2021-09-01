package com.nopcomerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.adminNopCommerce.*;

import java.io.File;

public class Level_10_Admin_Upload_Files extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    ProductPageObject productPageObject;
    ProductDetailPageObject productDetailPageObject;
    String productName = "Adobe Photoshop CS4";
    String productImage = "dog.jpg";
    String imageTitle = "demo";
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        loginPageObject = PageGeneratorManager.getLoginPage(driver);

        loginPageObject.inputToUsername("admin@yourstore.com");
        loginPageObject.inputToPassword("admin");
        homePageObject = loginPageObject.clickOnLoginButton();

        homePageObject.openSubMenuByName(driver,"Catalog", "Products");
        productPageObject = PageGeneratorManager.getProductPage(driver);

        productPageObject.inputToProductNameTextBox(productName);
        productPageObject.clickOnSearchButton();

        productDetailPageObject = productPageObject.clickOnEditProduct(productName);
    }

    @Test
    public void Login_01_Upload_File() {
        productDetailPageObject.expandSectionByTitle("Pictures");

        productDetailPageObject.uploadFilesByCardName(driver, "pictures", productImage);

        productDetailPageObject.sleepInSecond(2);

        Assert.assertTrue(productDetailPageObject.isImageLoadedByFileName(productImage));

        productDetailPageObject.inputToTitleTextbox(imageTitle);

        productDetailPageObject.clickOnAddProductPictureButton();

        Assert.assertTrue(productDetailPageObject.isImageDisplayed(productName,imageTitle));

        productPageObject = productDetailPageObject.clickOnButton("save");

        Assert.assertTrue(productPageObject.isSuccessMessageDisplayed());

        productPageObject.inputToProductNameTextBox(productName);

        productPageObject.clickOnSearchButton();

        Assert.assertTrue(productPageObject.isImageUpdated(productName, productName));

        productDetailPageObject = productPageObject.clickOnEditProduct(productName);

        productDetailPageObject.expandSectionByTitle("Pictures");

        productDetailPageObject.clickOnDeleteButtonAtPictureName(imageTitle);

        productPageObject = productDetailPageObject.clickOnButton("save");

        productPageObject.inputToProductNameTextBox(productName);

        productPageObject.clickOnSearchButton();

        Assert.assertTrue(productPageObject.isImageUpdated("default-image", productName));
    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
    // test commit
}
