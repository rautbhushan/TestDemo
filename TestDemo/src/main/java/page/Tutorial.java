package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Tutorial extends Base {
	WebDriver driver;
	String components = "//*[text()='Components']";
	String submenu = "//*[@class='dropdown-inner']//*[text()='%s']";
	String myAccount = "//*[@title='My Account']";
	String register = "//*[contains(@class,'dropdown-menu')]//*[text()='Register']";
	public String firstname = "input-firstname";
	public String lastname = "input-lastname";
	public String email = "input-email";
	public String telephone = "input-telephone";
	public String password = "input-password";
	public String confirm = "input-confirm";
	String continueBtn = "//input[@value='Continue']";
	String warning = "//*[@id='account-register']//*[contains(@class,'alert')]";
	String agree = "//input[@name='agree']";
	//String success="//*[@id='content']//h1";

	public Tutorial(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSubMenuDashboard(String menu, String submenuName) {
		Actions a = new Actions(driver);
		click(By.xpath((components)));
		click(By.xpath(String.format(submenu, submenuName)));
	}

	public void clickRegister() {
		click(By.xpath(myAccount));
		click(By.xpath(register));
	}

	public void clickContinue() {
		click(By.xpath(continueBtn));
	}

	public String getWarningMsg() {
		return driver.findElement(By.xpath(warning)).getText();
	}
	
//	public String getSuccessMsg() {
//		return driver.findElement(By.xpath(success)).getText();
//	}

	public void clickAgreeCheckbox() {
		click(By.xpath(agree));
	}
}
