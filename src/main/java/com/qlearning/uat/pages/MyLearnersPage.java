package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLearnersPage {
	
WebDriver driver;
	
	public MyLearnersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Object:
	
	@FindBy(xpath="(//span[text()='My Learners'])[2]")
	private WebElement myLearners;

	//Actions:
	
	public Boolean retrieveDisplayOfMylearners() {
		Boolean learners = myLearners.isDisplayed();
		return learners;
	}
}
