package com.qlearning.uat.studentTestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.StudentBase;
import com.qlearning.uat.studentPages.StudentDashboardPage;
import com.qlearning.uat.studentPages.StudentHomePage;
import com.qlearning.uat.studentPages.StudentLoginPage;

public class StudentDashboardTest extends StudentBase{

	public StudentDashboardTest() {
		super();
	}
    
	public WebDriver driver;
	StudentLoginPage studentLoginPage;
	StudentDashboardPage studentDashboardPage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		StudentHomePage studentHomePage = new StudentHomePage(driver);
		studentLoginPage = studentHomePage.clickOnLoginOption();
		studentLoginPage.enterEmailAddress();
		studentLoginPage.enterPassword();
		studentDashboardPage = studentLoginPage.clickOnLoginButton();
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	@Test
	public void verifyCourseSearchFunctionality() {
		studentDashboardPage.searchCourse();
		Assert.assertTrue(studentDashboardPage.retrieveSearchResults(),"search results not displayed");
	}
	
	@Test
	public void verifyAssessmentSearchFunctionality() {
		//driver.findElement(By.className("position-relative")).click();
		driver.findElement(By.xpath("//div[@id='root']/div[1]/nav[1]/div[1]/a[1]/div[1]")).click();
		driver.findElement(By.linkText("Explore All")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'btn align-content-end')])[1]")).click();
	}
	
	@Test
	public void verifyCourseSearchAndAddToCartFunctionality() {
		studentDashboardPage.searchCourse();
		driver.findElement(By.xpath("//button[text()='New']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//img[@class='rounded-3'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		String text = driver.findElement(By.xpath("//div[text()='Added to Cart']")).getText();
		Assert.assertEquals(text,"Added to Cart");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
	}
	
	@Test
	public void verifyCourseSearchAndAddToWishListFunctionality() {
		studentDashboardPage.searchCourse();
		driver.findElement(By.xpath("//button[text()='New']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//img[@class='rounded-3'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Add to Wishlist']")).click();
		Boolean text = driver.findElement(By.xpath("//div[text()='Added to Wishlist']")).isDisplayed();
		Assert.assertTrue(text);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("(//a[@class='me-lg-4 position-relative'])[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='rounded-3 card-image']")));
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		
	}
	
	public void verifyCourseRequestForDemoFunctionality() {
		
	}
	
	public void verifyCourseSearchAndBuyNowFunctionality() {
		
	}
	
}
