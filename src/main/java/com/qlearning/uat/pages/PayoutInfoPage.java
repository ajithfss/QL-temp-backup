package com.qlearning.uat.pages;




import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PayoutInfoPage {

	WebDriver driver;

	public PayoutInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	@FindBy(xpath="//button[text()='+ Add Payment Info']")
	private WebElement addPaymentInfoButton;
	
	@FindBy(xpath="//h5[text()='Add Bank Account Detail']")
	private WebElement bankAccountDetailText;
	
	@FindBy(xpath="(//label[text()='Name']/following::input)[1]")
	private WebElement accountHolderNameField;
	
	@FindBy(xpath="//div[text()='Select bank name']/following-sibling::div")
	private WebElement bankNameField;
	
	@FindBy(xpath="(//label[text()='Account number']/following::input)[1]")
	private WebElement accountNumberField;
	
	@FindBy(xpath="(//label[text()='IFSC Code']/following::input)[1]")
	private WebElement IFSCcodeField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[text()='Success']")
	private WebElement accountAddedSuccessText;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement OkButton;
	
	@FindBy(xpath="//p[text()='Delete']")
	private WebElement accountDeleteButton;
	
	@FindBy(xpath="//p[text()='Edit']")
	private WebElement bankAccountInfoEditButton;
	
	@FindBy(xpath="//h5[text()='Edit: Bank Account Detail']")
	private WebElement bankDetailsEditPage;
	
	@FindBy(xpath="//p[text()='Delete']")
	private WebElement bankAccountInfoDeleteButton;
	
	@FindBy(xpath="//div[text()='Are you sure?']")
	private WebElement deleteConfirmText;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement deleteOkButton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement deleteCancelButton;
	
	@FindBy(className="btn-close")
	private WebElement editCloseButton;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement editSaveButton;
	
	@FindBy(xpath="//div[text()='Payout Info Updated successfully']")
	private WebElement accountEditedSuccessText;
	
	@FindBy(xpath="//div[text()='You cannot recover deleted data once it has been deleted']")
	private WebElement deleteConfirmationText;
	
	//Actions:
	
	public void clickOnAddPaymentInfoButton() {
		addPaymentInfoButton.click();
	}
	
	public Boolean retrieveBankAccountPageText() {
		Boolean accountPage = bankAccountDetailText.isDisplayed();
		return accountPage;
	}
	
	public void enterAccountHolderName() {
		accountHolderNameField.clear();
		accountHolderNameField.sendKeys("INSTRUCTOR");
	}
	
	public void enterBankName() {
		bankNameField.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterAccountNumber() {
		accountNumberField.clear();
		accountNumberField.sendKeys("12345678912345678");
	}
	
	public void enterIFSCcode() {
		IFSCcodeField.clear();
		IFSCcodeField.sendKeys("BARB0COIMBA");
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public Boolean retrieveAccountAddedSuccessText() {
		Boolean success = accountAddedSuccessText.isDisplayed();
		return success;
	}
	
	public void clickOnOkButton() {
		OkButton.click();
	}
	
	public void clickOnAccountDeleteButton() {
		accountDeleteButton.click();
	}
	
	public void clickOnDeleteOkButton() {
		deleteOkButton.click();
	}
	
	public void clickOnEditButton() {
	
		bankAccountInfoEditButton.click();
	}
	
	public void clickOnEditCloseButton() {
		editCloseButton.click();
	}
	
	public void clickOnEditSaveButton() {
		editSaveButton.click();
	}
	
	public Boolean retrieveBankDetailsEditPage() {
		Boolean editPage = bankDetailsEditPage.isDisplayed();
		return editPage;
	}
	
	public String retrieveAccountEditedSuccessText() {
		String editText = accountEditedSuccessText.getText();
		return editText;
	}
	
	public String retrieveDeleteConfirmationText() {
		String deleteText = deleteConfirmationText.getText();
		return deleteText;
	}
}
