package pageObjects.hrm;

import org.openqa.selenium.WebDriver;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PersonalDetailPO;

public class PageGeneratorManager {
	private static LoginPO loginPage;
	private static DashboardPO doashboardPage;
	private static EmployeeListPO employeeListPage;
	private static AddEmployeePO addEmployeePage;
	private static PersonalDetailPO personalDetaiPage;

	private PageGeneratorManager() {

	}

	public static LoginPO getLoginPage(WebDriver driver) {
//        if(loginPage==null){
//            loginPage = new LoginPageObject(driver);
//        }
		return new LoginPO(driver);
	}

	public static DashboardPO getDashboardPage(WebDriver driver) {
		return new DashboardPO(driver);
	}
	
	public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPO(driver);
	}
	
	public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
		return new AddEmployeePO(driver);
	}
	
	public static PersonalDetailPO getPersonalDetailPage(WebDriver driver) {
		return new PersonalDetailPO(driver);
	}

}
