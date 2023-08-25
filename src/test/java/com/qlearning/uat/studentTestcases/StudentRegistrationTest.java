package com.qlearning.uat.studentTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.StudentBase;
import com.qlearning.uat.studentPages.StudentHomePage;
import com.qlearning.uat.studentPages.StudentRegistrationPage;

public class StudentRegistrationTest extends StudentBase{
	

	public StudentRegistrationTest() {
		super();
	}
	
	public WebDriver driver;
	StudentRegistrationPage studentRegistrationPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentRegistrationPage = studentHomePage.clickOnCreateAccountOption();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyStudentRegistrationUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/create-student-account");
	}
	
	@Test
	public void verifyFirstNameRequiredWarning() {
		studentRegistrationPage.enterLastName();
		studentRegistrationPage.enterMiddleName();
		studentRegistrationPage.enterEmailAddress();
		studentRegistrationPage.enterMobileNumber();
		studentRegistrationPage.enterPassword();
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterFirstNameWarning(),"Enter your First Name warning is not shown");
	}
	
	@Test
	public void verifyLastNameRequiredWarning() {
		studentRegistrationPage.enterFirstName();
		studentRegistrationPage.enterMiddleName();
		studentRegistrationPage.enterEmailAddress();
		studentRegistrationPage.enterMobileNumber();
		studentRegistrationPage.enterPassword();
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterLastNameWarning(),"Enter your Last Name warning is not shown");
	}
	
	@Test
	public void verifyEmailRequiredWarning() {
		studentRegistrationPage.enterFirstName();
		studentRegistrationPage.enterMiddleName();
		studentRegistrationPage.enterLastName();
		studentRegistrationPage.enterMobileNumber();
		studentRegistrationPage.enterPassword();
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterEmailWarning(),"Enter your email warning is not shown");
	}
	
	@Test
	public void verifyMobileNumberRequiredWarning() {
		studentRegistrationPage.enterFirstName();
		studentRegistrationPage.enterMiddleName();
		studentRegistrationPage.enterLastName();
		studentRegistrationPage.enterEmailAddress();
		studentRegistrationPage.enterPassword();
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterMobileNumberWarning(),"Enter your mobile number warning is not shown");
	}
	
	@Test
	public void verifyPasswordRequiredWarning() {
		studentRegistrationPage.enterFirstName();
		studentRegistrationPage.enterMiddleName();
		studentRegistrationPage.enterLastName();
		studentRegistrationPage.enterEmailAddress();
		studentRegistrationPage.enterMobileNumber();
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterPasswordWarning(),"Enter your password warning is not shown");
	}
	
	@Test
	public void verifyRegistrationWithoutFillingAnyFields() {
		studentRegistrationPage.clickOnSubmitButton();
		Assert.assertTrue(studentRegistrationPage.retrieveEnterFirstNameWarning(),"Enter your First Name warning is not shown");
		Assert.assertTrue(studentRegistrationPage.retrieveEnterLastNameWarning(),"Enter your Last Name warning is not shown");
		Assert.assertTrue(studentRegistrationPage.retrieveEnterEmailWarning(),"Enter your email warning is not shown");
		Assert.assertTrue(studentRegistrationPage.retrieveEnterMobileNumberWarning(),"Enter your mobile number warning is not shown");
		Assert.assertTrue(studentRegistrationPage.retrieveEnterPasswordWarning(),"Enter your password warning is not shown");
	}

	
}
