package pageUIs.nopCommerce;

public class BasePageUI{
    public static final String ORDERS_LINK = "//a[text()='Orders']";
    public static final String SEARCH_LINK = "//a[text()='Search']";
    public static final String MYACCOUNT_LINK = "//a[text()='My account']";
    
    public static final String DYNAMIC_HEADER_PAGE = "//div[@class='header']//a[text()='%s']";
    public static final String DYNAMIC_FOOTER_PAGE = "//div[@class='footer']//a[text()='%s']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";
	
	// hrm
	public static final String DYNAMIC_MENU_PAGE = "//div[@id='mainMenu']//a[string()='%s']";
	public static final String WELCOME_USERNAME = "//a[@id='welcome']";
	public static final String DYNAMIC_WELCOME_MENU = "//div[@id='welcome-menu']//a[text()='%s']";
	public static final String DYNAMIC_LEFT_MENU_PAGE = "//ul[@id='sidenav']/li/a[text()='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@id='%s']";
}
