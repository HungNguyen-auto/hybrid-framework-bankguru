package com.hrm.employee;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.data.EmployeeData;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.PersonalDetailPO;
import utilities.DataUtil;

public class TC_01_Login_Data_Driven extends BaseTest {
	WebDriver driver;
	DataUtil fakeData;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	AddEmployeePO addEmployeePage;
	PersonalDetailPO personalDetailPage;
	EmployeeData employeeData;
	String relationship, homePhone, attachmentName, attachmentPath, bloodType, maritialStatus, emailAddress, password,
			statusValue, employeeID, username, firstname, lastname, filePath, gender, country;
	Random rand = new Random();

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		fakeData = DataUtil.getData();
		employeeData = EmployeeData.getEmployee();
		emailAddress = fakeData.getEmailAddress();
//		password = fakeData.getPassword();
		password = employeeData.getPassword();
		statusValue = "Enabled";
//		firstname = fakeData.getFirstName();
//		lastname = fakeData.getLastName();
		firstname = employeeData.getFirstname();
		lastname = employeeData.getLastname();
		gender = "Male";
		homePhone = "0357626252";
		relationship = "Who am I";
		country = "Vietnamese";
		maritialStatus = "Single";
		bloodType = "AB+";
		attachmentName = "F Employment Application.docx";
		filePath = GlobalConstants.UPLOAD_FOLDER_PATH + "dog.jpg";
		attachmentPath = GlobalConstants.UPLOAD_FOLDER_PATH + attachmentName;
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystem("Admin", "admin123");

	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List'");
		dashboardPage.openSubMenuByNamee(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 02: Click on 'Add' button");
		addEmployeePage = employeeListPage.clickOnAddButton();

		log.info("Add_New_01 - Step 03: Input valid info to 'First Name' textbox");
		addEmployeePage.inputToTextboxByID("firstName", firstname);

		log.info("Add_New_01 - Step 04: Input valid info to 'Last Name' textbox");
		addEmployeePage.inputToTextboxByID("lastName", lastname);

		log.info("Add_New_01 - Step 05: Get value of 'EmployeeID'");
		employeeID = addEmployeePage.getEmployeeID();

		log.info("Add_New_01 - Step 06: Click on 'Create Login Details' checkbox");
		addEmployeePage.clickOnCreateLoginDetailsCheckbox();

		log.info("Add_New_01 - Step 07: Input valid info to 'User name' textbox");
		addEmployeePage.inputToTextboxByID("user_name", emailAddress);

		log.info("Add_New_01 - Step 08: Input valid info to 'Password' textbox");
		addEmployeePage.inputToTextboxByID("user_password", password);

		log.info("Add_New_01 - Step 09: Input valid info to 'Confirm Password' textbox");
		addEmployeePage.inputToTextboxByID("re_password", password);

		log.info("Add_New_01 - Step 10: Select " + statusValue + " value in 'Status' dropdown");
		addEmployeePage.selectValueInStatusDropdown(statusValue);

		log.info("Add_New_01 - Step 11: Click on 'Save' button");
		personalDetailPage = addEmployeePage.clickOnSaveButton();

		log.info("Add_New_01 - Step 12: Open 'Employee List'");
		personalDetailPage.openSubMenuByNamee(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 13: Input to 'Employee Name'");
		employeeListPage.inputToEmployeeNameTextbox(firstname + " " + lastname);

		log.info("Add_New_01 - Step 14: Click on 'Search' button");
		employeeListPage.clickOnSearchButton();

		log.info("Add_New_01 - Step 15: Verify employee information in datagrid");
		verifyTrue(employeeListPage.isEmployeeInfoDisplayed(employeeID, firstname, lastname));

		log.info("Add_New_01 - Step 16:  Logout from Admin role");
		employeeListPage.logoutSystem(driver, "Logout");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void Employee_02_Upload_Avatar() {

		log.info("Upload_Avatar_02 - Step 01: Login with Employee role");
		dashboardPage = loginPage.loginToSystem(emailAddress, password);

		log.info("Upload_Avatar_02 - Step 02: Open My Info Page");
		dashboardPage.openMenuByName(driver, "My Info");
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);

		log.info("Upload_Avatar_02 - Step 03: Click on Avatar");
		personalDetailPage.ClickOnAvatar();

		log.info("Upload_Avatar_02 - Step 03: Upload a new image");
		personalDetailPage.UploadNewImage(filePath, "photofile");

//		log.info("Upload_Avatar_02 - Step 04: Verify new image uploaded successfully");
//		verifyTrue(personalDetailPage.isAvatarUploadedSucess());
	}

	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details_03 - Step 01: Open Personal Details Page");
		personalDetailPage.openLeftMenuByName(driver, "Personal Details");

		log.info("Personal_Details_03 - Step 02: Click on Edit Personal Details");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Personal_Details_03 - Step 03: Select Gender Male");
		personalDetailPage.selectGenderRadioByText(gender);

		log.info("Personal_Details_03 - Step 04: Select Nationality");
		personalDetailPage.selectDropdownByText("personal_cmbNation", country);

		log.info("Personal_Details_03 - Step 05: Select Marital Status");
		personalDetailPage.selectDropdownByText("personal_cmbMarital", maritialStatus);

		log.info("Personal_Details_03 - Step 06: Click on Save button");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Personal_Details_03 - Step 07: Click on Edit Customer Fields");
		personalDetailPage.clickOnButtonByID(driver, "btnEditCustom");

		log.info("Personal_Details_03 - Step 08: Select blood type");
		personalDetailPage.selectBloodTypeByText(bloodType);

		log.info("Personal_Details_03 - Step 09: Click on Save Customer Fields");
		personalDetailPage.clickOnButtonByID(driver, "btnEditCustom");

		log.info("Personal_Details_03 - Step 10: Click on Add Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnAddAttachment");

		log.info("Personal_Details_03 - Step 11: Upload attachment");
		personalDetailPage.uploadAttachments(attachmentPath, "ufile");

		log.info("Personal_Details_03 - Step 12: Click on Upload button Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveAttachment");

		log.info("Personal_Details_03 - Step 13: Verify is attachment uploaded successfully");
		verifyTrue(personalDetailPage.isAttachmentUploaded("tblAttachments", attachmentName));
	}

