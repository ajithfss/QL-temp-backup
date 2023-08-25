package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentNotificationSettingsPage {

	WebDriver driver;

	public StudentNotificationSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Object:
	
	@FindBy(xpath="//p[text()='Email Notifications']")
	private WebElement emailNotifyText;
	
	@FindBy(xpath="//p[text()='App Push Notifications']")
	private WebElement appPushNotifyText;
	
	//Actions:
	
	public Boolean retreiveEmailNotifyText() {
		Boolean text = emailNotifyText.isDisplayed();
		return text;
	}
	
	public Boolean retreiveAppPushNotifyText() {
		Boolean text = appPushNotifyText.isDisplayed();
		return text;
	}
}
