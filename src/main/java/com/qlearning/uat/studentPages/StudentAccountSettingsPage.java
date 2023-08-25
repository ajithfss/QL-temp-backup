package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAccountSettingsPage {

	WebDriver driver;

	public StudentAccountSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(linkText="Account Settings")
	private WebElement accountSettingsTab;
	
	@FindBy(xpath="(//button[text()='Change'])[1]")
	private WebElement emailChangeButton;
	
	@FindBy(xpath="(//button[text()='Change'])[2]")
	private WebElement passwordChangeButton;
	
	@FindBy(xpath="(//button[text()='Change'])[3]")
	private WebElement mobileNumberChangeButton;
	
	@FindBy(xpath="//button[text()='View']")
	private WebElement loginActivityViewButton;
	
	@FindBy(xpath="//button[text()='Deactivate']")
	private WebElement deactivateButton;
	
	@FindBy(xpath="//div[text()='Change Email']")
	private WebElement changeEmailTab;
	
	@FindBy(xpath="//div[text()='Change Password']")
	private WebElement changePasswordTab;
	
	@FindBy(xpath="//div[text()='Change Mobile Number']")
	private WebElement changeMobileNumberTab;
	
	@FindBy(xpath="//b[text()='Login Alerts']")
	private WebElement loginAlertsText;
	
	@FindBy(xpath="//b[text()='Password Updated Successfully']")
	private WebElement passwordUpdateText;
	
	@FindBy(xpath="//b[text()='Email updated Successfully']")
	private WebElement emailUpdateText;
	
	@FindBy(xpath="//b[text()='Mobile number updated Successfully']")
	private WebElement mobileNumberUpdateText;
	
	@FindBy(xpath="//p[contains(@class,'text-center mb-2')]")
	private WebElement deleteAccountText;
	
	//Actions:
	
	public Boolean retrieveAccountSettingsText() {
		Boolean text = accountSettingsTab.isDisplayed();
		return text;
	}
	
	public void clickOnEmailChangeButton() {
		emailChangeButton.click();
	}
	
	public Boolean retrieveChangeEmailText() {
		Boolean changeEmail = changeEmailTab.isDisplayed();
		return changeEmail;
	}
	
	public void clickOnPasswordChangeButton() {
		passwordChangeButton.click();
	}
	
	public Boolean retrieveChangePasswordText() {
		Boolean changePassword = changePasswordTab.isDisplayed();
		return changePassword;
	}
	
	public void clickOnMobileNumberChangeButton() {
		mobileNumberChangeButton.click();
	}
	
	public Boolean retrieveChangeMobileNumberPopup() {
		Boolean warning = changeMobileNumberTab.isDisplayed();
		return warning;
	}
	
	public void clickOnLoginActivityViewButton() {
		loginActivityViewButton.click();
	}
	
	public Boolean retrieveLoginAlertsText() {
		Boolean login = loginAlertsText.isDisplayed();
		return login;
	}
	
	public Boolean retrievePasswordUpdateText() {
		Boolean password = passwordUpdateText.isDisplayed();
		return password;
	}
	
	public Boolean retrieveEmailUpdateText() {
		Boolean email = emailUpdateText.isDisplayed();
		return email;
	}
	
	public Boolean retrieveMobileNumberUpdateText() {
		Boolean mobileNumber = mobileNumberUpdateText.isDisplayed();
		return mobileNumber;
	}
	 
	public void clickOnDeactivateButton() {
		deactivateButton.click();
	}
	
	
	public Boolean retrieveDeleteAccountText() {
		Boolean deleteAccountPopup = deleteAccountText.isDisplayed();
		return deleteAccountPopup;
	}
	
}