	@Test
	public void Employee_04_Contact_Details() {
		log.info("Contact_Details_04 - Step 01: Open Contact Details Page");
		personalDetailPage.openLeftMenuByName(driver, "Contact Details");

		log.info("Contact_Details_04 - Step 02: Click on Edit Contact Details");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Contact_Details_04 - Step 03: Input to City textbox");
		personalDetailPage.inputToTextboxByID(driver, "contact_city", country);

		log.info("Contact_Details_04 - Step 04: Input to Work Email");
		personalDetailPage.inputToTextboxByID(driver, "contact_emp_work_email", emailAddress);

		log.info("Contact_Details_04 - Step 05: Select Country dropdownlist");
		personalDetailPage.selectDropdownByText("contact_country", "Viet Nam");

		log.info("Contact_Details_04 - Step 06: Click on Save Contact Details");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Contact_Details_04 - Step 07: Click on Add Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnAddAttachment");

		log.info("Contact_Details_04 - Step 08: Upload attachment");
		personalDetailPage.uploadAttachments(attachmentPath, "ufile");

		log.info("Contact_Details_04 - Step 09: Click on Upload button Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveAttachment");

		log.info("Contact_Details_04 - Step 10: Verify is attachment uploaded successfully");
		verifyTrue(personalDetailPage.isAttachmentUploaded("tblAttachments", attachmentName));
	}

