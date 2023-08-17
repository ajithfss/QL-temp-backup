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
import com.qlearning.uat.pages.MessagesPage;

public class MessagesTest extends Base{

	public MessagesTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MessagesPage messagesPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		messagesPage = dashboardPage.clickOnMessagesOption();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
    
	@Test(groups={"smoke"})
	public void verifyMessagesPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/messages");
	}
	
	@Test(groups={"smoke"})
	public void verifyMessagesDisplay() {
		Assert.assertTrue(messagesPage.retreiveMessages(), "messages not displayed");
	}

}
