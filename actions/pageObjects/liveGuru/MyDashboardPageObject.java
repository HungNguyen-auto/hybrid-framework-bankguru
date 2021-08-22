package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER);
	}

}