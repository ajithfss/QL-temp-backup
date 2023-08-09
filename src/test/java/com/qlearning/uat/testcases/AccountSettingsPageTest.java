package com.qlearning.uat.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.AccountSettingsPage;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.ProfilePage;

public class AccountSettingsPageTest extends Base{

	public AccountSettingsPageTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfilePage profilePage;
	AccountSettingsPage accountSettingsPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		profilePage = dashboardPage.clickOnInstructorProfileIcon();
		accountSettingsPage = profilePage.clickOnAccountSettingsPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//TC_14
	@Test(groups= {"smoke"})
	public void verifyNavigateToAccountSettingsPageFunctionality() {
		Assert.assertTrue(accountSettingsPage.retrieveAccountSettingsText(),"account settings  page is not displayed");
	}
	
	//TC_15
	@Test(groups= {"smoke"})
	public void verifyChangeEmailFunctionality() {
		accountSettingsPage.clickOnEmailChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Email']")));
		Assert.assertTrue(accountSettingsPage.retrieveChangeEmailText(),"change email popup is not displayed");
	}
	
	//TC_17
	@Test(groups= {"smoke"})
	public void verifyCloseButtonInChangeEmailPopup() {
		accountSettingsPage.clickOnEmailChangeButton();
		Assert.assertTrue(accountSettingsPage.retrieveChangeEmailText(),"change email popup is not displayed");
		accountSettingsPage.clickOnCloseButton();
	}
	
	
	@Test
	public void verifyEnterEmailWarning() {
		accountSettingsPage.clickOnEmailChangeButton();
		accountSettingsPage.clickOnInsideChangeEmailButton();
		Assert.assertTrue(accountSettingsPage.retrieveEnterEmailWarning(),"enter your email warning is not displayed");
	}
	
	@Test
	public void verifyInvalidEmailWarning() {
		accountSettingsPage.clickOnEmailChangeButton();
		accountSettingsPage.clickOnInsideChangeEmailButton();
		accountSettingsPage.enterInvalidEmail();
		Assert.assertTrue(accountSettingsPage.retrieveInvalidEmailWarning(),"Invalid email warning is not displayed");		
	}
	
	//TC_19
	@Test(groups= {"smoke"})
	public void verifyChangePasswordFunctionality() {
		accountSettingsPage.clickOnPasswordChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Password']")));
		Assert.assertTrue(accountSettingsPage.retrieveChangePasswordText(),"change password popup is not displayed");
	}
	
	@Test
	public void verifyPasswordFillThisFieldWarning() {
		accountSettingsPage.clickOnPasswordChangeButton();
		accountSettingsPage.clickOnInsideChangePasswordButton();
		Assert.assertTrue(accountSettingsPage.retrieveFillThisFieldWarning(), "please fill this field warning is not displayed");
	}
	
	@Test
	public void VerifyInvalidCurrentPasswordWarning() {
		accountSettingsPage.clickOnPasswordChangeButton();
		accountSettingsPage.fillInvalidPasswordData();
		accountSettingsPage.clickOnInsideChangePasswordButton();
		Assert.assertTrue(accountSettingsPage.retrieveInvalidCurrentPasswordWarning(), "Invalid current password warning is not shown");
	}
	
	@Test
	public void verifyShortPasswordWarning() {
		accountSettingsPage.clickOnPasswordChangeButton();
		accountSettingsPage.enterShortPassword();
		accountSettingsPage.clickOnInsideChangePasswordButton();
		Assert.assertTrue(accountSettingsPage.retrieveShortPasswordWarning(),"short password warning is not displayed");	
	}
	
	@Test
	public void verifyPasswordCombinationWarning() {
		accountSettingsPage.clickOnPasswordChangeButton();
		accountSettingsPage.enterComboLessPassword();
		accountSettingsPage.clickOnInsideChangePasswordButton();
		Assert.assertTrue(accountSettingsPage.retrievePasswordComboWarning(),"password combination missing warning is not displayed");
	}
	
	@Test
	public void verifyPasswordNotMatchWarning() {
		accountSettingsPage.clickOnPasswordChangeButton();
		accountSettingsPage.enterMismatchPassword();
		Assert.assertTrue(accountSettingsPage.retrievePasswordMisMatchWarning(),"password mismatch warning is not displayed");
	}
	
