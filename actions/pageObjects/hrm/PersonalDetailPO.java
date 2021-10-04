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

	public void UploadNewImage(String filePath) {
		uploadFile(driver, PersonalDetailPageUI.UPLOAD_FILE, filePath);

		waitForElementClickable(driver, PersonalDetailPageUI.UPLOAD_BUTTON);
		clickToElement(driver, PersonalDetailPageUI.UPLOAD_BUTTON);
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

	public void uploadAttachments(String attachmentPath) {
		uploadFile(driver, PersonalDetailPageUI.UPLOAD_FILE, attachmentPath);
	}

	public boolean isAttachmentUploaded(String attachmentName) {
		waitForElementVisible(driver,PersonalDetailPageUI.ATTACHMENT_INFO ,attachmentName);
		return isElementDisplayed(driver,PersonalDetailPageUI.ATTACHMENT_INFO ,attachmentName);
	}

	public boolean isEmergencyContactAdded(String firstname, String relationship, String homePhone) {
		waitForElementVisible(driver, PersonalDetailPageUI.EMERGENCY_CONTACT_INFO, firstname, relationship, homePhone);
		return isElementDisplayed(driver, PersonalDetailPageUI.EMERGENCY_CONTACT_INFO, firstname, relationship, homePhone);
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
