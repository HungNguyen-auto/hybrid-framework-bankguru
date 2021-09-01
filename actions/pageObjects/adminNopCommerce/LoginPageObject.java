package pageObjects.adminNopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.adminNopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputToUsername(String username) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void inputToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickOnLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
