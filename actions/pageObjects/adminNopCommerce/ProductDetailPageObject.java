package pageObjects.adminNopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.adminNopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
    WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void expandSectionByTitle(String title) {
        waitForElementVisible(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, title);
        String toogleIconStatus = getAttributeValue(driver,ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class" ,title);
        if(toogleIconStatus.contains("fa-plus")){
            waitForElementClickable(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, title);
            clickToElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, title);
        }
    }

    public void clickOnAddProductPictureButton() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
    }

    public ProductPageObject clickOnButton(String name) {
        waitForElementClickable(driver, ProductDetailPageUI.ACTION_BUTTON_BY_NAME, name);
        clickToElement(driver, ProductDetailPageUI.ACTION_BUTTON_BY_NAME, name);
        return PageGeneratorManager.getProductPage(driver);
    }

    public boolean isImageLoadedByFileName(String fileName) {
        fileName = fileName.split("\\.")[0];
        waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_PICTURE_BLOCK_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, ProductDetailPageUI.PRODUCT_PICTURE_BLOCK_BY_FILE_NAME, fileName);
    }

    public void inputToTitleTextbox(String imageTitle) {
        waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW);
        sendkeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, imageTitle);
    }

    public boolean isImageDisplayed(String imageName, String imageTitle) {
        imageName = imageName.replace(" ", "-").toLowerCase();
        waitForElementVisible(driver, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, imageTitle);
        return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, imageTitle);
    }

    public void clickOnDeleteButtonAtPictureName(String imageTitle) {
        waitForElementClickable(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
        clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
        acceptAlert(driver);
    }
}
