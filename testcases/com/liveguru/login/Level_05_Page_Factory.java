package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePageFactory;
import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_05_Page_Factory extends BasePageFactory {
	WebDriver driver;
	String emailAddress, password;

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//driver = getBrowserDriver(browserName, url);
		emailAddress = generateRandomEmail();
		password = "1234aa";
	}

	@Test
	public void Login_01_Empty_Email_Password() {

		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.loginToSystem("", "");

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");

		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {

		loginPage.refreshCurrentPage(driver);

		loginPage = new LoginPageObject(driver);

		loginPage.loginToSystem("1233@2314123", password);
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {

		loginPage.refreshCurrentPage(driver);

		loginPage = new LoginPageObject(driver);

		loginPage.loginToSystem(emailAddress, "123");

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test(description = "Email not exist in system")
	public void Login_04_Incorrect_Email() {

		loginPage.refreshCurrentPage(driver);

		loginPage = new LoginPageObject(driver);

		loginPage.loginToSystem(emailAddress, password);

		Assert.assertEquals(loginPage.getIncorrectEmailErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_05_Valid_Email_Passwod() {

		loginPage.refreshCurrentPage(driver);

		loginPage = new LoginPageObject(driver);
		
		loginPage.loginToSystem("dam@gmail.com", "123123");
		
		myDashboardPage = new MyDashboardPageObject(driver);

		Assert.assertTrue(myDashboardPage.isMyDashboardDisplayed());

	}

	public String generateRandomEmail() {
		Random rand = new Random();
		return "henry" + rand.nextInt(9999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