	@Test
	public void Employee_05_Emergency_Details() {
		log.info("Emergency_Details_05 - Step 01: Open Emergency Details Page");
		personalDetailPage.openLeftMenuByName(driver, "Emergency Contacts");

		log.info("Emergency_Details_05 - Step 02: Click on Add Assigned Emergency Contacts");
		personalDetailPage.clickOnButtonByID(driver, "btnAddContact");

		log.info("Emergency_Details_05 - Step 03: Input to Name textbox");
		personalDetailPage.inputToTextboxByID(driver, "emgcontacts_name", firstname);

		log.info("Emergency_Details_05 - Step 04: Input to Relationship textbox");
		personalDetailPage.inputToTextboxByID(driver, "emgcontacts_relationship", relationship);

		log.info("Emergency_Details_05 - Step 05: Input to Relationship textbox");
		personalDetailPage.inputToTextboxByID(driver, "emgcontacts_homePhone", homePhone);

		log.info("Emergency_Details_05 - Step 06: Click on Save Assigned Emergency Contacts");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveEContact");

		log.info("Emergency_Details_05 - Step 07: Verify that Emergency Contacts added successully");
		verifyTrue(personalDetailPage.isEmergencyContactAdded(firstname, relationship, homePhone));

		log.info("Emergency_Details_05 - Step 08: Click on Add Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnAddAttachment");

		log.info("Emergency_Details_05 - Step 09: Upload attachment");
		personalDetailPage.uploadAttachments(attachmentPath, "ufile");

		log.info("Emergency_Details_05 - Step 10: Click on Upload button Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveAttachment");

		log.info("Emergency_Details_05 - Step 11: Verify is attachment uploaded successfully");
		verifyTrue(personalDetailPage.isAttachmentUploaded("tblAttachments", attachmentName));
	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		log.info("Emergency_Details_06 - Step 01: Open Dependents Page");
		personalDetailPage.openLeftMenuByName(driver, "Dependents");

		log.info("Emergency_Details_06 - Step 02: Click on Add button");
		personalDetailPage.clickOnButtonByID(driver, "btnAddDependent");

		log.info("Emergency_Details_06 - Step 03: Input to Name textbox");
		personalDetailPage.inputToTextboxByID(driver, "dependent_name", "Henry");

		log.info("Emergency_Details_06 - Step 04: Select relationship dropdownlist");
		personalDetailPage.selectDropdownByText("dependent_relationshipType", "Other");

		log.info("Emergency_Details_06 - Step 05: Input specific relationship");
		personalDetailPage.inputToTextboxByID(driver, "dependent_relationship", "Wife");

		log.info("Emergency_Details_06 - Step 06: Input date of birth");
		personalDetailPage.inputToTextboxByID(driver, "dependent_dateOfBirth", "1998-10-07");

		log.info("Emergency_Details_06 - Step 07: Click on Save button");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveDependent");

		log.info("Emergency_Details_06 - Step 08: Verify dependent added successfully");
		verifyTrue(personalDetailPage.isDependentAdded("Henry", "Wife", "1998-10-07"));

		log.info("Emergency_Details_06 - Step 09: Logout from Employee role");
		personalDetailPage.logoutSystem(driver, "Logout");
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void Employee_07_Admin_Edit_Job() {

		log.info("Admin_Edit_Job_07 - Step 01: Login as Admin role");
		dashboardPage = loginPage.loginToSystem("Admin", "admin123");

		log.info("Admin_Edit_Job_07 - Step 02: Open 'Employee List'");
		dashboardPage.openSubMenuByNamee(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Admin_Edit_Job_07 - Step 03: Input to Employee Name textbox");
		employeeListPage.inputToEmployeeNameTextbox(firstname + " " + lastname);

		log.info("Admin_Edit_Job_07 - Step 04: Click on 'Search' button");
		employeeListPage.clickOnSearchButton();

		log.info("Admin_Edit_Job_07 - Step 05: Click on Lastname to open Personal Details");
		personalDetailPage = employeeListPage.openPersonalDetails(employeeID, firstname, lastname);

		log.info("Admin_Edit_Job_07 - Step 06: Open 'Job' page");
		personalDetailPage.openLeftMenuByName(driver, "Job");

		log.info("Admin_Edit_Job_07 - Step 07: Click on Edit button");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Admin_Edit_Job_07 - Step 08: Select Job Title dropdownlist");
		personalDetailPage.selectDropdownByText("job_job_title", "QA Engineer");

		log.info("Admin_Edit_Job_07 - Step 09: Select Employee status dropdownlist");
		personalDetailPage.selectDropdownByText("job_emp_status", "Full-Time Contract");

		log.info("Admin_Edit_Job_07 - Step 10: Input to Joined Date");
		personalDetailPage.inputToTextboxByID(driver, "job_joined_date", "2020-05-04");

		log.info("Admin_Edit_Job_07 - Step 11: Attach Employee contract");
		personalDetailPage.uploadAttachments(attachmentPath, "job_contract_file");

		log.info("Admin_Edit_Job_07 - Step 12: Click on Save button");
		personalDetailPage.clickOnButtonByID(driver, "btnSave");

		log.info("Admin_Edit_Job_07 - Step 13: Verify that Contract is attached successlly");
		verifyTrue(personalDetailPage.isContractDetailsAttached(attachmentName));

		log.info("Admin_Edit_Job_07 - Step 14: Click on Add button Attachments");
		personalDetailPage.clickOnButtonByID(driver, "btnAddAttachment");

		log.info("Admin_Edit_Job_07 - Step 15: Add attachment");
		personalDetailPage.uploadAttachments(attachmentPath, "ufile");

		log.info("Admin_Edit_Job_07 - Step 16: Click on Upload button");
		personalDetailPage.clickOnButtonByID(driver, "btnSaveAttachment");

		log.info("Admin_Edit_Job_07 - Step 17: Verify that Attachment is attached successlly");
		verifyTrue(personalDetailPage.isAttachmentUploaded("tblAttachments", attachmentName));

	}

	@Test
	public void Employee_08_Admin_Edit_Salary() {

		log.info("Admin_Edit_Salary_08 - Step 01: Open 'Salary' page");
		personalDetailPage.openLeftMenuByName(driver, "Salary");

		log.info("Admin_Edit_Salary_08 - Step 02: Click on Add button Salary");
		personalDetailPage.clickOnButtonByID(driver, "addSalary");

//		log.info("Admin_Edit_Salary_08 - Step 03: Select Pay Grade dropdownlist");
//		personalDetailPage.selectDropdownByText("salary_sal_grd_code", "Grade 3");

		log.info("Admin_Edit_Salary_08 - Step 04: Input to Salary Component textbox");
		personalDetailPage.inputToTextboxByID(driver, "salary_salary_component", "Senior Budget");

		log.info("Admin_Edit_Salary_08 - Step 05: Select Currency dropdownlist");
		personalDetailPage.selectDropdownByText("salary_currency_id", "Yemeni Riyal");

		log.info("Admin_Edit_Salary_08 - Step 06: Input to Amount textbox");
		personalDetailPage.inputToTextboxByID(driver, "salary_basic_salary", "30000");

		log.info("Admin_Edit_Salary_08 - Step 07: Check on Add Direct Deposit Details checkbox");
		personalDetailPage.checkOnCheckboxByID("salary_set_direct_debit");

		log.info("Admin_Edit_Salary_08 - Step 08: Input to Account number textbox");
		personalDetailPage.inputToTextboxByID(driver, "directdeposit_account", "261475653");

		log.info("Admin_Edit_Salary_08 - Step 09: Select Account Type dropdownlist");
		personalDetailPage.selectDropdownByText("directdeposit_account_type", "Checking");

		log.info("Admin_Edit_Salary_08 - Step 10: Input to Routing Number textbox");
		personalDetailPage.inputToTextboxByID(driver, "directdeposit_routing_num", "123456");

		log.info("Admin_Edit_Salary_08 - Step 11: Input to Amount textbox");
		personalDetailPage.inputToTextboxByID(driver, "directdeposit_amount", "100000");

		log.info("Admin_Edit_Salary_08 - Step 12: Click on Save button Salary");
		personalDetailPage.clickOnButtonByID(driver, "btnSalarySave");

		log.info("Admin_Edit_Salary_08 - Step 13: Verify that Salary is added successfully");
		verifyTrue(personalDetailPage.isSalaryAdded("Senior Budget", "Yemeni Riyal", "30000"));

		log.info("Admin_Edit_Salary_08 - Step 14: Check on Show Direct Deposit Details checkbox");
		personalDetailPage.checkOnCheckboxByClass("chkbox displayDirectDeposit");

		log.info("Admin_Edit_Salary_08 - Step 15: Verify that Deposit Details is added successfully");
		verifyTrue(personalDetailPage.isDepositDetailsAdded("261475653", "Checking", "123456", "100000.00"));

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
//        cleanBrowserAndDriverIntances();
	}
}
