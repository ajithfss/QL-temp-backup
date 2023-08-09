package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponPage {

	WebDriver driver;

	public CouponPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//label[text()='Coupon name']")
	private WebElement CouponNameText;
	
	@FindBy(name="couponName")
	private WebElement couponNameField;
	
	@FindBy(tagName="select")
	private WebElement discountPercentageField;
	
	@FindBy(name="noOfCoupon")
	private WebElement numbersOfCouponField;
	
	@FindBy(xpath="//label[text()='Start date']/following-sibling::input")
	private WebElement startDate;
	
	@FindBy(xpath="//label[text()='Expiry date']/following-sibling::input")
	private WebElement expiryDate;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement couponSubmitButton;
	
	@FindBy(xpath="//button[text()='Submit for review']")
	private WebElement submitForReviewButton;
	
	@FindBy(xpath="//div[text()='Are you sure?']")
	private WebElement submitForReviewConfirmPopUp;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement submitForReviewYesButton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement submitForReviewCancelButton;
	
	@FindBy(xpath="(//button[text()='Approved']/following-sibling::button)[1]")
	private WebElement couponEnableButton;
	
	@FindBy(xpath="//div[text()='Active Courses ']")
	private WebElement activeCoursesList;
	
	@FindBy(xpath="//label[text()=' Enable All']")
	private WebElement enableAllCheckBox;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement couponApplyButton;
	
	@FindBy(xpath="//div[text()='Discount was enabled']")
	private WebElement discountEnabledSuccessPopup;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement discountOkButton;
	
	@FindBy(xpath="//span[text()='Expired ']")
	private WebElement couponExpiredWarning;
	
	
	
	
	
	
	
	
}
