package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLoginPage {
	
	WebDriver driver;

	public StudentLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Objects:
	
	@FindBy(id="email")
	private WebElement emailIdField;
	
	@FindBy(id="pasword")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement loginButton;
	
	@FindBy(xpath="//label[text()='Forgot Password?']")
	private WebElement forgotPasswordButton;
	
	@FindBy(xpath="//small[text()='Please Enter your Email']")
	private WebElement enterEmailWarning;
	
	@FindBy(xpath="//small[text()='Please Enter your Password']")
	private WebElement enterPasswordWarning;
	
	//Actions:
	
	public void enterEmailAddress() {
		emailIdField.sendKeys("coragib351@chodyi.com");
	}
	
	public void enterPassword() {
		passwordField.sendKeys("Student@123");
	}
	
	public StudentDashboardPage clickOnLoginButton() {
		loginButton.click();
		return new StudentDashboardPage(driver);
	}
    
	public Boolean retrieveEnterEmailWarning() {
		Boolean warning = enterEmailWarning.isDisplayed();
		return warning;
	}
	 
	public Boolean retrieveEnterPasswordWarning() {
		Boolean warning = enterPasswordWarning.isDisplayed();
		return warning;
	}
	
	
}
