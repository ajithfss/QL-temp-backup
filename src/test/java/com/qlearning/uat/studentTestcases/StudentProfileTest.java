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
import com.qlearning.uat.studentPages.StudentProfilePage;

public class StudentProfileTest extends StudentBase{
	
	public StudentProfileTest() {
		super();
	}
    
	public WebDriver driver;
	StudentLoginPage studentLoginPage;
	StudentDashboardPage studentDashboardPage;
	StudentProfilePage studentProfilePage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentLoginPage = studentHomePage.clickOnLoginOption();
		studentLoginPage.enterEmailAddress();
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		studentProfilePage = studentDashboardPage.clickOnProfile();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyStudentProfilePageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile");
	}
	
	@Test
	public void verifyFirstNameRequiredWarning() {
		studentProfilePage.clearFirstNameField();
		studentProfilePage.clickOnSaveChangesButton();
		Assert.assertTrue(studentProfilePage.retreiveFirstNameRequiredWarning());
	}
	
	@Test
    public void verifyLastNameRequiredWarning() {
    	studentProfilePage.clearLastNameField();
    	studentProfilePage.clickOnSaveChangesButton();
    	Assert.assertTrue(studentProfilePage.retreiveLastNameRequiredWarning());
	}
    
	@Test
    public void verifyAboutYouFieldRequiredWarning() {
    	studentProfilePage.clearAboutYouField();
    	studentProfilePage.clickOnSaveChangesButton();
    	Assert.assertTrue(studentProfilePage.retreiveAboutYouRequiredWarning());
    }
	
  // some changes need to be done 
//	@Test
 public void verifyMobileNumberRequiredWarning() {
    	studentProfilePage.clearMobileNumberField();
    	studentProfilePage.clickOnFacebookLink();
    	studentProfilePage.clickOnSaveChangesButton();
    	Assert.assertTrue(studentProfilePage.retreiveMobileNumberRequiredWarning());
    }
    
	
}
