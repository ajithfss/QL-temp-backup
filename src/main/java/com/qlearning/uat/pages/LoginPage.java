package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Objects:
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "pasword")
	private WebElement passwordField;

	@FindBy(className = "login-form-btn")
	private WebElement loginButton;

	@FindBy(xpath = "//label[text()='Forgot Password?']")
	private WebElement forgotPassword;

	@FindBy(xpath = "//button[text()='Log in With Google']")
	private WebElement loginWithGoogle;

	@FindBy(xpath = "//button[text()= ' Log in With Mobile']")
	private WebElement loginWithMobile;

	@FindBy(linkText = "Create Account")
	private WebElement loginPageCreateAccount;

	@FindBy(xpath = "//small[text()='User is not valid, Kindly register']")
	private WebElement registrationWarning;

	@FindBy(xpath = "//small[text()='Invalid email address']")
	private WebElement invalidEmailAddressWarning;

	@FindBy(xpath = "//small[text()='Please enter your email address']")
	private WebElement enterYourEmailAddressWarning;

	@FindBy(xpath = "//small[text()='Please Enter your Password']")
	private WebElement enterYourPasswordWarning;

	@FindBy(xpath = "//small[text()='Invalid Credentials']")
	private WebElement invalidPasswordWarning;

	@FindBy(xpath = "//input[@placeholder='Type Your Email']")
	private WebElement forgotPasswordEmailIdField;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement forgotPasswordSubmitButton;
	
	@FindBy(xpath="//label[text()='Type Your Email']")
	private WebElement forgotPasswordPopup;
	
	@FindBy(xpath="//label[text()='Enter 6 Digit OTP Code']")
	private WebElement forgotPasswordOTPpopup;
	
	@FindBy(xpath="//span[text()='Choose an account']")
	private WebElement chooseAnAccountPopupWindow;
	
	@FindBy(xpath="//label[text()='Enter the OTP']")
	private WebElement mobileOTPpage;

	@FindBy(xpath = "//small[text()='Unable to find this user']")
	private WebElement notRegisteredEmailWarning;
	
	@FindBy(xpath ="//label[text()='Enter the mobile number']/following::input")
	private WebElement mobileNumberField;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement mobileNumberSubmitButton;

	@FindBy(css = ".slide-next-frm")
	private WebElement carouselNextButton;

	@FindBy(css = "div.slide-prev-frm.me-3")
	private WebElement carouselBackButton;

	// Actions:
	public void enterEmailAddress(String email) {

		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);

	}

	public DashboardPage clickOnLoginButton() {

		loginButton.click();
		return new DashboardPage(driver);

	}

	public String retrieveRegistrationWarningText() {
		String warningText = registrationWarning.getText();
		return warningText;
	}

	public String retrieveEnterEmailWarningText() {
		String warningText = enterYourEmailAddressWarning.getText();
		return warningText;
	}

	public String retrieveEnterPasswordWarningText() {
		String warningText = enterYourPasswordWarning.getText();
		return warningText;
	}

	public String retrieveInvalidEmailWarningText() {
		String warningText = invalidEmailAddressWarning.getText();
		return warningText;
	}

	public String retrieveInvalidPasswordWarningText() {
		String warningText = invalidPasswordWarning.getText();
		return warningText;
	}

	public void clickOnForgotPasswordOption() {
		forgotPassword.click();
	}

	public void clickOnForgotPasswordSubmitButton() {
		forgotPasswordSubmitButton.click();
	}

	public Boolean retrieveForgotPasswordPopup() {
		Boolean popup = forgotPasswordPopup.isDisplayed();
		return popup;
	}
	
	public Boolean retrieveForgotPasswordOTPpopup() {
		Boolean oTPpopup = forgotPasswordOTPpopup.isDisplayed();
		return oTPpopup;
	}
	
	public Boolean retrieveChooseAnAccountPopupWindow() {
		Boolean googlePopup = chooseAnAccountPopupWindow.isDisplayed();
		return googlePopup;
	}
	
	public void enterForgotPasswordEmailAddress(String email) {

		forgotPasswordEmailIdField.sendKeys(email);
	}

	public String retrieveNotRegisteredEmailWarning() {
		String warningText = notRegisteredEmailWarning.getText();
		return warningText;
	}

	public RegisterPage clickOnLoginPageCreateAccountButton() {
		loginPageCreateAccount.click();
		return new RegisterPage(driver);
	}

	public void clickOnCarouselNextButton() {
		carouselNextButton.click();
	}

	public void clickOnCarouselBackButton() {
		carouselBackButton.click();
	}
	
	public void clickOnLoginWithGoogleOption() {
		loginWithGoogle.click();
	}
	
	public void clickOnLoginWithMobileOption() {
		loginWithMobile.click();
	}
	
	public void enterMobileNumberField() {
		mobileNumberField.sendKeys("9626919255");
	}
	
	public void clickOnMobileNumberSubmitButton() {
		mobileNumberSubmitButton.click();
	}
	
	public Boolean retrieveMobileOTPpage() {
		Boolean otpPage = mobileOTPpage.isDisplayed();
		return otpPage;
	}
}
