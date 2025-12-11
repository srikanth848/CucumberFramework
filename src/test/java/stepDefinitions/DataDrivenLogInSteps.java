package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class DataDrivenLogInSteps {
	
	HomePage hp;
	LogInPage lp;
	MyAccountPage myAccPage;
	
	List<Map<String, String>> data;
	String result;
	
	@Given("User landed on the login page")
	public void user_landed_on_the_login_page() {
	    hp = new HomePage(BaseClass.driver);
	    hp.clickMyAccountDropdown();
	    hp.clickLoginOption();
	    BaseClass.getLogger().info("User landed on the login page...");
	}

	@When("User passes email and password from excel file with row {string}")
	public void user_passes_email_and_password_from_excel_file_with_row(String row) throws IOException {
		data = DataReader.getData(System.getProperty("user.dir")+"\\testData\\LogInData.xlsx", "Data");
		int rowIndex = Integer.parseInt(row)-1;
		
		BaseClass.getLogger().info("Reading data from "+row+" index of the excel sheet");
		
		String Email = data.get(rowIndex).get("Email");
		String Password = data.get(rowIndex).get("Password");
		result = data.get(rowIndex).get("DataClass");
		
		lp = new LogInPage(BaseClass.driver);
	    lp.enterEmail(Email);
	    lp.enterPassword(Password);
	    BaseClass.getLogger().info("Entered credentials...");
	}
	
	@When("Clicks on Login")
	public void clicks_on_login_button() {
		BaseClass.getLogger().info("Clicking on Login button......");
		lp.clickLoginButton();
	}

	
	@Then("User should navigate to My Account page")
	public void user_should_navigate_to_my_account_page() {
	    myAccPage = new MyAccountPage(BaseClass.driver);
		boolean res = myAccPage.isMyAccountPageExists();
		if(result.equalsIgnoreCase("valid")) {
			BaseClass.getLogger().info("navigated to my account page...");
		   	Assertions.assertTrue(res);
		}
		else if(result.equalsIgnoreCase("invalid")) {
			BaseClass.getLogger().info("invalid user, can't navigate to my account page....");
		   	Assertions.assertFalse(res);
		}
	}
	
}
