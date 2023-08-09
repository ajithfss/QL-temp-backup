package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndependentAssessmentQAPage {

	WebDriver driver;

	public IndependentAssessmentQAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Objects:
	
	@FindBy(xpath="//button[text()='+ Create New']")
	private WebElement createNewButton;
	
	@FindBy(name="question")
	private WebElement question;
	
	@FindBy(name="option1")
	private WebElement option1;
	
	@FindBy(name="option2")
	private WebElement option2;
	
	@FindBy(name="option3")
	private WebElement option3;
	
	@FindBy(name="option4")
	private WebElement option4;
	
	@FindBy(tagName="select")
	private WebElement answerDropDown;
	
	@FindBy(xpath="(//select[@name='answer']//option)[2]")
	private WebElement selectAnswer;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	//Actions:
	
	public void clickOnCreateNewButton() {
		createNewButton.click();
	}
	
	public void enterQuestionAndOptions() {
		question.sendKeys("Who developed the Python language?");
		option1.sendKeys("Zim Den");
		option2.sendKeys("Guido van Rossum");
		option3.sendKeys("Niene Stom");
		option4.sendKeys("Wick van Rossum");
	}
	
	public void chooseAnswer() {
		answerDropDown.click();
		selectAnswer.click();
	}
	
	public IndependentAssessmentPage clickOnSaveButton() {
		saveButton.click();
		return new IndependentAssessmentPage(driver);
	}
	
	
}
