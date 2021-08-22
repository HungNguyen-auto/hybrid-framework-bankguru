package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForAllElementsVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public void loginToSystem(String emailAddress, String password) {
		inputToEmailAddressTextbox(emailAddress);
		inputToPasswordTextbox(password);
		clickToLoginButton();
	}

	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_VALIDATION);
		return getTextElement(driver, LoginPageUI.EMPTY_EMAIL_VALIDATION);
	}

	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_VALIDATION);
		return getTextElement(driver, LoginPageUI.EMPTY_PASSWORD_VALIDATION);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_VALIDATION);
		return getTextElement(driver, LoginPageUI.INVALID_EMAIL_VALIDATION);
	}

	public Object getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_VALIDATION);
		return getTextElement(driver, LoginPageUI.INVALID_PASSWORD_VALIDATION);
	}

	public String getIncorrectEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_VALIDATION);
		return getTextElement(driver, LoginPageUI.INCORRECT_EMAIL_VALIDATION);
	}

}
