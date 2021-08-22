package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emailAddress = generateRandomEmail();
		password = "1234aa";
	}

	@Test
	public void Login_01_Empty_Email_Password() {

		driver.get("http://live.demoguru99.com/index.php/");

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
	public void cleanBrowser() {
		driver.quit();
	}
}
