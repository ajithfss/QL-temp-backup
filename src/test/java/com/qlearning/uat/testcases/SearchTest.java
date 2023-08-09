package com.qlearning.uat.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;

public class SearchTest extends Base{
	public SearchTest() {
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
    @Test
	public void verifySearchFunctionality() {
    	System.out.println("search functionality is called");
//    	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("selenium");
//    	driver.findElement(By.xpath("//span[text()='SELENIUM PYTHON WITH BEHAVE BDD(BASIC + ADVANCE + ARCHITECT)']")).click();
//    	Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='SELENIUM PYTHON WITH BEHAVE BDD(BASIC + ADVANCE + ARCHITECT)']")).isDisplayed());
	}
}
