package com.qlearning.uat.studentPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentDashboardPage {


	WebDriver driver;

	public StudentDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//h1[text()='Learner Dashboard']")
	private WebElement learnersDashboardText;
	
	@FindBy(linkText="Profile")
	private WebElement profile;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchBox;
	
    @FindBy(xpath="//div[@id='root']/div[1]/nav[1]/div[1]/a[1]/div[1]")
    private WebElement homePageIcon;
	
	@FindBy(tagName="h2")
	private WebElement searchResults;
	
	@FindBy(xpath="//div[text()='Change Email']")
	private WebElement newFilterButton;
	
	//Actions:
	
	public Boolean retrieveLearnersDashboardText() {
		Boolean text = learnersDashboardText.isDisplayed();
		return text;
	}
	
	public StudentProfilePage clickOnProfile() {
		profile.click();
		return new StudentProfilePage(driver);
	}
	
	public void searchCourse() {
		searchBox.sendKeys("UAT TESTING");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
	
	}
	
	public Boolean retrieveSearchResults() {
		Boolean results = searchResults.isDisplayed();
		return results;
	}
	
	
	
	
	
}
