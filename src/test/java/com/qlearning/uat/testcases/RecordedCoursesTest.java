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
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.RecordedCourseDetailsPage;
import com.qlearning.uat.pages.RecordedCoursePricingPage;
import com.qlearning.uat.pages.RecordedCoursesPage;
import com.qlearning.uat.pages.ThumbnailAndIntroVideoPage;

public class RecordedCoursesTest extends Base {

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
		recordedCoursesPage = dashboardPage.clickOnCoursesOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(groups = { "smoke" })
	public void verifyRecordedCoursePageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://uat.qlearning.academy/courses/recorded");
	}

	@Test(groups = { "smoke" })
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

	@Test(groups = { "smoke" })
	public void verifyRecorededCourseSubmitForReview() {
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

		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();

		driver.findElement(By.linkText("Videos")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='+ Create New Chapter']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Chapter Name']")).sendKeys("chapter 1");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("(//h1[text()='chapter 1']/following-sibling::div)[2]")).click();
		driver.findElement(By.xpath("//button[text()='+ Create Assessment']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Assessment Name Here*']")).sendKeys("assessment 1");
		driver.findElement(By.xpath("//button[text()='+ Create New']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Question here*']")).sendKeys("q");
		driver.findElement(By.name("option1")).sendKeys("a");
		driver.findElement(By.name("option2")).sendKeys("b");
		driver.findElement(By.name("option3")).sendKeys("c");
		driver.findElement(By.name("option4")).sendKeys("d");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("(//select[@name='answer']//option)[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.linkText("FAQ")).click();
		driver.findElement(By.xpath("//button[text()='Create New']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("question")).sendKeys("what is an FAQ?");
		driver.findElement(By.name("answer")).sendKeys("Frequently Asked Questions");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Submit For Review']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
	}
}
