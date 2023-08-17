package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagesPage {


	WebDriver driver;

	public MessagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//span[text()='Messages']")
	private WebElement messages;
	
	//Actions:
	
	public Boolean retreiveMessages() {
		Boolean message = messages.isDisplayed();
		return message;
	}
}
