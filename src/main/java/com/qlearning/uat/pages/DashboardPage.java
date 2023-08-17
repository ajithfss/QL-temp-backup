package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
 WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Object
	@FindBy(xpath="//span[text()='Instructor Dashboard']")
	private WebElement instructorDashboard;
	
	@FindBy(xpath="//button[text()='Courses']")
	private WebElement coursesOption;
	
	@FindBy(linkText="Live Courses")
	private WebElement liveCourse;
	
	@FindBy(linkText="Assessments")
	private WebElement independentAssessment;
	
	@FindBy(xpath="//h5[text()='Current Balance']")
	private WebElement currentBalance;
	
	@FindBy(xpath="//h5[text()='Total Revenue']")
	private WebElement totalRevenue;
	
	@FindBy(xpath="//h5[text()='Total Enrollments']")
	private WebElement totalEnrollments;
	
	@FindBy(xpath="//h5[text()='Total Learners']")
	private WebElement totalLearners;
	
	@FindBy(linkText="Transactions History")
	private WebElement transactionsHistory;
	
	@FindBy(linkText="Purchase List")
	private WebElement purchaseList;
	
	@FindBy(xpath="(//a[@href='/student-home'])[2]")
	private WebElement becomeAstudent;
	
	@FindBy(xpath="(//a[contains(@class,'notification mx-lg-4')])[2]")
	private WebElement notificationIcon;
	
	@FindBy(xpath="(//img[@alt='Profile Image'])[2]")
	private WebElement instructorProfileIcon;
	
	@FindBy(xpath="(//span[text()='Demo Class'])[1]")
	private WebElement demoClassOption;
	
	@FindBy(xpath="(//span[text()='My Learners'])[1]")
	private WebElement myLearnersOption;
	
	@FindBy(xpath="//span[text()=' Messages']")
	private WebElement messagesOption;
	
	
	//Actions
	public boolean getDisplayStatusOfInstructorDashboard() {
		boolean displayStatus = instructorDashboard.isDisplayed();
		return displayStatus;
	}
	
	public ProfilePage clickOnInstructorProfileIcon() {
		instructorProfileIcon.click();
		return new ProfilePage(driver);
	} 
	
	public RecordedCoursesPage clickOnCoursesOption() {
		coursesOption.click();
		return new RecordedCoursesPage(driver);	
	}
	
	public LiveCoursesPage clickOnLiveCoursesOption() {
		liveCourse.click();
		return new LiveCoursesPage(driver);
	}
	
	public IndependentAssessmentPage clickOnIndependentAssessmentOption() {
		independentAssessment.click();
		return new IndependentAssessmentPage(driver);
	}
	
	public DemoClassPage clickOnDemoClassOption() {
		demoClassOption.click();
		return new DemoClassPage(driver);
	}
	
	public MyLearnersPage clickOnMyLearnersOption() {
		myLearnersOption.click();
		return new MyLearnersPage(driver);
	}
	
	public MessagesPage clickOnMessagesOption() {
		messagesOption.click();
		return new MessagesPage(driver);
	}
	
}
