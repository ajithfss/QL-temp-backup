package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoClassPage {

	WebDriver driver;

	public DemoClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Objects:

	@FindBy(xpath = "(//span[text()='Demo Class'])[2]")
	private WebElement demoClassPageText;

    //Actions:

	public String retrieveDemoClassPageText() {
		String text = demoClassPageText.getText();
		return text;
	}

}