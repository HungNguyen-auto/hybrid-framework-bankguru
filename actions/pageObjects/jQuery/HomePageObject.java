package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
    }

    public boolean isPageActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_NUMBER_ACTIVE, pageNumber);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_PAGE_NUMBER_ACTIVE, pageNumber);
    }

    public void inputToHeaderTextboxByName(String headerName, String value) {
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX, headerName);
        sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, value, headerName);
        pressKeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, Keys.ENTER, headerName);
    }

    public void clickToIconByCountryName(String countryName, String actionName) {
        waitForElementVisible(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, actionName);
        clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, actionName);
    }

    public boolean isExpectedRowDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.EXPECTED_ROW_SEARCH, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.EXPECTED_ROW_SEARCH, females, country, males, total);
    }

    public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
        int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
        waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
        sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
    }

    public void clickToIconByTitle(String actionName, String rowIndex) {
        waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_TITLE_ROW_INDEX, rowIndex, actionName);
        clickToElement(driver, HomePageUI.ACTION_ICON_BY_TITLE_ROW_INDEX, rowIndex, actionName);
    }
}
