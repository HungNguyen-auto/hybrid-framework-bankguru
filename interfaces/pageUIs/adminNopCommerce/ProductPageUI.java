package pageUIs.adminNopCommerce;

public class ProductPageUI {
    public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
    public static final String SEARCH_BUTTON = "//button[@id='search-products']";
    public static final String EXPECTED_ROW_SEARCH = "";
    public static final String EDIT_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[@class=' button-column']/a";
    public static final String SUCCESS_MESSAGE = "//div[contains(@class, 'alert-success')]";
    public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";

}
