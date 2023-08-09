package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	@FindBy(className="login-btn")
	private WebElement loginOption;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement createAccountOption;
	
	//Actions:
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectCreateAccount() {
		createAccountOption.click();
		return new RegisterPage(driver);
	}

}
