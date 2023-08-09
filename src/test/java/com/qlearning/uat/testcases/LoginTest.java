package com.qlearning.uat.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test(priority = 1)
	public void verifyLoginWithInvalidCredentials() {

		loginPage.enterEmailAddress(dataProp.getProperty("invalidEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveRegistrationWarningText();
		Assert.assertEquals(actualWarning, "User is not valid, Kindly register");

	}
	
//TC_2
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

	@Test(priority = 3, dataProvider = "supplyDataFromDataProvider")
	public void verifyLoginWithDataProvider(String email, String password) {

		// LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		// driver.findElement(By.id("email")).sendKeys(email);
		loginPage.enterPassword(password);
		// driver.findElement(By.id("pasword")).sendKeys(password);
		dashboardPage = loginPage.clickOnLoginButton();
		// driver.findElement(By.className("login-form-btn")).click();
		// DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getDisplayStatusOfInstructorDashboard(),
				"Instructor Dashboard is not displayed");
	}

	@DataProvider(name = "supplyDataFromExcel")
	public Object[][] supplyExcelTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 4, dataProvider = "supplyDataFromExcel")
	public void verifyLoginWithExcelData(String email, String password) {

		// LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		// driver.findElement(By.id("email")).sendKeys(email);
		loginPage.enterPassword(password);
		// driver.findElement(By.id("pasword")).sendKeys(password);
		dashboardPage = loginPage.clickOnLoginButton();
		// driver.findElement(By.className("login-form-btn")).click();
		// DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getDisplayStatusOfInstructorDashboard(),
				"Instructor Dashboard is not displayed");
		// String actualStr = driver.findElement(By.xpath("//span[text()='Instructor
		// Dashboard']")).getText();
		// Assert.assertEquals(actualStr, "Instructor Dashboard");
	}

	@Test()
	public void verifyLoginWithoutFillingEmailId() {
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(actualWarning, "Please enter your email address");

	}

	@Test()
	public void verifyLoginWithoutFillingPassword() {
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.clickOnLoginButton();
		String actualWarning = loginPage.retrieveEnterPasswordWarningText();
		Assert.assertEquals(actualWarning, "Please Enter your Password");
      //  Assert.assertEquals("//small[text()='Please Enter your Password']", "Please Enter your Password");
	}

	@Test
	public void verifyLoginWithoutFillingAnyCredential() {
		loginPage.clickOnLoginButton();
		String emailWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(emailWarning, "Please enter your email address");
		String passwordWarning = loginPage.retrieveEnterPasswordWarningText();
		Assert.assertEquals(passwordWarning, "Please Enter your Password");
	}

	@Test
	public void verifyLoginWithInvalidEmailIdFormat() {
		loginPage.enterEmailAddress(dataProp.getProperty("invalidEmailFormat"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		loginPage.clickOnLoginButton();
		String invalidEmailWarning = loginPage.retrieveInvalidEmailWarningText();
		Assert.assertEquals(invalidEmailWarning, "Invalid email address");
	}

	@Test
	public void verifyLoginWithInvalidPassword() {
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickOnLoginButton();
		String invalidPasswordWarning = loginPage.retrieveInvalidPasswordWarningText();
		Assert.assertEquals(invalidPasswordWarning, "Invalid Credentials");
	}

	//TC_3
	@Test(groups = {"smoke"})
	public void verifyForgotPasswordPopupWithRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		Assert.assertTrue(loginPage.retrieveForgotPasswordPopup(), "forgot password popup is not displayed");
	}
	
	//TC_4
	@Test(groups = {"smoke"})
	public void verifyForgotPasswordEnterOTPWithRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.clickOnForgotPasswordSubmitButton();
		Assert.assertTrue(loginPage.retrieveForgotPasswordOTPpopup(),"forgot password OTP window is not displayed" );
	}

	
	
	@Test
	public void verifyForgotPasswordWithNotRegisteredEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(dataProp.getProperty("invalidEmail"));
		loginPage.clickOnForgotPasswordSubmitButton();
		String notRegisteredEmailWarning = loginPage.retrieveNotRegisteredEmailWarning();
		Assert.assertEquals(notRegisteredEmailWarning, "Unable to find this user");
	}

	@Test
	public void verifyForgotPasswordWithInvalidEmailIdFormat() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.enterForgotPasswordEmailAddress(dataProp.getProperty("invalidEmailFormat"));
		loginPage.clickOnForgotPasswordSubmitButton();
		String invalidEmailWarning = loginPage.retrieveInvalidEmailWarningText();
		Assert.assertEquals(invalidEmailWarning, "Invalid email address");
	}

	@Test
	public void verifyForgotPasswordWithoutEnteringEmailId() {
		loginPage.clickOnForgotPasswordOption();
		loginPage.clickOnForgotPasswordSubmitButton();
		String actualWarning = loginPage.retrieveEnterEmailWarningText();
		Assert.assertEquals(actualWarning, "Please enter your email address");
	}

	@Test
	public void verifyCreateAccountButtonNavigation() {
		registerPage = loginPage.clickOnLoginPageCreateAccountButton();
		String createAccountText = registerPage.retrieveCreateAccountText();
		Assert.assertEquals(createAccountText, "Create New Account");

	}

	//TC_08
	@Test(groups = {"smoke"})
	public void verifyMobileLoginOTPpopup() {
		loginPage.clickOnLoginWithMobileOption();
		loginPage.enterMobileNumberField();
		loginPage.clickOnMobileNumberSubmitButton();
		Assert.assertTrue(loginPage.retrieveMobileOTPpage(),"Mobile OTP page is not displayed" );	
	}
	
	
	@Test
	public void verifyCarouselNextButtonFunctionality() {
		loginPage.clickOnCarouselNextButton();
	}

	
	@Test
	public void verifyCarouselBackButtonFunctionality() {
		loginPage.clickOnCarouselBackButton();
	}

}
