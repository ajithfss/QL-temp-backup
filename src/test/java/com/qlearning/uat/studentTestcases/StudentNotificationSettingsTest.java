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
import com.qlearning.uat.studentPages.StudentNotificationSettingsPage;
import com.qlearning.uat.studentPages.StudentProfilePage;

public class StudentNotificationSettingsTest extends StudentBase{

	public StudentNotificationSettingsTest() {
		super();
	}
    
	public WebDriver driver;
	StudentLoginPage studentLoginPage;
	StudentDashboardPage studentDashboardPage;
	StudentProfilePage studentProfilePage;
	StudentNotificationSettingsPage studentNotificationSettingsPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentLoginPage = studentHomePage.clickOnLoginOption();
		studentLoginPage.enterEmailAddress();
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		studentProfilePage = studentDashboardPage.clickOnProfile();
		studentNotificationSettingsPage = studentProfilePage.clickOnNotificationSettingsTab();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyStudentNotificationSettingsPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile");
	}
	
	@Test
	public void verifyEmailandAppPushNotifications() {
		Assert.assertTrue(studentNotificationSettingsPage.retreiveEmailNotifyText());
		Assert.assertTrue(studentNotificationSettingsPage.retreiveAppPushNotifyText());
	}
}
