package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.AddEmployeePageUI;

public class AddEmployeePO extends BasePage{
	WebDriver driver;

	public AddEmployeePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByID(String textboxID, String value) {
		waitForElementClickable(driver, AddEmployeePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, AddEmployeePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getAttributeValue(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "value");
	}

	public void clickOnCreateLoginDetailsCheckbox() {
		if(isElementDisplayed(driver, AddEmployeePageUI.LOGIN_DETAIL_USERNAME_LABEL)){
			waitForElementClickable(driver, AddEmployeePageUI.CREATE_LOGIN_DETAIL_CHECKBOX);
			clickToElement(driver, AddEmployeePageUI.CREATE_LOGIN_DETAIL_CHECKBOX);
		}
	}

	public void selectValueInStatusDropdown(String statusValue) {
		selectDropdownByText(driver, AddEmployeePageUI.STATUS_DROPDOWN_LIST, statusValue);
	}

	public PersonalDetailPO clickOnSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.ADD_BUTTON);
		clickToElement(driver, AddEmployeePageUI.ADD_BUTTON);
		return PageGeneratorManager.getPersonalDetailPage(driver);
	}
}