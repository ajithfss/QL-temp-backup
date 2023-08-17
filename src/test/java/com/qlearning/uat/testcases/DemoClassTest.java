package com.qlearning.uat.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.DemoClassPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.RecordedCoursesPage;

public class DemoClassTest extends Base{
	
	public DemoClassTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	DemoClassPage demoClassPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		demoClassPage = dashboardPage.clickOnDemoClassOption();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups= {"smoke"})
	public void verifyDemoClassPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/demo-class");
	}
	
	@Test(groups= {"smoke"})
	public void verifyNavigationToDemoClassPage() {
		Assert.assertEquals(demoClassPage.retrieveDemoClassPageText(), "Demo Class");
	}

}
