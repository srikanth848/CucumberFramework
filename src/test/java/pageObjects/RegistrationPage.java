package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameInput;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameInput;
	
	@FindBy(id="input-email")
	private WebElement emailInput;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneInput;
	
	@FindBy(id="input-password")
	private WebElement passwordInput;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordInput;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//p[contains(text(), 'Congratulations!')]")
	private WebElement successMessage;
	
	
	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		telephoneInput.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);
	}
	
	public void checkPrivacyPolicy() {
		privacyPolicyCheckbox.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public String getSuccessMessage() {
		try {
			return successMessage.getText();
		}
		catch(Exception e) {
			return null;
		}
	}
	

}
