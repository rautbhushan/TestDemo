package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	String url = "http://tutorialsninja.com/demo/";

	public WebDriver setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean click(By locator) {
		boolean flag = isElementPresent(locator);
		if (flag) {
			driver.findElement(locator).click();
			return true;
		} else {
			return false;
		}

	}

	public void enterText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

}
