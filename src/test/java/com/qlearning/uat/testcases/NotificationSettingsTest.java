package com.qlearning.uat.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.NotificationSettingsPage;
import com.qlearning.uat.pages.ProfilePage;

public class NotificationSettingsTest extends Base{
	
	public NotificationSettingsTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfilePage profilePage;
	NotificationSettingsPage notificationSettingsPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		profilePage = dashboardPage.clickOnInstructorProfileIcon();
		notificationSettingsPage = profilePage.clickOnNotificationsPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(groups= {"smoke"})
	public void verifyNotificationSettingsPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile/teacher/teacher-profile");
	}
	
	@Test(groups= {"smoke"})
	public void verifyEmailandAppPushNotifications() {
		Assert.assertTrue(notificationSettingsPage.retreiveEmailNotifyText());
		Assert.assertTrue(notificationSettingsPage.retreiveAppPushNotifyText());
	}
	
	
}
