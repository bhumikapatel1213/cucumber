package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement UserNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PasswordElement;
	@FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
	WebElement SignInButton;
	
	//Methods to interact with the Elements
	public void enterUserName(String Username) {
		UserNameElement.sendKeys(Username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String Password) {
		PasswordElement .sendKeys(Password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSignInButton() {
		SignInButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
