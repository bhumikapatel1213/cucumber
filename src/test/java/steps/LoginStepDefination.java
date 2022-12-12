package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	LoginPage loginpage;
	DatabasePage databasePage;

	@Before
	public void setUp() {
		initDriver();
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DatabasePage();
		//databasePage = PageFactory.initElements(driver, DatabasePage.class);
	}

	@Given("^User on techfios login page$")
	public void user_on_techfios_login_page() {
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) {
		loginpage.enterUserName(username);
	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
		loginpage.enterPassword(password);
	}

	@And("^User clicks on signin button$")
	public void user_clicks_on_signin_button() {
		loginpage.clickSignInButton();
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginpage.getPageTitle();
		Assert.assertEquals("Page not found", expectedTitle, actualTitle);
		// takeScreenshot(driver);
	}
    
	@When("^User enters \"([^\"]*)\" from techfios database$")
	public void user_enters_from_database(String loginData) {
		switch(loginData){
		case "username":
			loginpage.enterUserName(databasePage.getDataFromDb("username"));
			System.out.println("Username from database :" + databasePage.getDataFromDb("username"));
			break;
		case "password":
			loginpage.enterPassword(databasePage.getDataFromDb("password"));
			System.out.println("Password from database :" + databasePage.getDataFromDb("password"));
			break;
		default:
			System.out.println("Unable to enter login data" + loginData);
		}
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
