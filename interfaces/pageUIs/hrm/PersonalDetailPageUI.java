package pageUIs.hrm;

public class PersonalDetailPageUI {
	public static final String AVATAR_IMAGE = "//img[@id='empPic']";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	public static final String UPLOAD_BUTTON = "//input[@id='btnSave']";
	public static final String DYNAMIC_GENDER_RADIO = "//label[text()='%s']//preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String BLOOD_TYPE_DROPDOWN = "//label[text()='Blood Type']//following-sibling::select";
	public static final String ATTACHMENT_INFO = "//a[contains(text(), '%s')]";
	public static final String EMERGENCY_CONTACT_INFO = "//table[@id='emgcontact_list']//a[text()='%s']/parent::td//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']";
	public static final String DEPENDENT_INFO = "//table[@id='dependent_list']//a[text()='%s']/parent::td//following-sibling::td[contains(text(),'%s')]//following-sibling::td[text()='%s']";

}
