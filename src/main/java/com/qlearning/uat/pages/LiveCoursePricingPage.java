package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveCoursePricingPage {

	WebDriver driver;

	public LiveCoursePricingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="(//div[@class='tag-ajus']//select)[2]")
	private WebElement feeDropDown;
	
	@FindBy(xpath="//option[text()='1000']")
	private WebElement courseFee;
	
	@FindBy(id="change_image")
	private WebElement thumbnail;
	
	@FindBy(id="change_video")
	private WebElement introVideo;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	private WebElement nextButton;
	
	//Actions:
	
	public void selectFee() {
		feeDropDown.click();
		courseFee.click();
	}
	
	public void uploadThumnail() {
		String projectPath = System.getProperty("user.dir");
		thumbnail.sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
	}
	
	public void uploadIntroVideo() {
		String projectPath = System.getProperty("user.dir");
		introVideo.sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
	}
	
	public LiveCourseTimeDurationPage clickOnNextButton() {
		nextButton.click();
		return new LiveCourseTimeDurationPage(driver);
	}
}
