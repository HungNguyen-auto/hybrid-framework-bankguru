package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
    public static final String DYNAMIC_PAGE_NUMBER_ACTIVE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";

    public static final String SEARCH_TEXTBOX = "//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
    public static final String ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
    public static final String EXPECTED_ROW_SEARCH = "//td[@data-key='females' and text()='%s'] //following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s']//following-sibling::td[@data-key='total' and text()='%s']";
    public static final String HEADER_NAME_INDEX = "//th[text()='%s']/preceding-sibling::th";
    public static final String TEXTBOX_BY_COLUMN_ROW_INDEX = "//tr[%s]/td[%s]/input";
    public static final String ACTION_ICON_BY_TITLE_ROW_INDEX = "//tr[@id][%s]//p/button[@title='%s']";
}
