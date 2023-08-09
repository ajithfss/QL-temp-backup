package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveCoursesPage {

	WebDriver driver;

	public LiveCoursesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	@FindBy(xpath="//button[text()='+ Create New Course']")
	private WebElement createNewCourseButton;
	
	@FindBy(xpath="(//p[text()='Edit'])[1]")
	private WebElement editButton;
	
	//Actions:
	
	public LiveCourseDetailsPage clickOnCreateNewCourseButton() {
		createNewCourseButton.click();
		return new LiveCourseDetailsPage(driver);
	}
	
	public Boolean retrieveEditButtonPresence() {
		Boolean edit = editButton.isDisplayed();
		return edit;
	}
}
