package pageObjects.sourcelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public InventoryPageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getInventoryPage(driver);
	}
	

}
