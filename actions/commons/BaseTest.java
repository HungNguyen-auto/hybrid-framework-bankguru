package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//private String projectLocation = System.getProperty("user.dir");
	private WebDriver driver;
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, ED_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser == BROWSER.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser == BROWSER.EDGE_CHROMIUM){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter browser name!");
		}
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser == BROWSER.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser == BROWSER.EDGE_CHROMIUM){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/");
		return driver;
	}
}
