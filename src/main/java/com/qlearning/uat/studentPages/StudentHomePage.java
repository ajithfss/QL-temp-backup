package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {
	
WebDriver driver;
	
	public StudentHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement loginOption;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement createAccountOption;
	
	
	private WebElement assessmentExploreButton;
	
	//Actions:
	
	public StudentLoginPage clickOnLoginOption() {
		loginOption.click();
		return new StudentLoginPage(driver);	
	}
	
	public StudentRegistrationPage clickOnCreateAccountOption() {
		createAccountOption.click();
		return new StudentRegistrationPage(driver);
	}

}
