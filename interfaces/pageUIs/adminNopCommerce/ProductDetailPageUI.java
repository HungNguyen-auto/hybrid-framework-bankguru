package pageUIs.adminNopCommerce;

public class ProductDetailPageUI {
    public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and contains(string(), '%s')]//following-sibling::div//i";
    public static final String PRODUCT_PICTURE_BLOCK_BY_FILE_NAME = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
    public static final String TITLE_TEXTBOX_ADD_NEW = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
    public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
    public static final String ACTION_BUTTON_BY_NAME = "//button[@name='%s']";
    public static final String PICTURE_TABLE_BY_IMAGE_INFO = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
    public static final String DELETE_BUTTON_BY_IMAGE_TITLE = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Delete')]";
}
