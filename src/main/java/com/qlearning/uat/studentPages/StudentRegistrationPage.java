package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentRegistrationPage {
	
	WebDriver driver;

	public StudentRegistrationPage(WebDriver driver) {
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
	private WebElement emailIdField;
	
	@FindBy(xpath="//div[text()='Phone']/following-sibling::input")
	private WebElement mobileNumberField;
	
	@FindBy(id="signup_pasword")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement submitButton;
	
	@FindBy(xpath="//small[text()='First name required']")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//small[text()='Last name required']")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//small[text()='Please Enter your Email']")
	private WebElement emailIdWarning;
	
	@FindBy(xpath="//small[text()='Please Enter Password']")
	private WebElement passwordWarning;
	
	@FindBy(xpath="//small[text()='Please enter your mobile number']")
	private WebElement mobileNumberWarning;
	
	
	
	
	//Actions:
	
	public void enterFirstName() {
		firstNameField.sendKeys("QL");
	}
	
	public void enterMiddleName() {
		middleNameField.sendKeys("FSS");
	}

	public void enterLastName() {
		lastNameField.sendKeys("Student");
	}
	
	public void enterEmailAddress() {
		emailIdField.sendKeys("coragib351@chodyi.com");
	}
	
	public void enterMobileNumber() {
		mobileNumberField.sendKeys("5768912345");
	}
	
	public void enterPassword() {
		passwordField.sendKeys("Student@123");
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}	
	
	public Boolean retrieveEnterFirstNameWarning() {
		Boolean warning = firstNameWarning.isDisplayed();
		return warning;
	}
	
	public Boolean retrieveEnterLastNameWarning() {
		Boolean warning = lastNameWarning.isDisplayed();
		return warning;
	}
	
	public Boolean retrieveEnterEmailWarning() {
		Boolean warning = emailIdWarning.isDisplayed();
		return warning;
	}
	 
	public Boolean retrieveEnterMobileNumberWarning() {
		Boolean warning = mobileNumberWarning.isDisplayed();
		return warning;
	}
	
	public Boolean retrieveEnterPasswordWarning() {
		Boolean warning = passwordWarning.isDisplayed();
		return warning;
	}
	
	
	
}
