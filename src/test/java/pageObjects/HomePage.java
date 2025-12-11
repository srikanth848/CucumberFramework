package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//*[@title='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	
	public void clickMyAccountDropdown() {
		myAccountDropdown.click();
	}
	
	public void clickLoginOption() {
		loginOption.click();
	}
	
	public void clickRegisterOption() {
		registerOption.click();
	}

}
