package pageObjects.sourcelab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
//	private static LoginPageObject loginPage;
//	private static InventoryPageObject inventoryPage;

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static InventoryPageObject getInventoryPage(WebDriver driver) {
		return new InventoryPageObject(driver);
	}
}
