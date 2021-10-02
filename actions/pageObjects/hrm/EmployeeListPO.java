package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.EmployeeListPageUI;

public class EmployeeListPO extends BasePage{
	WebDriver driver;

	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

	public AddEmployeePO clickOnAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return PageGeneratorManager.getAddEmployeePage(driver);
	}

	public void inputToEmployeeNameTextbox(String employeeName) {
		waitForElementInvisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_LOADING_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
	}

	public boolean isEmployeeInfoDisplayed(String employeeID, String firstname, String lastname) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_INFO_SEARCH, employeeID, firstname, lastname);
		return isElementDisplayed(driver, EmployeeListPageUI.EMPLOYEE_INFO_SEARCH, employeeID, firstname, lastname);
	}

	public void clickOnSearchButton() {
		waitForElementClickable(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
	}
}
