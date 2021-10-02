package pageUIs.hrm;

public class EmployeeListPageUI {
	public static final String ADD_BUTTON = "//input[@id='btnAdd']";
	public static final String EMPLOYEE_NAME_TEXTBOX = "//input[@id='empsearch_employee_name_empName']";
	public static final String EMPLOYEE_NAME_LOADING_TEXTBOX = "//input[@id='empsearch_employee_name_empName' and @class='ac_loading']";
	public static final String EMPLOYEE_INFO_SEARCH = "//table[@id='resultTable']//a[text()='%s']/parent::td//following-sibling::td/a[text()='%s']/parent::td//following-sibling::td/a[text()='%s']";
	public static final String SEARCH_BUTTON = "//input[@id='searchBtn']";
}
