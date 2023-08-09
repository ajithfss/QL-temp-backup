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
import com.qlearning.uat.pages.RecordedCourseDetailsPage;
import com.qlearning.uat.pages.RecordedCoursePricingPage;
import com.qlearning.uat.pages.RecordedCoursesPage;
import com.qlearning.uat.pages.ThumbnailAndIntroVideoPage;

public class RecordedCoursesTest extends Base{

	public RecordedCoursesTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RecordedCoursesPage recordedCoursesPage;
	RecordedCourseDetailsPage recordedCourseDetailsPage;
	RecordedCoursePricingPage recordedCoursePricingPage;
	ThumbnailAndIntroVideoPage thumbnailAndIntroVideoPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		recordedCoursesPage =  dashboardPage.clickOnCoursesOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = {"smoke"} )
	public void verifyCreateRecordedCourseFunctionality() {
		recordedCourseDetailsPage = recordedCoursesPage.clickOnCreateNewCourseButton();
		recordedCourseDetailsPage.enterCourseTitle();
		recordedCourseDetailsPage.enterCourseOverview();
		recordedCourseDetailsPage.selectCategory();
		recordedCourseDetailsPage.selectSubCategory();
		recordedCoursePricingPage = recordedCourseDetailsPage.clickOnNextButton();
		recordedCoursePricingPage.selectFee();
		thumbnailAndIntroVideoPage = recordedCoursePricingPage.clickOnNextButton();
		thumbnailAndIntroVideoPage.uploadThumbnail();
		thumbnailAndIntroVideoPage.uploadIntroVideo();
		recordedCoursesPage = thumbnailAndIntroVideoPage.clickOnCreateCourseButton();
		Assert.assertTrue(recordedCoursesPage.retrieveEditButton(), "Course is not created successfully");	
	}
	
	
}
