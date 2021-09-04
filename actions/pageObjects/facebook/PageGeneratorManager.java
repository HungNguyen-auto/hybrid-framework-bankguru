package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import pageObjects.facebook.RegisterPageObject;

public class PageGeneratorManager {
    private static RegisterPageObject registerPage;

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        if(registerPage==null){
            registerPage = new RegisterPageObject(driver);
        }
        return registerPage;
    }
}
