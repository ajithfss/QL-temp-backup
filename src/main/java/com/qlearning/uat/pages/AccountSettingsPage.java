package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage {
	WebDriver driver;

	public AccountSettingsPage(WebDriver driver) {
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
	
	@FindBy(name="emailOld")
	private WebElement presentEmail;
	
	@FindBy(name="emailNew")
	private WebElement newEmail;
	
	@FindBy(xpath="//button[text()='Change Email']")
	private WebElement insideChangeEmailButton;
	
	@FindBy(xpath="//small[text()='Please enter your email address']")
	private WebElement enterEmailWarning;
	
	@FindBy(xpath="//small[text()='Invalid email address']")
	private WebElement invalidEmailWarning;
	
	@FindBy(className="btn-close")
	private WebElement closeButton;
	
	@FindBy(xpath="//div[text()='Change Password']")
	private WebElement changePasswordTab;
	
	@FindBy(name="currentPassword")
	private WebElement currentPasswordField;
	
	@FindBy(id="newpass")
	private WebElement newPasswordField;
	
	@FindBy(id="Confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[text()='Change Password']")
	private WebElement insideChangePasswordButton;
	
	@FindBy(xpath="(//small[text()='Please fill this field'])[1]")
	private WebElement fillThisFieldWarning;
	
	@FindBy(xpath="//small[text()='Current Password entered is invalid.']")
	private WebElement invalidCurrentPasswordWarning; 
	
	@FindBy(xpath="//small[text()='Too short']")
	private WebElement shortPasswordWarning;
	
	@FindBy(xpath="//small[text()='Must contain at least one special character, one number and one uppercase and lowercase letter, and at least 8 or more characters and maximum 16 Characters']")
	private WebElement passwordComboWarning;
	
	@FindBy(xpath="//small[contains(@class,'text-danger mb-2')]//span[1]")
	private WebElement passwordMismatchWarning;
	
	@FindBy(xpath="//div[text()='Change Mobile Number']")
	private WebElement changeMobileNumberTab;
	
	@FindBy(xpath="//label[text()='Enter the new mobile number']/following::input")
	private WebElement newMobileNumberField;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement changeMobileNumberSubmitButton;
	
	@FindBy(xpath="//p[text()='We Sent 6 Digit OTP to +']")
	private WebElement otpSentText;
	
	@FindBy(xpath="//label[text()='Enter the OTP']/following::input")
	private WebElement otpField;
	
	@FindBy(xpath="//small[text()='OTP verification failed! please try again.']")
	private WebElement otpVerificationWarningText;
	
	@FindBy (xpath="//button[text()='Verify']")
	private WebElement otpVerifyButton;
	
	@FindBy(xpath="//small[text()='Invalid']")
	private WebElement invalidWarning;
	
	@FindBy(xpath="//small[text()='Same Mobile Number Already exists']")
	private WebElement sameMobileNumberExistWarning;
	
	@FindBy(xpath="//b[text()='Login Alerts']")
	private WebElement loginAlertsText;
	
	@FindBy(xpath="//b[text()='Password Updated Successfully']")
	private WebElement passwordUpdateText;
	
	@FindBy(xpath="//b[text()='Purchased Successfully']")
	private WebElement purchaseSuccessText;
	
	@FindBy(xpath="//b[text()='Remainder for payment']")
	private WebElement remainderPaymentText;
	
	@FindBy(xpath="//b[text()='New login from AnotherIP']")
	private WebElement newLoginAnotherIPText;
	
	@FindBy(xpath="//b[text()='Email updated Successfully']")
	private WebElement emailUpdateText;
	
	@FindBy(xpath="//b[text()='Mobile number updated Successfully']")
	private WebElement mobileNumberUpdateText;
	
	@FindBy(xpath="//button[text()='Yes, Delete Account']")
	private WebElement deleteAccountText;
	
	@FindBy(xpath="//button[text()='Yes, Delete Account']")
	private WebElement deleteAccountButton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelDeleteAccountButton;
	
	//Actions:
	
	public Boolean retrieveAccountSettingsText() {
		Boolean accountSettingsText = accountSettingsTab.isDisplayed();
		return accountSettingsText;
	}
	
	public void clickOnEmailChangeButton() {
		emailChangeButton.click();
	}
	
	public Boolean retrieveChangeEmailText() {
		Boolean changeEmail = changeEmailTab.isDisplayed();
		return changeEmail;
	}
	
	public void clickOnCloseButton() {
		closeButton.click();
	}
	
	public void clickOnInsideChangeEmailButton() {
		insideChangeEmailButton.click();
	}
	
	public Boolean retrieveEnterEmailWarning() {
		Boolean warning = enterEmailWarning.isDisplayed();
		return warning;
	}
	
	public Boolean retrieveInvalidEmailWarning() {
		Boolean warning = invalidEmailWarning.isDisplayed();
		return warning;
	}
	
	public void enterInvalidEmail() {
		newEmail.sendKeys("asdf");
	}
	
	public void clickOnPasswordChangeButton() {
		passwordChangeButton.click();
	}
	
	public Boolean retrieveChangePasswordText() {
		Boolean changePassword = changePasswordTab.isDisplayed();
		return changePassword;
	}
	
	public Boolean retrieveFillThisFieldWarning() {
		Boolean warning = fillThisFieldWarning.isDisplayed();
		return warning;
	}
	
	public void clickOnInsideChangePasswordButton() {
		insideChangePasswordButton.click();
	}
	

	public Boolean retrieveInvalidCurrentPasswordWarning() {
		Boolean warning = invalidCurrentPasswordWarning.isDisplayed();
		return warning;
	}
	
	public void fillInvalidPasswordData() {
		currentPasswordField.sendKeys("Asdfgh@123");
		newPasswordField.sendKeys("Password@123");
		confirmPasswordField.sendKeys("Password@123");
	}
	
	public Boolean retrieveShortPasswordWarning() {
		Boolean warning = shortPasswordWarning.isDisplayed();
		return warning;
	}
	
	public void enterShortPassword() {
		currentPasswordField.sendKeys("asd");
	}
	
	public void enterComboLessPassword() {
		currentPasswordField.sendKeys("asdfghjklp");
	}
	
	public Boolean retrievePasswordComboWarning() {
		Boolean warning = passwordComboWarning.isDisplayed();
		return warning;
	}
	
	public void enterMismatchPassword() {
		currentPasswordField.sendKeys("Testing@123");
		newPasswordField.sendKeys("Test@123456");
		confirmPasswordField.sendKeys("Test@654321");
	}
	
	public Boolean retrievePasswordMisMatchWarning() {
		Boolean warning = passwordMismatchWarning.isDisplayed();
		return warning;
	}
	
	public void clickOnMobileNumberChangeButton() {
		mobileNumberChangeButton.click();
	}
	
	public Boolean retrieveChangeMobileNumberPopup() {
		Boolean warning = changeMobileNumberTab.isDisplayed();
		return warning;
	}
	
	public void enterNewMobileNumberField() {
		newMobileNumberField.sendKeys("9626919255");
	}
	
	
	public void clickOnChangeMobileNumberSubmitButton() {
		changeMobileNumberSubmitButton.submit();
	}
	
	public Boolean retrieveOTPSentText() {
		Boolean warning = otpSentText.isDisplayed();
		return warning;
	}
	
	public void enterWrongOTP() {
		otpField.sendKeys("123456");
	}
	
	public Boolean retrieveOtpVerificationWarningText() {
		Boolean warning = otpVerificationWarningText.isDisplayed();
		return warning;
	}
	
	public void clickOnOTPverifyButton() {
		otpVerifyButton.click();
	}
	
	public void enterInvalidMobileNumber() {
		newMobileNumberField.sendKeys("1236");
	}
	
	public Boolean retrieveInvalidWarning() {
		Boolean warning = invalidWarning.isDisplayed();
		return warning;
	}
	
	public Boolean retrieveSameMobileNumberExistWarning() {
		Boolean warning = sameMobileNumberExistWarning.isDisplayed();
		return warning;
	}
	
	public void enterExistMobileNumber() {
		newMobileNumberField.sendKeys("9966767476");
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
	
	public void clickOnCancelButtonInDeleteAccount() {
		cancelDeleteAccountButton.click();
	}
}
