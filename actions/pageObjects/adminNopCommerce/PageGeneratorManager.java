package pageObjects.adminNopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    private static LoginPageObject loginPage;
    private static HomePageObject homePage;
    private static ProductPageObject productPage;
    private static ProductDetailPageObject productDetailPage;

    private PageGeneratorManager(){

    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        if(loginPage==null){
            loginPage = new LoginPageObject(driver);
        }
        return loginPage;
    }

    public static HomePageObject getHomePage(WebDriver driver){
        if(homePage==null){
            homePage = new HomePageObject(driver);
        }
        return homePage;
    }

    public static ProductPageObject getProductPage(WebDriver driver){
        if(productPage==null){
            productPage = new ProductPageObject(driver);
        }
        return productPage;
    }

    public static ProductDetailPageObject getProductDetailPage(WebDriver driver){
        if(productDetailPage==null){
            productDetailPage = new ProductDetailPageObject(driver);
        }
        return productDetailPage;
    }
}
