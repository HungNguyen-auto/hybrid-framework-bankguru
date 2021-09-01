package pageObjects.adminNopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.adminNopCommerce.ProductDetailPageUI;
import pageUIs.adminNopCommerce.ProductPageUI;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToProductNameTextBox(String productName) {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_NAME_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    public void clickOnSearchButton() {
        waitForElementClickable(driver, ProductPageUI.SEARCH_BUTTON);
        clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
    }

    public ProductDetailPageObject clickOnEditProduct(String productName) {
        waitForElementClickable(driver, ProductPageUI.EDIT_BY_PRODUCT_NAME, productName);
        clickToElement(driver, ProductPageUI.EDIT_BY_PRODUCT_NAME, productName);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, ProductPageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, ProductPageUI.SUCCESS_MESSAGE);
    }

    public boolean isImageUpdated(String productImageName, String productName) {
        productImageName = productImageName.replace(" ", "-").toLowerCase();
        waitForElementVisible(driver, ProductPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImageName);
        return  isElementDisplayed(driver, ProductPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImageName);
    }
}
