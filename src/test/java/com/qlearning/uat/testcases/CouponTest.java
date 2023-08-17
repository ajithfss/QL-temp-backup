package com.qlearning.uat.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.CouponPage;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.ProfilePage;
import com.qlearning.uat.utils.Utilities;

 class CouponTest extends Base{

	public CouponTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfilePage profilePage;
	CouponPage couponPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		profilePage = dashboardPage.clickOnInstructorProfileIcon();
		couponPage = profilePage.clickOnCouponPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyCouponPageUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://uat.qlearning.academy/profile/teacher/teacher-profile");
	}
	
	@Test
	 public void verifyCouponCreationFunctionality() {
		 
		 WebDriver driver = new ChromeDriver();
			driver.findElement(By.xpath("(//img[@alt='Profile Image'])[2]")).click();
			driver.findElement(By.linkText("Coupon")).click();
			driver.findElement(By.name("couponName")).sendKeys("Test10");
			driver.findElement(By.tagName("select")).click();
			driver.findElement(By.xpath("//option[text()='10%']")).click();
			driver.findElement(By.name("noOfCoupon")).sendKeys("10");
			driver.findElement(By.name("startDate")).sendKeys("09-08-2023");
			driver.findElement(By.name("expiryDate")).sendKeys("09-09-2023");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 }
	
	
}
