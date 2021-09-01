package pageObjects.adminNopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.adminNopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

}

