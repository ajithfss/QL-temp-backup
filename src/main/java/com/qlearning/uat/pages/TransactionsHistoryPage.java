package com.qlearning.uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransactionsHistoryPage {
	
	WebDriver driver;

	public TransactionsHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
