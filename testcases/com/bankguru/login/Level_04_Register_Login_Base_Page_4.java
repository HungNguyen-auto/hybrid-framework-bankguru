package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_04_Register_Login_Base_Page_4 extends BasePage{
	WebDriver driver;
	String username, password, loginPageURL;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BasePage.getBasePage();
	}
	
	@Test
	public void Login_01_Register_To_System() {
		loginPageURL = getCurrentURL(driver);
		clickToElement(driver, "//a[text()='here']");
		sendkeyToElement(driver, "//input[@name='emailid']", generateRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getTextElement(driver, "//td[text()='User ID :']//following-sibling::td");
		password = getTextElement(driver, "//td[text()='Password :']//following-sibling::td");
	}

	@Test
	public void Login_02_Login_To_System() {
		openUrl(driver, loginPageURL);
		sendkeyToElement(driver, "//input[@name='uid']", username);
		sendkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertEquals(getTextElement(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
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