	//TC_21
	@Test
	public void verifyChangeMobileNumberFunctionality() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Mobile Number']")));
		Assert.assertTrue(accountSettingsPage.retrieveChangeMobileNumberPopup(), "change mobile number popup is not displayed");
	}
	
	@Test
	public void verifyChangeMobileNumberOTPSendFunctionality() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		accountSettingsPage.enterNewMobileNumberField();
		accountSettingsPage.clickOnChangeMobileNumberSubmitButton();
		Assert.assertTrue(accountSettingsPage.retrieveOTPSentText(), "OTP sent message is not displayed");
	}
	
	@Test
	public void verifyOTPfailedWarning() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		accountSettingsPage.enterNewMobileNumberField();
		accountSettingsPage.clickOnChangeMobileNumberSubmitButton();
		accountSettingsPage.enterWrongOTP();
		accountSettingsPage.clickOnOTPverifyButton();
		Assert.assertTrue(accountSettingsPage.retrieveOtpVerificationWarningText(),"Otp verification failed message is not displayed");
	}
	
//	@Test
//	public void verifyOTPfailedWarningWithBlankField() {
//		accountSettingsPage.clickOnMobileNumberChangeButton();
//		accountSettingsPage.enterNewMobileNumberField();
//		accountSettingsPage.clickOnChangeMobileNumberSubmitButton();
//		accountSettingsPage.clickOnOTPverifyButton();
//		Assert.assertTrue(accountSettingsPage.retrieveOtpVerificationWarningText(),"Otp verification failed message is not displayed");	
//	}
	
	@Test
	public void verifyInvalidMobileNumberWarning() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		accountSettingsPage.enterInvalidMobileNumber();
		Assert.assertTrue(accountSettingsPage.retrieveInvalidWarning(), "invalid warning is not displayed");
	}
	
	@Test
	public void verifySameMobileNumberExistsWarning() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		accountSettingsPage.enterExistMobileNumber();
		accountSettingsPage.clickOnChangeMobileNumberSubmitButton();
		Assert.assertTrue(accountSettingsPage.retrieveSameMobileNumberExistWarning(), "same mobile exist warning is not shown");
	}
	
	//TC_24
	@Test(groups= {"smoke"})
	public void verifyCloseButtonInChangeMobileNumberPopup() {
		accountSettingsPage.clickOnMobileNumberChangeButton();
		accountSettingsPage.clickOnCloseButton();
		Assert.assertTrue(accountSettingsPage.retrieveAccountSettingsText(),"account settings  page is not displayed");	
	}
	
	//TC_25
	@Test(groups= {"smoke"})
	public void verifyAccountActivityDetails() {
		accountSettingsPage.clickOnLoginActivityViewButton();
		Assert.assertTrue(accountSettingsPage.retrieveLoginAlertsText(),"Login Alerts is not displayed");
		Assert.assertTrue(accountSettingsPage.retrievePasswordUpdateText(),"Password Update is not displayed");
		Assert.assertTrue(accountSettingsPage.retrieveEmailUpdateText(),"Email Update is not displayed");
		Assert.assertTrue(accountSettingsPage.retrieveMobileNumberUpdateText(),"MobileNumberUpdate is not displayed");
	}
	
	//TC_26
	@Test(groups= {"smoke"})
	public void verifyCloseButtonInAccountActivityPopup() {
		accountSettingsPage.clickOnLoginActivityViewButton();
		accountSettingsPage.clickOnCloseButton();
		Assert.assertTrue(accountSettingsPage.retrieveAccountSettingsText(),"account settings  page is not displayed");
	}
	
	//TC_27
	@Test(groups= {"smoke"})
	public void verifyDeleteAccountFunctionality() {
		accountSettingsPage.clickOnDeactivateButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes, Delete Account']")));
		Assert.assertTrue(accountSettingsPage.retrieveDeleteAccountText(), "Delete account popup is not displayed");
		
	}
	
	//TC_29
	@Test(groups= {"smoke"})
	public void verifyCancelButtonInDeleteAccount() {
		accountSettingsPage.clickOnDeactivateButton();
		accountSettingsPage.clickOnCancelButtonInDeleteAccount();
		Assert.assertTrue(accountSettingsPage.retrieveAccountSettingsText(),"account settings  page is not displayed");
	}
	
	//TC_30
	@Test(groups= {"smoke"})
	public void verifyCloseButtonInDeleteAccountPopup() {
		accountSettingsPage.clickOnDeactivateButton();
		accountSettingsPage.clickOnCloseButton();
		Assert.assertTrue(accountSettingsPage.retrieveAccountSettingsText(),"account settings  page is not displayed");
	}
	
	
	
	
}
