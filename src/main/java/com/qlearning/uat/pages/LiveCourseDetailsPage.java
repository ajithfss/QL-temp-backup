package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlearning.uat.utils.Utilities;

public class LiveCourseDetailsPage {

	WebDriver driver;

	public LiveCourseDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Objects:
	@FindBy(xpath = "//label[text()='Course Title']/following-sibling::input")
	private WebElement courseTitle;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/p[1]")
	private WebElement courseOverview;

	@FindBy(xpath = "(//div[@class='tag-ajus mb-2']//select)[1]")
	private WebElement category;

	@FindBy(xpath = "//option[text()='programming']")
	private WebElement programmingOption;

	@FindBy(xpath = "(//div[@class='tag-ajus mb-2']//select)[2]")
	private WebElement subCategory;

	@FindBy(xpath = "//option[text()='python']")
	private WebElement pythonOption;

	@FindBy(xpath = "(//button[text()='Next'])[1]")
	private WebElement nextButton;

	// Actions:

	public void enterCourseTitle() {
		courseTitle.sendKeys("PYTHON LIVE COURSE"+Utilities.dynamicText());
	}

	public void enterCourseOverview() {
		courseOverview.sendKeys(
				"Identify core aspects of programming and features of the Python language.Understand and apply core programming concepts like data structures, conditionals, loops, variables, and functions");
	}

	public void selectCategory() {
		category.click();
		programmingOption.click();
	}

	public void selectSubCategory() {
		subCategory.click();
		pythonOption.click();
	}

	public LiveCoursePricingPage clickOnNextButton() {
		nextButton.click();
		return new LiveCoursePricingPage(driver);
	}
}
