package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sourcelab.InventoryPageObject;
import pageObjects.sourcelab.LoginPageObject;
import pageObjects.sourcelab.PageGeneratorManager;

public class Level_17_Sort extends BaseTest {

	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;
	String username = "standard_user", password = "secret_sauce";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToUsernameTextbox(username);

		loginPage.inputToPasswordTextbox(password);

		inventoryPage = loginPage.clickOnLoginButton();

	}

	@Test
	public void Login_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");

		verifyTrue(inventoryPage.isProductNameSortedAscending());

		inventoryPage.selectItemInSortDropdown("Name (Z to A)");

		verifyTrue(inventoryPage.isProductNameSortedDecending());
	}

	@Test
	public void Login_02_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		
		verifyTrue(inventoryPage.isProductPriceSortedAscending());

		inventoryPage.selectItemInSortDropdown("Price (high to low)"); 
		
		verifyTrue(inventoryPage.isProductPriceSortedDecending());
	}

	@Test
	public void Login_03_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");

		verifyTrue(inventoryPage.isProductNameSortedDecending());
	}

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		//driver.quit();
	}
}
