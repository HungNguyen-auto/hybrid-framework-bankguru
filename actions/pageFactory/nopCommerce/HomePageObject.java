package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;
	//UI
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className="ico-register")
	WebElement registerLink;
	
	@FindBy(className="ico-login")
	WebElement loginLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Action
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
