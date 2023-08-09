package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationSettingsPage {

	WebDriver driver;

	public NotificationSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//p[text()='Email Notifications']")
	private WebElement emailNotifyText;
	
	@FindBy(xpath="//p[text()='App Push Notifications']")
	private WebElement appPushNotifyText;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	private WebElement promotionsEmailCheckBox;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	private WebElement studentCourseCompletionEmailCheckBox;
	
	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	private WebElement subscriptionNewsLetterEmailCheckBox;
	
	@FindBy(xpath="(//label[text()='Subcription & Newsletter']/following::input)[1]")
	private WebElement promotionsAppCheckBox;
	
	@FindBy(xpath="((//label[text()='Promotions and Recommendation from QLearning'])[2]/following::input)[1]")
	private WebElement studentCourseCompletionAppCheckBox;
	
	@FindBy(xpath="((//label[text()='Student Course Completion'])[2]/following::input)[1]")
	private WebElement subscriptionNewsLetterAppCheckBox;
	
}
