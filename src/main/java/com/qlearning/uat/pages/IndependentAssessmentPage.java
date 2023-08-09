package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndependentAssessmentPage {

	WebDriver driver;

	public IndependentAssessmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//button[text()='+ Create New Assessment']")
	private WebElement createNewAssessment;
	
	@FindBy(xpath="(//p[text()='Edit'])[1]")
	private WebElement editButton;
	
	//Actions:
	
	public CreateIndependentAssessmentPage clickOnCreateNewAssessment() {
		createNewAssessment.click();
		return new CreateIndependentAssessmentPage(driver);
	}
	
	public Boolean retrieveEditButtonPresence() {
		Boolean edit = editButton.isDisplayed();
		return edit;
	}
	
}
