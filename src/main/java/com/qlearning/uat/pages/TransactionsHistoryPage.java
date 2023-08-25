package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsHistoryPage {
	
	WebDriver driver;

	public TransactionsHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects:
	
	@FindBy(xpath="//table[contains(@class,'table table-borderless')]")
	private WebElement transactionsTable;
	
	@FindBy(linkText="Transactions History")
	private WebElement transactionsHistory;
	
	@FindBy(linkText="Purchase List")
	private WebElement purchaseList;
	
	//Actions:
	public Boolean retrieveTransactionsHistoryTable() {
		Boolean table = transactionsTable.isDisplayed();
		return table;
	}
	
	public void clickOnTransactionsHistory() {
		transactionsHistory.click();
	}
	
	public void clickOnPurchaseList() {
		purchaseList.click();
	}

}
