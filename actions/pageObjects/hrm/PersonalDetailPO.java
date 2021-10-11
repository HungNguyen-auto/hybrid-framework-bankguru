package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.PersonalDetailPageUI;

public class PersonalDetailPO extends BasePage {
	WebDriver driver;
	String width;

	public PersonalDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnAvatar() {
		waitForElementClickable(driver, PersonalDetailPageUI.AVATAR_IMAGE);
		clickToElement(driver, PersonalDetailPageUI.AVATAR_IMAGE);
	}

	public void UploadNewImage(String filePath, String controlID) {
		uploadFile(driver, PersonalDetailPageUI.UPLOAD_FILE, filePath, controlID);

		waitForElementClickable(driver, PersonalDetailPageUI.UPLOAD_BUTTON, controlID);
		clickToElement(driver, PersonalDetailPageUI.UPLOAD_BUTTON, controlID);
	}

	public void selectGenderRadioByText(String gender) {
		waitForElementClickable(driver, PersonalDetailPageUI.DYNAMIC_GENDER_RADIO, gender);
		checkToCheckboxOrRadio(driver, PersonalDetailPageUI.DYNAMIC_GENDER_RADIO, gender);
	}

	public void selectDropdownByText(String dropdownID, String country) {
		waitForElementClickable(driver, PersonalDetailPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectDropdownByText(driver, PersonalDetailPageUI.DYNAMIC_DROPDOWN_BY_ID, country, dropdownID);
	}

	public void selectBloodTypeByText(String bloodType) {
		waitForElementClickable(driver, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN);
		selectDropdownByText(driver, PersonalDetailPageUI.BLOOD_TYPE_DROPDOWN, bloodType);
	}

	public void uploadAttachments(String attachmentPath, String controlID) {
		uploadFile(driver, PersonalDetailPageUI.UPLOAD_FILE, attachmentPath, controlID);
	}

	public boolean isAttachmentUploaded(String tableID,String attachmentName) {
		waitForElementVisible(driver,PersonalDetailPageUI.ATTACHMENT_INFO, tableID, attachmentName);
		return isElementDisplayed(driver,PersonalDetailPageUI.ATTACHMENT_INFO, tableID, attachmentName);
	}

	public boolean isEmergencyContactAdded(String firstname, String relationship, String homePhone) {
		waitForElementVisible(driver, PersonalDetailPageUI.EMERGENCY_CONTACT_INFO, firstname, relationship, homePhone);
		return isElementDisplayed(driver, PersonalDetailPageUI.EMERGENCY_CONTACT_INFO, firstname, relationship, homePhone);
	}

	public boolean isDependentAdded(String name, String relationship, String dob) {
		waitForElementVisible(driver, PersonalDetailPageUI.DEPENDENT_INFO, name, relationship,dob);
		return isElementDisplayed(driver, PersonalDetailPageUI.DEPENDENT_INFO, name, relationship,dob);
	}

	public boolean isContractDetailsAttached(String attachmentName) {
		waitForElementVisible(driver, PersonalDetailPageUI.CONTRACT_DETAILS, attachmentName);
		return isElementDisplayed(driver, PersonalDetailPageUI.CONTRACT_DETAILS, attachmentName);
	}

	public void checkOnCheckboxByID(String checkboxID) {
		waitForElementClickable(driver, PersonalDetailPageUI.DYNAMIC_CHECKBOX_BY_ID, checkboxID);
		checkToCheckboxOrRadio(driver, PersonalDetailPageUI.DYNAMIC_CHECKBOX_BY_ID, checkboxID);
	}

	public void checkOnCheckboxByClass(String checkboxClass) {
		waitForElementClickable(driver, PersonalDetailPageUI.DYNAMIC_CHECKBOX_BY_CLASS, checkboxClass);
		checkToCheckboxOrRadio(driver, PersonalDetailPageUI.DYNAMIC_CHECKBOX_BY_CLASS, checkboxClass);
	}
	
	public boolean isSalaryAdded(String salaryComponent, String currency, String amount) {
		waitForElementVisible(driver, PersonalDetailPageUI.SALARY_INFO, salaryComponent, currency, amount);
		return isElementDisplayed(driver, PersonalDetailPageUI.SALARY_INFO, salaryComponent, currency, amount);
	}

	public boolean isDepositDetailsAdded(String accountNumber, String accountType, String routingNumber, String amount) {
		waitForElementVisible(driver, PersonalDetailPageUI.DEPOSIT_INFO, accountNumber, accountType, routingNumber, amount);
		return isElementDisplayed(driver, PersonalDetailPageUI.DEPOSIT_INFO, accountNumber, accountType, routingNumber, amount);
	}

//	public boolean isAvatarUploadedSucess() {
//		waitForAllElementsVisible(driver, PersonalDetailPageUI.AVATAR_IMAGE);
//		width = getAttributeValue(driver, PersonalDetailPageUI.AVATAR_IMAGE, "width");
////		if (width ) {
////			return true;
////		} else {
////			return false;
////		}
//	}
	
	
	

}
