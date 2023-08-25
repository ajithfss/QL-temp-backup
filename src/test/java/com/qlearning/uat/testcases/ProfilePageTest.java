package com.qlearning.uat.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.ProfilePage;

public class ProfilePageTest extends Base{
 
	public ProfilePageTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfilePage profilePage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		profilePage = dashboardPage.clickOnInstructorProfileIcon();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups= {"smoke"})
	public void verifyProfilePageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile/teacher/teacher-profile");
	}
	
	
	@Test(groups = {"smoke"})
	public void verifyNavigateToProfilePageFunctionality() {
		Assert.assertTrue(profilePage.retrieveProfilePageText(),"profile page not displayed");
	}
	
	
	//need to implement dynamic changes in categories of expertise field:
	@Test(groups = {"smoke"})
	public void verifyProfileEditFunctionality() {
		profilePage.enterFirstName();
		profilePage.enterMiddleName();
		profilePage.enterLastName();
		profilePage.enterDescription();
		profilePage.enterExperience();
		profilePage.enterCategoriesOfExpertise();
		profilePage.enterAvailableInaWeek();
		profilePage.enterAvailableTimeFrom();
		profilePage.enterAvailableTimeTo();
		profilePage.clickOnSaveChangesButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Successfully Submitted Profile']")));
		String successMsg = profilePage.retrieveProfileUpdatedSuccessText();
		Assert.assertEquals(successMsg,"Successfully Submitted Profile");
		profilePage.clickOnProfileUpdatedSuccessButton();		
	}
	
	@Test(groups = {"smoke"})
	public void verifyFirstNameRequiredWarning() {
		profilePage.clearFirstNameField();
		profilePage.clickOnSaveChangesButton();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Please fill this field']")));
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");
	}
	
	@Test(groups = {"smoke"})
	public void VerifyLastNameRequiredWarning() {
		
		profilePage.clearLastNameField();
		profilePage.clickOnSaveChangesButton();
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");		
	}
	
	@Test(groups = {"smoke"})
	public void verifyAboutYouFieldWarning() {
		profilePage.clearAboutYouField();
		profilePage.clickOnSaveChangesButton();
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");
	}
	
	@Test(groups = {"smoke"})
	public void verifyExperienceFieldWarning() {
		profilePage.clearExperienceField();
		profilePage.clickOnSaveChangesButton();
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");
	}
	
	@Test(groups = {"smoke"})
	public void verifyCategoriesOfExpertiseWarning() {
		profilePage.clickOnSaveChangesButton();
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");		
	}
	
	
	@Test(groups = {"smoke"})
	public void verifyAvailableInaWeekFieldWarning() {
		profilePage.clearAvailableInaWeekField();
		profilePage.clickOnSaveChangesButton();
		String warningMsg = profilePage.retrievefillFieldWarning();
		Assert.assertEquals(warningMsg, "Please fill this field");	
	}
	
	

	
	
	@Test(groups= {"regression"})
	public void verifySocialMediaLinks() {
		profilePage.enterFacebookLink();
		profilePage.enterInstagramLink();
		profilePage.enterLinkedinLink();
		profilePage.enterTwitterLink();
		profilePage.clickOnSaveChangesButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Successfully Submitted Profile']")));
		String successMsg = profilePage.retrieveProfileUpdatedSuccessText();
		Assert.assertEquals(successMsg,"Successfully Submitted Profile");
		profilePage.clickOnProfileUpdatedSuccessButton();	
		
	}
	
	@Test(groups= {"regression"})
	public void verifyInvalidFaceBookUrl() {
		profilePage.editFacebookLink();
		String warning  = profilePage.retrieveInvalidWarning();
		Assert.assertEquals(warning, "Invalid");	
	}
	
	@Test(groups= {"regression"})
	public void verifyInvalidInstagramUrl() {
		profilePage.editInstagramLink();
		String warning  = profilePage.retrieveInvalidWarning();
		Assert.assertEquals(warning, "Invalid");	
	}
	
	@Test(groups= {"regression"})
	public void verifyInvalidLinkedinUrl() {
		profilePage.editLinkedinLink();
		String warning  = profilePage.retrieveInvalidWarning();
		Assert.assertEquals(warning, "Invalid");	
	}
	
	@Test(groups= {"regression"})
	public void verifyInvalidTwitterUrl() {
		profilePage.editTwitterLink();
		String warning  = profilePage.retrieveInvalidWarning();
		Assert.assertEquals(warning, "Invalid");	
	}
	
}
