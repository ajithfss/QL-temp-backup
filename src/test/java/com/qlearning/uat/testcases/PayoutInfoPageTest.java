package com.qlearning.uat.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qlearning.uat.base.Base;
import com.qlearning.uat.pages.DashboardPage;
import com.qlearning.uat.pages.HomePage;
import com.qlearning.uat.pages.LoginPage;
import com.qlearning.uat.pages.PayoutInfoPage;
import com.qlearning.uat.pages.ProfilePage;

public class PayoutInfoPageTest extends Base {

	public PayoutInfoPageTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfilePage profilePage;
	PayoutInfoPage payoutInfoPage;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.selectLoginOption();
		loginPage.enterEmailAddress(prop.getProperty("validInstructorEmail"));
		loginPage.enterPassword(prop.getProperty("validInstructorPwd"));
		dashboardPage = loginPage.clickOnLoginButton();
		profilePage = dashboardPage.clickOnInstructorProfileIcon();
		payoutInfoPage = profilePage.clickOnPayoutInfoPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//TC_31
	@Test
	public void verifyAddBankAccountPopup() {
		payoutInfoPage.clickOnAddPaymentInfoButton();
		Assert.assertTrue(payoutInfoPage.retrieveBankAccountPageText(), "bank account details page is not displayed");		
	}
	
	//TC_32
	@Test(groups= {"smoke"})
	public void verifyFillingAccountdetails() {
		payoutInfoPage.clickOnAddPaymentInfoButton();
		payoutInfoPage.enterAccountHolderName();
		payoutInfoPage.enterBankName();
		payoutInfoPage.enterAccountNumber();
		payoutInfoPage.enterIFSCcode();
		payoutInfoPage.clickOnSubmitButton();
		Assert.assertTrue(payoutInfoPage.retrieveAccountAddedSuccessText(), "Account is not added successfully");
		payoutInfoPage.clickOnOkButton();
		payoutInfoPage.clickOnAccountDeleteButton();
		payoutInfoPage.clickOnDeleteOkButton();
	}
	
	//TC_33
	@Test(groups= {"smoke"})
	public void verifyEditBankAccountDetailsDisplay() {
		payoutInfoPage.clickOnAddPaymentInfoButton();
		payoutInfoPage.enterAccountHolderName();
		payoutInfoPage.enterBankName();
		payoutInfoPage.enterAccountNumber();
		payoutInfoPage.enterIFSCcode();
		payoutInfoPage.clickOnSubmitButton();
		payoutInfoPage.clickOnOkButton();
		payoutInfoPage.clickOnEditButton();
		Assert.assertTrue(payoutInfoPage.retrieveBankDetailsEditPage(), "Edit: bank details page is not displayed");
		payoutInfoPage.clickOnEditCloseButton();
		payoutInfoPage.clickOnAccountDeleteButton();
		payoutInfoPage.clickOnDeleteOkButton();
	}
	
	//TC_34
		@Test(groups= {"smoke"})
		public void verifyEditBankAccountDetailsSuccess() {
			payoutInfoPage.clickOnAddPaymentInfoButton();
			payoutInfoPage.enterAccountHolderName();
			payoutInfoPage.enterBankName();
			payoutInfoPage.enterAccountNumber();
			payoutInfoPage.enterIFSCcode();
			payoutInfoPage.clickOnSubmitButton();
			payoutInfoPage.clickOnOkButton();
			payoutInfoPage.clickOnEditButton();
			payoutInfoPage.enterAccountHolderName();
			payoutInfoPage.clickOnEditSaveButton();
			Assert.assertEquals(payoutInfoPage.retrieveAccountEditedSuccessText(), "Payout Info Updated successfully");
			payoutInfoPage.clickOnOkButton();
			payoutInfoPage.clickOnAccountDeleteButton();
			payoutInfoPage.clickOnDeleteOkButton();
		}
		
		//TC_35
		@Test(groups= {"smoke"})
		public void verifydeleteAccountConfirmationPopup() {
			payoutInfoPage.clickOnAddPaymentInfoButton();
			payoutInfoPage.enterAccountHolderName();
			payoutInfoPage.enterBankName();
			payoutInfoPage.enterAccountNumber();
			payoutInfoPage.enterIFSCcode();
			payoutInfoPage.clickOnSubmitButton();
			payoutInfoPage.clickOnOkButton();
			payoutInfoPage.clickOnAccountDeleteButton();
			Assert.assertEquals(payoutInfoPage.retrieveDeleteConfirmationText(), "You cannot recover deleted data once it has been deleted");
			payoutInfoPage.clickOnDeleteOkButton();
		}
		
	
	
}
