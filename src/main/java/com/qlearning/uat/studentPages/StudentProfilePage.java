package com.qlearning.uat.studentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentProfilePage {

	WebDriver driver;

	public StudentProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(id="firstName")
	private WebElement firstNameField;
	
	@FindBy(id="middleName")
	private WebElement middleNameField;
	
	@FindBy(id="lastName")
	private WebElement lastNameField;
	
	@FindBy(tagName="textarea")
	private WebElement aboutYouField;
	
	@FindBy(xpath="(//label[text()='Mobile Number']/following::input)[1]")
	private WebElement mobileNumberField;
	
	@FindBy(name="fb")
	private WebElement facebookField;
	
	@FindBy(name="insta")
	private WebElement instagramField;
	
	@FindBy(name="linkdin")
	private WebElement linkedinField;
	
	@FindBy(name="twitter")
	private WebElement twitterField;
	
	@FindBy(xpath="//button[text()='Save Changes']")
	private WebElement saveChangesButton;
	
	@FindBy(linkText="Account Settings")
	private WebElement accountSettingsTab;
	
	@FindBy(linkText="Notifications")
	private WebElement notificationSettingsTab;
	
	@FindBy(xpath="//small[text()='First name required']")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//small[text()='Last name required']")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//small[text()='Please Fill this Field']")
	private WebElement aboutYouWarning;
	
	@FindBy(xpath="//small[text()='invalid mobile number']")
	private WebElement mobileNumberWarning;
	
	
	//Actions:
	
	public void enterFirstName() {
		firstNameField.clear();
		firstNameField.sendKeys("QL");
	}
	
	public void clearFirstNameField() {
		firstNameField.clear();
	}
	
	public void enterMiddleName() {
		middleNameField.clear();
		middleNameField.sendKeys("FSS");
	}
	
	public void enterLastName() {
		lastNameField.clear();
		lastNameField.sendKeys("STUDENT");
	}
	
	public void clearLastNameField() {
		lastNameField.clear();
	}
	
	public void enterAboutYouField() {
		aboutYouField.clear();
		aboutYouField.sendKeys("I am a student of Qlearning Academy");
	}
	
	public void clearAboutYouField() {
		aboutYouField.clear();
	}
	
	public void enterMobileNumberField() {
		mobileNumberField.clear();
		mobileNumberField.sendKeys("6457892130");
	}
	
	public void clearMobileNumberField() {
		mobileNumberField.clear();
	}
	
	public void enterFacebookLink() {
		facebookField.sendKeys("f");
	}
	
    public void enterInstagramLink() {
    	instagramField.sendKeys("i");
	}
	
    public void enterLinkedinLink() {
    	linkedinField.sendKeys("l");
	}
	
    public void enterTwitterLink() {
    	twitterField.sendKeys("t");
	}
	
    public void clickOnSaveChangesButton() {
    	saveChangesButton.click();
    }
    
    public Boolean retreiveFirstNameRequiredWarning() {
    	Boolean warning = firstNameWarning.isDisplayed();
    	return warning;
    }
    
    public Boolean retreiveLastNameRequiredWarning() {
    	Boolean warning = lastNameWarning.isDisplayed();
    	return warning;
    }
    
    public Boolean retreiveAboutYouRequiredWarning() {
    	Boolean warning = aboutYouWarning.isDisplayed();
    	return warning;
    }
    
    public Boolean retreiveMobileNumberRequiredWarning() {
    	Boolean warning = mobileNumberWarning.isDisplayed();
    	return warning;
    }
    
    public void clickOnFacebookLink() {
    	facebookField.click();
    }
    
    public StudentAccountSettingsPage clickOnAccountSettingsTab() {
    	accountSettingsTab.click();
    	return new StudentAccountSettingsPage(driver);
    }
    
    public StudentNotificationSettingsPage clickOnNotificationSettingsTab() {
    	notificationSettingsTab.click();
    	return new StudentNotificationSettingsPage(driver);
    }
    
    
    
}
