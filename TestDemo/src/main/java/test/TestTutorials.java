package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Base;
import page.Tutorial;

public class TestTutorials {
	WebDriver driver;
	Base base;
	Tutorial tutorial;
	String output = "";

	@BeforeMethod
	public void beforeMethod() {
		base = new Base();
		driver = base.setup();
		tutorial = new Tutorial(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@Test
	public void test() {
		String warning="Warning: You must agree to the Privacy Policy!";
		String smsg="Your Account Has Been Created!";
		assertEquals(driver.getTitle(), "Your Store", "Page title did not matched");
		tutorial.selectSubMenuDashboard("Components", "Monitors (2)");
		tutorial.clickRegister();
		tutorial.enterText(By.id(tutorial.firstname), "Bhushan");
		tutorial.enterText(By.id(tutorial.lastname), "Raut");
		tutorial.enterText(By.id(tutorial.email), "Bhushan@gmail.com");
		tutorial.enterText(By.id(tutorial.telephone), "123456789");
		tutorial.enterText(By.id(tutorial.password), "Test");
		tutorial.enterText(By.id(tutorial.confirm), "Test");
		tutorial.clickContinue();
		assertEquals(tutorial.getWarningMsg(),warning, "waning message is not matching");
		tutorial.clickAgreeCheckbox();
		tutorial.clickContinue();

	}
}
