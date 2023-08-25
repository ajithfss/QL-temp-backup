package com.qlearning.uat.studentTestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.StudentBase;
import com.qlearning.uat.studentPages.StudentAccountSettingsPage;
import com.qlearning.uat.studentPages.StudentDashboardPage;
import com.qlearning.uat.studentPages.StudentHomePage;
import com.qlearning.uat.studentPages.StudentLoginPage;
import com.qlearning.uat.studentPages.StudentProfilePage;

public class StudentAccountSettingsTest extends StudentBase{

	public StudentAccountSettingsTest() {
		super();
	}
    
	public WebDriver driver;
	StudentLoginPage studentLoginPage;
	StudentDashboardPage studentDashboardPage;
	StudentProfilePage studentProfilePage;
	StudentAccountSettingsPage studentAccountSettingsPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentLoginPage = studentHomePage.clickOnLoginOption();
		studentLoginPage.enterEmailAddress();
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		studentProfilePage = studentDashboardPage.clickOnProfile();
		studentAccountSettingsPage = studentProfilePage.clickOnAccountSettingsTab();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyStudentAccountSettingsPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile");
	}
	
	@Test
	public void verifyNavigateToStudentAccountSettingsPageFunctionality() {
		Assert.assertTrue(studentAccountSettingsPage.retrieveAccountSettingsText(),"Student account settings  page is not displayed");
	}
	
	@Test
	public void verifyChangeEmailFunctionality() {

		studentAccountSettingsPage.clickOnEmailChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Email']")));
     	Assert.assertTrue(studentAccountSettingsPage.retrieveChangeEmailText(),"change email popup is not displayed");
	}
	
	
	@Test
	public void verifyChangePasswordFunctionality() {
		studentAccountSettingsPage.clickOnPasswordChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Password']")));
		Assert.assertTrue(studentAccountSettingsPage.retrieveChangePasswordText(),"change password popup is not displayed");
	}
	
	@Test
	public void verifyChangeMobileNumberFunctionality() {
		studentAccountSettingsPage.clickOnMobileNumberChangeButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Change Mobile Number']")));
		Assert.assertTrue(studentAccountSettingsPage.retrieveChangeMobileNumberPopup(), "change mobile number popup is not displayed");
	}
	
	@Test
	public void verifyAccountActivityDetails() {
		studentAccountSettingsPage.clickOnLoginActivityViewButton();
		Assert.assertTrue(studentAccountSettingsPage.retrieveLoginAlertsText(),"Login Alerts is not displayed");
		Assert.assertTrue(studentAccountSettingsPage.retrievePasswordUpdateText(),"Password Update is not displayed");
		Assert.assertTrue(studentAccountSettingsPage.retrieveEmailUpdateText(),"Email Update is not displayed");
		Assert.assertTrue(studentAccountSettingsPage.retrieveMobileNumberUpdateText(),"MobileNumberUpdate is not displayed");
	}
	
	
	@Test
	public void verifyDeleteAccountFunctionality() {
		studentAccountSettingsPage.clickOnDeactivateButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'text-center mb-2')]")));
		Assert.assertTrue(studentAccountSettingsPage.retrieveDeleteAccountText(), "Delete account popup is not displayed");
		
	}
}
