package stepDefinitions;

import org.junit.jupiter.api.Assertions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;

public class LogInSteps {
	
	HomePage hp;
	LogInPage lp;
	MyAccountPage myAccPage;
	
	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {
		hp = new HomePage(BaseClass.driver);
		BaseClass.getLogger().info("Clicking on My Account dropdown..");
		hp.clickMyAccountDropdown();
		BaseClass.getLogger().info("Clicking on Login option..");
		hp.clickLoginOption();
	    
	}

	@When("User enters valid username and password as {string} and {string}")
	public void user_enters_valid_username_and_password_as_and(String email, String password) {
	    lp = new LogInPage(BaseClass.driver);
	    BaseClass.getLogger().info("Entering email......");
	    lp.enterEmail(email);
	    BaseClass.getLogger().info("Entering password......");
	    lp.enterPassword(password);
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		BaseClass.getLogger().info("Clicking on Login button......");
		lp.clickLoginButton();
	}

	@Then("User should be redirected to the My Account page")
	public void user_should_be_redirected_to_the_my_account_page() {
		myAccPage = new MyAccountPage(BaseClass.driver);
	    BaseClass.getLogger().info("Verifying My Account page is displayed......");
	    Assertions.assertTrue(myAccPage.isMyAccountPageExists());
	}

}
