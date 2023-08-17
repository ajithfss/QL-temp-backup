package com.qlearning.uat.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LiveCourseDetailsPage;
import com.qlearning.uat.pages.LiveCoursePricingPage;
import com.qlearning.uat.pages.LiveCourseTimeDurationPage;
import com.qlearning.uat.pages.LiveCoursesPage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.RecordedCoursesPage;

public class LiveCoursesTest extends Base {

	public LiveCoursesTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RecordedCoursesPage recordedCoursesPage;
	LiveCoursesPage liveCoursesPage;
	LiveCourseDetailsPage liveCourseDetailsPage;
	LiveCoursePricingPage liveCoursePricingPage;
	LiveCourseTimeDurationPage liveCourseTimeDurationPage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		dashboardPage.clickOnCoursesOption();
		liveCoursesPage = dashboardPage.clickOnLiveCoursesOption();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups= {"smoke"})
	public void verifyLiveCoursePageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/courses/live");
	}
	
	@Test(groups= {"smoke"})
	public void verifyCreateLiveCourseFunctionality() { 
		liveCourseDetailsPage = liveCoursesPage.clickOnCreateNewCourseButton();
		liveCourseDetailsPage.enterCourseTitle();
		liveCourseDetailsPage.enterCourseOverview();
		liveCourseDetailsPage.selectCategory();
		liveCourseDetailsPage.selectSubCategory();
		liveCoursePricingPage = liveCourseDetailsPage.clickOnNextButton();
		liveCoursePricingPage.selectFee();
		liveCoursePricingPage.uploadThumnail();
		liveCoursePricingPage.uploadIntroVideo();
		liveCourseTimeDurationPage = liveCoursePricingPage.clickOnNextButton();
		liveCourseTimeDurationPage.selectCourseDuration();
		liveCourseTimeDurationPage.selectCourseStartDate();
		liveCourseTimeDurationPage.fillClassTime();
		liveCoursesPage = liveCourseTimeDurationPage.clickOnCreateButton();
		Assert.assertTrue(liveCoursesPage.retrieveEditButtonPresence(), "live course not created successfully");
		
	}
	@Test
	public void verifyLiveCourseSubmitForReview() {
//		liveCourseDetailsPage = liveCoursesPage.clickOnCreateNewCourseButton();
//		liveCourseDetailsPage.enterCourseTitle();
//		liveCourseDetailsPage.enterCourseOverview();
//		liveCourseDetailsPage.selectCategory();
//		liveCourseDetailsPage.selectSubCategory();
//		liveCoursePricingPage = liveCourseDetailsPage.clickOnNextButton();
//		liveCoursePricingPage.selectFee();
//		liveCoursePricingPage.uploadThumnail();
//		liveCoursePricingPage.uploadIntroVideo();
//		liveCourseTimeDurationPage = liveCoursePricingPage.clickOnNextButton();
//		liveCourseTimeDurationPage.selectCourseDuration();
//		liveCourseTimeDurationPage.selectCourseStartDate();
//		liveCourseTimeDurationPage.fillClassTime();
//		liveCoursesPage = liveCourseTimeDurationPage.clickOnCreateButton();
//		Assert.assertTrue(liveCoursesPage.retrieveEditButtonPresence(), "live course not created successfully");
		
		
		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Submit For Review']")).click();
	}
}
