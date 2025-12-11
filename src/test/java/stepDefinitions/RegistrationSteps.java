package stepDefinitions;

import java.util.Map;

import org.junit.jupiter.api.Assertions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationSteps {
	
	HomePage hp;
	RegistrationPage regPage;
	
	@Given("User navigates to the account registration page")
	public void user_navigates_to_the_account_registration_page() {
	    hp = new HomePage(BaseClass.driver);
	    BaseClass.getLogger().info("Navigating to Account Registration page...");
	    hp.clickMyAccountDropdown();
	    hp.clickRegisterOption();
	}

	@When("User enters the below registration details")
	public void user_enters_the_below_registration_details(DataTable dataTable) {
		regPage = new RegistrationPage(BaseClass.driver);
		Map<String, String> regData = dataTable.asMap(String.class, String.class);
		BaseClass.getLogger().info("Entering the registration details...");
		regPage.enterFirstName(regData.get("FirstName"));
		regPage.enterLastName(regData.get("LastName"));
		regPage.enterEmail(BaseClass.getRandomAlphaNumeric(10)+"@gmail.com");
	    regPage.enterTelephone(regData.get("Telephone"));
	    regPage.enterPassword(regData.get("Password"));
	    regPage.enterConfirmPassword(regData.get("ConfirmPassword")); 
	}

	@When("User agrees to the Privacy Policy")
	public void user_agrees_to_the_privacy_policy() {
		BaseClass.getLogger().info("Agreeing to the Privacy Policy...");
		regPage.checkPrivacyPolicy();
	}

	@When("Clicks on Continue button")
	public void clicks_on_continue_button() {
		BaseClass.getLogger().info("Clicking on Continue button...");
		regPage.clickContinueButton();
	}

	@Then("User should see a confirmation message {string}")
	public void user_should_see_a_confirmation_message(String msg) {
	    BaseClass.getLogger().info("Verifying the registration success message...");
	    Assertions.assertEquals(msg, regPage.getSuccessMessage());
	}

}
