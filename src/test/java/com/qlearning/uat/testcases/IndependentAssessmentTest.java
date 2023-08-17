package com.qlearning.uat.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.CreateIndependentAssessmentPage;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.IndependentAssessmentPage;
import com.qlearning.uat.pages.IndependentAssessmentQAPage;
import com.qlearning.uat.pages.LoginPage;

public class IndependentAssessmentTest extends Base{

	public IndependentAssessmentTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	IndependentAssessmentPage independentAssessmentPage;
	CreateIndependentAssessmentPage createIndependentAssessmentPage;
	IndependentAssessmentQAPage independentAssessmentQAPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		dashboardPage.clickOnCoursesOption();
		independentAssessmentPage = dashboardPage.clickOnIndependentAssessmentOption();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = {"smoke"})
	public void verifyAssessmentPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/courses/live/assessment");
	}

	@Test(groups = {"smoke"})
	public void verifyCreateIndependentAssessmentFunctionality() {
		createIndependentAssessmentPage = independentAssessmentPage.clickOnCreateNewAssessment();
		createIndependentAssessmentPage.enterAssessmentTitle();
		createIndependentAssessmentPage.selectCategory();
		createIndependentAssessmentPage.selectSubCategory();
		createIndependentAssessmentPage.selectFeeOption();
		independentAssessmentQAPage = createIndependentAssessmentPage.clickOnNextButton();
		independentAssessmentQAPage.clickOnCreateNewButton();
		independentAssessmentQAPage.enterQuestionAndOptions();
		independentAssessmentQAPage.chooseAnswer();
		independentAssessmentPage = independentAssessmentQAPage.clickOnSaveButton();
		Assert.assertTrue(independentAssessmentPage.retrieveEditButtonPresence(), "Assessment not created successfully");
			
	}
	
	@Test(groups = {"smoke"})
	public void verifyIndependentAssessmentSubmitForReview() {
		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Submit for review']")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}
	
}
