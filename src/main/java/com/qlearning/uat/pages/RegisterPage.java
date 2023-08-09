package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	@FindBy(id="firstName")
	private WebElement firstNameField;
	
	@FindBy(id="middleName")
	private WebElement middleNameField;
	
	@FindBy(id="lastName")
	private WebElement lastNameField;
	
	@FindBy(id="signup_email")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number']")
	private WebElement mobileNumberField;
	
	@FindBy(id="signup_pasword")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createAccountOption;
	
	@FindBy(xpath="//button[text()='Sign Up With Google']")
	private WebElement signUpWithGoogleOption;
	
	@FindBy(linkText="Log In")
	private WebElement registerPageLoginOption;
	
	@FindBy(xpath="//h1[text()='Create New Account']")
	private WebElement createAccountText;
	
	@FindBy(xpath="//small[text()='First name required']")
	private WebElement firstNameRequiredWarning;
	
	@FindBy(xpath="//small[text()='Last name required']")
	private WebElement LastNameRequiredWarning;
	
	@FindBy(xpath="//small[text()='Please enter your email address']")
	private WebElement enterEmailAddressWarning;
	
	@FindBy(xpath="//small[text()='Invalid email address']")
	private WebElement invalidEmailWarning;
	
	@FindBy(xpath="//small[text()='Please enter your mobile number']")
	private WebElement enterMobileNumberWarning;
	
	@FindBy(xpath="//small[text()='User with same mobile number already exist']")
	private WebElement mobileNumberExistWarning;
	
	@FindBy(xpath="//small[text()='invalid mobile number']")
	private WebElement invalidMobileNumberWarning;
	
	@FindBy(xpath="//small[text()='Please Enter Password']")
	private WebElement enterPasswordWarning;
	
	@FindBy(xpath="//p[text()='Please include combinations of Lowercase, Uppercase, Numbers and special characters.']")
	private WebElement passwordCombinationWarning;
	
	@FindBy(xpath="//p[text()='It is Too short']")
	private WebElement shortPasswordWarning;
	
	@FindBy(xpath="//small[text()='User already Exist,Please login']")
	private WebElement userAlreadyExistWarning;
	
	@FindBy(xpath="//small[text()='User already Exist as another Role. kindly use different Email Id']")
	private WebElement userExistInAnotherRoleWarning;
	
	
	//Actions:
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);	
	}
	
	public void enterMiddleName(String middleName) {
		middleNameField.sendKeys(middleName);	
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnCreateAccountOption() {
		createAccountOption.click();
	}
	
	
	
	public String retrieveInvalidEmailWarningText() {
		String warningText = invalidEmailWarning.getText();
		return warningText;
	}
	
	public String retrieveCreateAccountText() {
		String warningText = createAccountText.getText();
		return warningText;
	}
	
	public String retrieveFirstNameRequiredWarning() {
	   String warningText =  firstNameRequiredWarning.getText();
	   return warningText;
	}
	
	public String retrieveLastNameRequiredWarning() {
		   String warningText =  LastNameRequiredWarning.getText();
		   return warningText;
		}
	   
	public String retrieveEmailRequiredWarning() {
		   String warningText =  enterEmailAddressWarning.getText();
		   return warningText;
		}
	
	public String retrieveMobileNumberRequiredWarning() {
		   String warningText =  enterMobileNumberWarning.getText();
		   return warningText;
		}
	
	public String retrievePasswordRequiredWarning() {
		   String warningText = enterPasswordWarning.getText();
		   return warningText;
	}
	
	public String retrieveinvalidMobileNumberWarning() {
		   String warningText = invalidMobileNumberWarning.getText();
		   return warningText;
	}
	
	public String retrieveShortPasswordWarning() {
		   String warningText = shortPasswordWarning.getText();
		   return warningText;
	}
	
	public String retrievePasswordCombinationWarning() {
		   String warningText = passwordCombinationWarning.getText();
		   return warningText;
	}
	
	public String retrieveUserAlreadyExistWarning() {
		   String warningText = userAlreadyExistWarning.getText();
		   return warningText;
	}
	
	public String retrieveMobileNumberExistWarningText() {
		String warningText = mobileNumberExistWarning.getText();
		return warningText;
	}
	
	public String retrieveUserExistInAnotherRoleWarning() {
		String warningText = userExistInAnotherRoleWarning.getText();
		return warningText;
	}
	
	
}
