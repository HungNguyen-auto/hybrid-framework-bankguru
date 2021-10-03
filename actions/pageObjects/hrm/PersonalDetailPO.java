package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.PersonalDetailPageUI;

public class PersonalDetailPO extends BasePage {
	WebDriver driver;
	String  width;

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
