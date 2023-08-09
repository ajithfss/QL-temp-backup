package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecordedCoursePricingPage {

	WebDriver driver;

	public RecordedCoursePricingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(name="fee")
	private WebElement feeDropDown;
	
	@FindBy(xpath="//option[text()='999']")
	private WebElement courseFee;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextButton;
	
	//Actions:
	
	public void selectFee() {
		feeDropDown.click();
		courseFee.click();
	}
	
	public ThumbnailAndIntroVideoPage clickOnNextButton() {
		nextButton.click();
		return new ThumbnailAndIntroVideoPage(driver);
	}
}
