package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class LoginPageObject extends BasePageFactory{
	private WebDriver driver;

	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginLink;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, loginLink);
		scrollToElement(driver, loginLink);
		sleepInSecond(1);
		clickToElement(driver, loginLink);
		return PageGeneratorManager.getHomePage(driver);
	}

}
