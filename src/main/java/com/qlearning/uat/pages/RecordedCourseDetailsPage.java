package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecordedCourseDetailsPage {

	WebDriver driver;

	public RecordedCourseDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(name="courseName")
	private WebElement courseTitle;
	
	@FindBy(css="div.App div.container-fluid div.row div.col div.container div.d-block:nth-child(1) div.login-col div.quill.rich-h:nth-child(5) div.ql-container.ql-snow div.ql-editor.ql-blank > p:nth-child(1)")
	private WebElement courseOverview;
	
	@FindBy(name="catogory")
	private WebElement category;
	
	@FindBy(xpath="//option[text()='programming']")
	private WebElement programming;
	
	@FindBy(xpath="(//div[@class='tag-ajus mb-2']//select)[2]")
	private WebElement subCategory;
	
	@FindBy(xpath="//option[text()='python']")
	private WebElement python;
	
	@FindBy(xpath="//div[text()='Next']")
	private WebElement nextButton;
	
	
	//Actions:
	
	public void enterCourseTitle() {
		courseTitle.sendKeys("UAT testing");
	}
	
	public void enterCourseOverview() {
		
		courseOverview.sendKeys("User Acceptance Testing (UAT), or application testing, is the final stage of any software development or change request lifecycle before go-live. UAT meaning the final stage of any development process to determine that the software does what it was designed to do in real-world situations.");
	}
	
	public void selectCategory() {
		category.click();
		programming.click();
	}
	
	public void selectSubCategory() {
		subCategory.click();
		python.click();
	}
	
	public RecordedCoursePricingPage clickOnNextButton() {
		nextButton.click();
		return new RecordedCoursePricingPage(driver);
	}
	
	
	
	
	
	
	
}
