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

public class DashboardTest extends Base{
	
	public DashboardTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//@Test(groups= {"smoke"})
	public void verifyDashboardLogoutOption() {
		dashboardPage.clickOnDashboardLogoutOption();
	}
	
	@Test(groups= {"smoke"})
	public void verifyWithdrawPopupDisplay() {
		dashboardPage.clickOnWithdrawOption();
		Assert.assertTrue(dashboardPage.retrieveWithdrawAmountPage());
		
	}

}
