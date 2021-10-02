package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.PersonalDetailPO;

public class TC_01_Login extends BaseTest {
    WebDriver driver;
    LoginPO loginPage;
    DashboardPO dashboardPage;
    EmployeeListPO employeeListPage;
    AddEmployeePO addEmployeePage;
    PersonalDetailPO personalDetailPage;
    String emailAddress, password, statusValue, employeeID, username, firstname, lastname;
    

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
        driver = getBrowserDriver(browserName, appUrl);
        emailAddress = generateRandomEmail();
        password = "1234aaAA";
        statusValue = "Enabled";
        firstname = "henry";
        lastname = "nguyen";
        loginPage = PageGeneratorManager.getLoginPage(driver);
        
        log.info("Pre-Condition - Step 02: Login with Admin role");
        dashboardPage = loginPage.loginToSystem("Admin","admin123");
        
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
      //personalDetailPage.sleepInSecond(2);
      
      log.info("Add_New_01 - Step 12: Open 'Employee List'");
      personalDetailPage.openSubMenuByNamee(driver, "PIM", "Employee List");
      employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
      
      log.info("Add_New_01 - Step 13: Input to 'Employee Name'");
      employeeListPage.inputToEmployeeNameTextbox(firstname + " " + lastname);
      
      log.info("Add_New_01 - Step 14: Click on 'Search' button");
      employeeListPage.clickOnSearchButton();
      
      log.info("Add_New_01 - Step 15: Verify employee information in datagrid");
      verifyTrue(employeeListPage.isEmployeeInfoDisplayed(employeeID,firstname, lastname));
      
    }

    @Test
    public void Employee_02_Upload_Avatar() {
    	
    }

    @Test
    public void Employee_03_Personal_Details() {
    	
    }
    
    @Test
    public void Employee_04_Contact_Details() {
    	
    }
    
    @Test
    public void Employee_05_Emergency_Details() {
    	
    }
    
    @Test
    public void Employee_06_Assigned_Dependents() {
    	
    }
    
    @Test
    public void Employee_07_Edit_View_Job() {
    	
    }
    
    @Test
    public void Employee_08_Edit_View_Salary() {
    	
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
