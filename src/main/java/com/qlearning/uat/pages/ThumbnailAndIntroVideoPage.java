package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThumbnailAndIntroVideoPage {

	WebDriver driver;

	public ThumbnailAndIntroVideoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(id="change_image")
	private WebElement thumbnail;
	
	@FindBy(id="change_video")
	private WebElement introVideo;
	
	@FindBy(xpath="//button[text()='Create Course']")
	private WebElement createCourseButton;
	
	//Actions:
	
	public void uploadThumbnail() {
		String projectPath = System.getProperty("user.dir");
		thumbnail.sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
	}
	
	public void uploadIntroVideo() {
		String projectPath = System.getProperty("user.dir");
		introVideo.sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
	}
	
	public RecordedCoursesPage clickOnCreateCourseButton() {
		createCourseButton.click();
		return new RecordedCoursesPage(driver);
	}
}
