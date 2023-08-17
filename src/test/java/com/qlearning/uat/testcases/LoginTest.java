package com.qlearning.uat.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.RegisterPage;
import com.qlearning.uat.utils.Utilities;

public class LoginTest extends Base {
	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RegisterPage registerPage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups= {"smoke"})
	public void verifyLoginPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/login");
	}

	@Test(priority = 1,groups= {"regression"})
	public void verifyLoginWithInvalidCredentials() {

		loginPage.enterEmailAddress(dataProp.getProperty("invalidEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveRegistrationWarningText();
		Assert.assertEquals(actualWarning, "User is not valid, Kindly register");

	}
	

	@Test(priority = 2, groups = {"smoke"} )
	public void verifyLoginWithValidCredentials() {

		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		Assert.assertTrue(dashboardPage.getDisplayStatusOfInstructorDashboard(),
				"Instructor Dashboard is not displayed");
	}

	@DataProvider(name = "supplyDataFromDataProvider")
	public Object[][] supplyTestData() {
		Object[][] data = { { "snicsa@exelica.com", "UATinst@1234" } };
		return data;
	}

	//@Test(priority = 3, dataProvider = "supplyDataFromDataProvider")
	public void verifyLoginWithDataProvider(String email, String password) {

	
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		dashboardPage = loginPage.clickOnLoginButton();
		Assert.assertTrue(dashboardPage.getDisplayStatusOfInstructorDashboard(),
				"Instructor Dashboard is not displayed");
	}

	@DataProvider(name = "supplyDataFromExcel")
	public Object[][] supplyExcelTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	//@Test(priority = 4, dataProvider = "supplyDataFromExcel")
	public void verifyLoginWithExcelData(String email, String password) {
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		dashboardPage = loginPage.clickOnLoginButton();
		Assert.assertTrue(dashboardPage.getDisplayStatusOfInstructorDashboard(),
				"Instructor Dashboard is not displayed");	
	}

	@Test(groups = {"smoke"})
	public void verifyLoginWithoutFillingEmailId() {
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(actualWarning, "Please enter your email address");

	}

	@Test(groups = {"smoke"})
	public void verifyLoginWithoutFillingPassword() {
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveEnterPasswordWarningText();
		Assert.assertEquals(actualWarning, "Please Enter your Password");
      //  Assert.assertEquals("//small[text()='Please Enter your Password']", "Please Enter your Password");
	}

	@Test(groups = {"smoke"})
	public void verifyLoginWithoutFillingAnyCredential() {
		loginPage.clickOnLoginButton();
		String emailWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(emailWarning, "Please enter your email address");
		String passwordWarning = loginPage.retrieveEnterPasswordWarningText();
		Assert.assertEquals(passwordWarning, "Please Enter your Password");
	}

	@Test(groups = {"regression"})
	public void verifyLoginWithInvalidEmailIdFormat() {
		loginPage.enterEmailAddress(dataProp.getProperty("invalidEmailFormat"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		loginPage.clickOnLoginButton();
		String invalidEmailWarning = loginPage.retrieveInvalidEmailWarningText();
		Assert.assertEquals(invalidEmailWarning, "Invalid email address");
	}

	@Test(groups = {"regression"})
	public void verifyLoginWithInvalidPassword() {
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickOnLoginButton();
		String invalidPasswordWarning = loginPage.retrieveInvalidPasswordWarningText();
		Assert.assertEquals(invalidPasswordWarning, "Invalid Credentials");
	}

	
	@Test(groups = {"regression"})
	public void verifyForgotPasswordPopupWithRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		Assert.assertTrue(loginPage.retrieveForgotPasswordPopup(), "forgot password popup is not displayed");
	}
	
	//TC_4
	@Test(groups = {"regression"})
	public void verifyForgotPasswordEnterOTPWithRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.clickOnForgotPasswordSubmitButton();
		Assert.assertTrue(loginPage.retrieveForgotPasswordOTPpopup(),"forgot password OTP window is not displayed" );
	}

	
	
	@Test(groups = {"regression"})
	public void verifyForgotPasswordWithNotRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(dataProp.getProperty("invalidEmail"));
		loginPage.clickOnForgotPasswordSubmitButton();
		String notRegisteredEmailWarning = loginPage.retrieveNotRegisteredEmailWarning();
		Assert.assertEquals(notRegisteredEmailWarning, "Unable to find this user");
	}

	@Test(groups = {"regression"})
	public void verifyForgotPasswordWithInvalidEmailIdFormat() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(dataProp.getProperty("invalidEmailFormat"));
		loginPage.clickOnForgotPasswordSubmitButton();
		String invalidEmailWarning = loginPage.retrieveInvalidEmailWarningText();
		Assert.assertEquals(invalidEmailWarning, "Invalid email address");
	}

	@Test(groups = {"regression"})
	public void verifyForgotPasswordWithoutEnteringEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.clickOnForgotPasswordSubmitButton();
		String actualWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(actualWarning, "Please enter your email address");
	}

	@Test(groups = {"regression"})
	public void verifyCreateAccountButtonNavigation() {
		registerPage = loginPage.clickOnLoginPageCreateAccountButton();
		String createAccountText = registerPage.retrieveCreateAccountText();
		Assert.assertEquals(createAccountText, "Create New Account");

	}

	
	@Test(groups = {"regression"})
	public void verifyMobileLoginOTPpopup() {
		loginPage.clickOnLoginWithMobileOption();
		loginPage.enterMobileNumberField();
		loginPage.clickOnMobileNumberSubmitButton();
		Assert.assertTrue(loginPage.retrieveMobileOTPpage(),"Mobile OTP page is not displayed" );	
	}
	
	
	@Test(groups = {"regression"})
	public void verifyCarouselNextButtonFunctionality() {
		loginPage.clickOnCarouselNextButton();
	}

	
	@Test(groups = {"regression"})
	public void verifyCarouselBackButtonFunctionality() {
		loginPage.clickOnCarouselBackButton();
	}

}
