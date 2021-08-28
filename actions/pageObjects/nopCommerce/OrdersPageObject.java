package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.MyAccountPageUI;
import pageUIs.nopCommerce.OrdersPageUI;

public class OrdersPageObject extends BasePage {
    WebDriver driver;

    public OrdersPageObject(WebDriver driver){
        this.driver = driver;
    }

}
