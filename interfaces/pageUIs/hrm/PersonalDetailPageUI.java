package pageUIs.hrm;

public class PersonalDetailPageUI {
	public static final String AVATAR_IMAGE = "//img[@id='empPic']";
	public static final String UPLOAD_FILE = "//input[@type='file' and @id='%s']";
	public static final String UPLOAD_BUTTON = "//input[@id='btnSave']";
	public static final String DYNAMIC_GENDER_RADIO = "//label[text()='%s']//preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String BLOOD_TYPE_DROPDOWN = "//label[text()='Blood Type']//following-sibling::select";
	public static final String ATTACHMENT_INFO = "//table[@id='%s']//a[contains(text(), '%s')] ";
	public static final String EMERGENCY_CONTACT_INFO = "//table[@id='emgcontact_list']//a[text()='%s']/parent::td//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']";
	public static final String DEPENDENT_INFO = "//table[@id='dependent_list']//a[text()='%s']/parent::td//following-sibling::td[contains(text(),'%s')]//following-sibling::td[text()='%s']";
	public static final String CONTRACT_DETAILS = "//li[@class='contractReadMode']/a[text()='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_CLASS = "//input[@class='%s']";
	public static final String SALARY_INFO = "//table[@id='tblSalary']//a[text()='%s']//parent::td//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']";
	public static final String DEPOSIT_INFO = "//tr[@class='directDepositRow odd']//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']";
}
