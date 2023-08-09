package com.qlearning.uat.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveCourseTimeDurationPage {

	WebDriver driver;

	public LiveCourseTimeDurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="(//div[@class='tag-ajus']//select)[3]")
	private WebElement courseDurationDropDown;
	
	@FindBy(xpath="//option[text()='1 month']")
	private WebElement monthOption;
	
	@FindBy(xpath="//input[@type='date']")
	private WebElement fromDate;
	
	@FindBy(id="sunday")
	private WebElement sundayCheckBox;
	
	@FindBy(id="monday")
	private WebElement mondayCheckBox;
	
	@FindBy(id="tuesday")
	private WebElement tuesdayCheckBox;
	
	@FindBy(id="wednesday")
	private WebElement wednesdayCheckBox;
	
	@FindBy(id="thursday")
	private WebElement thursdayCheckBox;
	
	@FindBy(id="friday")
	private WebElement fridayCheckBox;
	
	@FindBy(id="saturday")
	private WebElement saturdayCheckBox;
	
	@FindBy(xpath="(//input[@name='startTime'])[1]")
	private WebElement sundayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[1]")
	private WebElement sundayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[2]")
    private WebElement mondayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[2]")
	private WebElement mondayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[3]")
    private WebElement tuesdayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[3]")
	private WebElement tuesdayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[4]")
    private WebElement wednesdayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[4]")
	private WebElement wednesdayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[5]")
    private WebElement thursdayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[5]")
	private WebElement thursdayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[6]")
    private WebElement fridayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[6]")
	private WebElement fridayToTime;
	
	@FindBy(xpath="(//input[@name='startTime'])[7]")
    private WebElement saturdayFromTime;
	
	@FindBy(xpath="(//input[@name='endTime'])[7]")
	private WebElement saturdayToTime;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement createButton;
	
	//Actions:
	
	public void selectCourseDuration() {
		courseDurationDropDown.click();
		monthOption.click();
	}
	
	public void selectCourseStartDate() {
		fromDate.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	 public void fillClassTime() {
		 sundayCheckBox.click();
		 sundayFromTime.sendKeys("1000");
		 sundayToTime.sendKeys("1200");
		 mondayCheckBox.click();
		 mondayFromTime.sendKeys("1000");
		 mondayToTime.sendKeys("1200");
		 tuesdayCheckBox.click();
		 tuesdayFromTime.sendKeys("1000");
		 tuesdayToTime.sendKeys("1200");
		 wednesdayCheckBox.click();
		 wednesdayFromTime.sendKeys("1000");
		 wednesdayToTime.sendKeys("1200");
		 thursdayCheckBox.click();
		 thursdayFromTime.sendKeys("1000");
		 thursdayToTime.sendKeys("1200");
		 fridayCheckBox.click();
		 fridayFromTime.sendKeys("1000");
		 fridayToTime.sendKeys("1200");
		 saturdayCheckBox.click();
		 saturdayFromTime.sendKeys("1000");
		 saturdayToTime.sendKeys("1200");
	 }
	 
	 public LiveCoursesPage clickOnCreateButton() {
		 createButton.click();
		 return new LiveCoursesPage(driver);
	 }
	
}
