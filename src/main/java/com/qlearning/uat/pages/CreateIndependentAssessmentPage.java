package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlearning.uat.utils.Utilities;

public class CreateIndependentAssessmentPage {
	
	WebDriver driver;

	public CreateIndependentAssessmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Objects:
	
	@FindBy(tagName="input")
	private WebElement assessmentTitle;
	
	@FindBy(xpath="(//div[@class='tag-ajus mb-2']//select)[1]")
	private WebElement category;

	@FindBy(xpath="//option[text()='programming']")
	private WebElement programmingOption;
	
	@FindBy(xpath="(//div[@class='tag-ajus mb-2']//select)[2]")
	private WebElement subCategory;
	
	@FindBy(xpath="//option[text()='python']")
	private WebElement pythonOption;
	
	@FindBy(xpath="(//div[@class='tag-ajus']//select)[2]")
	private WebElement feeDropDown;
	
	@FindBy(xpath="//option[text()='1000']")
	private WebElement selectFee;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextButton;
	
	//Actions:
	
	public void enterAssessmentTitle() {
		assessmentTitle.sendKeys("python Assessment"+Utilities.dynamicText());
	}
	
	public void selectCategory() {
		category.click();
		programmingOption.click();
	}
	
	public void selectSubCategory() {
		subCategory.click();
		pythonOption.click();
	}
	
	public void selectFeeOption() {
		feeDropDown.click();
		selectFee.click();
	}
	
	public IndependentAssessmentQAPage clickOnNextButton() {
		nextButton.click();
		return new IndependentAssessmentQAPage(driver);
	}
	
}
