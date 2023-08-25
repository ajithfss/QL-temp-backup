package com.qlearning.uat.studentTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.StudentBase;
import com.qlearning.uat.studentPages.StudentDashboardPage;
import com.qlearning.uat.studentPages.StudentHomePage;
import com.qlearning.uat.studentPages.StudentLoginPage;

public class StudentLoginTest extends StudentBase{
	
	public StudentLoginTest() {
		super();
	}
	
	public WebDriver driver;
	StudentLoginPage studentLoginPage;
	StudentDashboardPage studentDashboardPage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentLoginPage = studentHomePage.clickOnLoginOption();	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyStudentLoginUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/student-login");
	}
	@Test
	public void verifyLoginWithValidCredentials() {
		studentLoginPage.enterEmailAddress();
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		Assert.assertTrue(studentDashboardPage.retrieveLearnersDashboardText(),"login is not successful");
	
	}
    @Test
	public void verifyEnterEmailWarning() {
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		Assert.assertTrue(studentLoginPage.retrieveEnterEmailWarning(), "enter email warning is not displayed");
	}
    
    @Test
	public void verifyEnterPasswordWarning() {
		studentLoginPage.enterEmailAddress();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		Assert.assertTrue(studentLoginPage.retrieveEnterPasswordWarning(), "enter password warning is not displayed");
	}
	

}
