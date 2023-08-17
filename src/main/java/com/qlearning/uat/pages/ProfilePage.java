package com.qlearning.uat.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Objects:
	
	@FindBy(linkText="Profile")
	private WebElement profilePageTab;
	
	@FindBy(linkText="Account Settings")
	private WebElement accountSettingsPage;
	
	@FindBy(linkText="Payout Info")
	private WebElement payoutInfoPage;
	
	@FindBy(linkText="Notifications")
	private WebElement notificationPage;
	
	@FindBy(linkText="Coupon")
	private WebElement couponPage;
	
	@FindBy(className="mb-1")
	private WebElement profileName;
	
	@FindBy(className="mute")
	private WebElement emailId;
	
	@FindBy(name="firstName")
	private WebElement firstNameField;
	
	@FindBy(id="middleName")
	private WebElement middleNameField;
	
	@FindBy(id="lastName")
	private WebElement lastNameField;
	
	@FindBy(tagName="textarea")
	private WebElement descriptionField;
	
	@FindBy(xpath="(//label[text()='Mobile Number']/following::input)[1]")
	private WebElement mobileNumberField;
	
	@FindBy(name="experience")
	private WebElement experienceField;
	
	@FindBy(xpath="//input[@placeholder='category']")
	private WebElement categoriesOfExpertiseField;
	
	@FindBy(name="available")
	private WebElement availableInaWeekField;
	
	@FindBy(name="fromTime")
	private WebElement availableTimeFromField;
	
	@FindBy(name="toTime")
	private WebElement availableTimeToField;
	
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
	
	@FindBy(xpath="//div[text()='Successfully Submitted Profile']")
	private WebElement profileUpdatedSuccessText;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement updatedSuccessButton;
	
	@FindBy(className="a.menu-font-style.me-lg-2")
	private WebElement googlePlayIcon;
	
	@FindBy(className="a.menu-font-style.me-lg-3")
	private WebElement appStore;
	
	@FindBy(xpath="//small[text()='Please fill this field']")
	private WebElement fillFieldWarning;
	
	@FindBy(xpath="//small[text()='Invalid']")
	private WebElement invalidWarning;
	
	//Actions:
	public String retrieveFirstNameFieldText() { 
		String firstNameFieldText = firstNameField.getText();
		return firstNameFieldText;
	}
	
	public void enterFirstName() {
		firstNameField.clear();
		firstNameField.sendKeys("QL");
	}
	 
	public void enterMiddleName() {
		middleNameField.clear();
		middleNameField.sendKeys("FSS");
	}
	
	public void enterLastName() {
		lastNameField.clear();
		lastNameField.sendKeys("QA");
	}
	
	public void enterDescription() {
		descriptionField.clear();
		descriptionField.sendKeys("I have 2 years of experience in teaching field");
	}
	
	public String getMobileNumber() {
		String mobileNumber = mobileNumberField.getText();
		return mobileNumber;
	}
	
	public void enterExperience() {
		experienceField.clear();
		experienceField.sendKeys("2");
	}
	
	public void enterCategoriesOfExpertise() {
		categoriesOfExpertiseField.sendKeys("learn");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterAvailableInaWeek() {
		availableInaWeekField.clear();
		availableInaWeekField.sendKeys("10");
	}
	
	public void enterAvailableTimeFrom() {
		availableTimeFromField.clear();
		availableTimeFromField.sendKeys("1300");
	}
	
	public void enterAvailableTimeTo() {
		availableTimeToField.clear();
		availableTimeToField.sendKeys("1500");
	}
	
	public String getFacebookLink() {
		String facebookLink = facebookField.getText();
		return facebookLink;
	}
	
	public String getinstagramLink() {
		String instagramLink = instagramField.getText();
		return instagramLink;
	}
	
	public String getlinkedinLink() {
		String linkedinLink = linkedinField.getText();
		return linkedinLink;
	}
	
	public String gettwitterLink() {
		String twitterLink = twitterField.getText();
		return twitterLink;
	}
	
	public void clickOnSaveChangesButton() {
		saveChangesButton.click();
	}
	
	public String retrieveProfileUpdatedSuccessText() {
		String successText = profileUpdatedSuccessText.getText();
		return successText;
	}
	
	public void clickOnProfileUpdatedSuccessButton() {
		updatedSuccessButton.click();
	}
	
	public AccountSettingsPage clickOnAccountSettingsPage() {
		accountSettingsPage.click();
		return new AccountSettingsPage(driver);
	}
	
	public PayoutInfoPage clickOnPayoutInfoPage() {
		payoutInfoPage.click();
		return new PayoutInfoPage(driver);
	}
	
	public String retrievefillFieldWarning() {
		String warning = fillFieldWarning.getText();
		return warning;
	}
	
	public void clearFirstNameField() {
//		firstNameField.click();
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.BACK_SPACE).perform();
//		act.sendKeys(Keys.BACK_SPACE).perform();
		firstNameField.clear();
	}
	public void clearLastNameField() {
		lastNameField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		//lastNameField.clear();
	}
	
	public void clearAboutYouField() {
		descriptionField.click();
	}
	
	public void clearExperienceField() {
		experienceField.clear();
	}
	
	public void clearAvailableInaWeekField() {
		availableInaWeekField.clear();
	}
	
	public void clearAvailableTimeFromField() {
		availableTimeFromField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DELETE).build().perform();
		//Actions act = new Actions(driver);
//		act.sendKeys(Keys.BACK_SPACE).perform();
//		act.sendKeys(Keys.BACK_SPACE).perform();
	}
	
	public String retrieveInvalidWarning() {
		String warning = invalidWarning.getText();
		return warning;
	}
	
	public Boolean retrieveProfilePageText() {
		Boolean profilePageText = profilePageTab.isDisplayed();
		return profilePageText;
	}
	
	public void enterFacebookLink() {
		facebookField.sendKeys("facebook");
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
	
	public void editFacebookLink() {
		facebookField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();	
	}
	
	public void editInstagramLink() {
		instagramField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();	
	}
	
	public void editLinkedinLink() {
		linkedinField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();	
	}
	
	public void editTwitterLink() {
		twitterField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();	
	}
	
	public NotificationSettingsPage clickOnNotificationsPage() {
		notificationPage.click();
		return new NotificationSettingsPage(driver);
	}
	
	public CouponPage clickOnCouponPage() {
		couponPage.click();
		return new CouponPage(driver);
	}
	
	
}
