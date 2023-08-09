package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecordedCoursesPage {

	WebDriver driver;

	public RecordedCoursesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	@FindBy(xpath="//span[text()='Recorded Courses']")
	private WebElement recordedCoursesText;
	
	@FindBy(xpath="//button[text()='+ Create New Course']")
	private WebElement createNewCourseButton;
	
	@FindBy(xpath="(//p[text()='Edit'])[1]")
	private WebElement editButton;
	
	//Actions
	public RecordedCourseDetailsPage clickOnCreateNewCourseButton() {
		createNewCourseButton.click();
		return new RecordedCourseDetailsPage(driver);
	}
	
	public Boolean retrieveEditButton() {
		Boolean edit = editButton.isDisplayed();
		return edit;
	}
	
}
