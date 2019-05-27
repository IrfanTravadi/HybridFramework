package Utilities;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;
public class SeleUtilis {
	public static WebDriver driver;

	public static final Logger log = Logger.getLogger(SeleUtilis.class.getName());

	@Parameters({ "browserName" })
	@BeforeSuite(alwaysRun = true)
	public void openBrowser(String browserName) {
		log.info("Open Browser.");
		if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("chrome")) {

			  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			  HashMap prefs = new HashMap();
			  prefs.put("profile.default_content_setting_values.notifications", 2);
			  ChromeOptions options = new ChromeOptions();
			  options.setExperimentalOption("prefs", prefs);
			  driver = new ChromeDriver(options);
			   	
			
			
			
			
			
		} else if (browserName.endsWith("Edge")) {

			System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		implicitlyWait();
	}

	@AfterSuite()
	public void closeBrowser() {
		driver.quit();
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public void click(By locator) {
		try {
			log.info("Click on " + locator);
			waitForElement(locator);
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.error(locator + " Locator not found.");
		}

	}
	
	public boolean isDisplay (By locator) {
		boolean element = driver.findElement(locator).isDisplayed();
		return element;
	}

	public void enterText(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public void inputText(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public void selctByIndex(By locator, int value) {
		Select ddl = new Select(driver.findElement(locator));
		ddl.selectByIndex(value);
	}

	public void selctByText(By locator, String value) {
		Select ddl = new Select(driver.findElement(locator));
		ddl.selectByVisibleText(value);
	}

	public void selctByValue(By locator, String value) {
		Select ddl = new Select(driver.findElement(locator));
		ddl.deselectByValue(value);
	}

	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public String getText(By locator) {
		String str = driver.findElement(locator).getText().trim();
		return str;
	}
	
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public void mouseHover(By locatormouseHover) {
		WebElement mouseHover = driver.findElement(locatormouseHover);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).build().perform();
	}
	
	public void scrollToElementBy(By locator) {
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	
}
