package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

	WebDriver driver;
	
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement accountCreatedMessage;
		
	
	
	public SuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String accountCreatedSuccessMessage() {
		String accountSuccessMessage = accountCreatedMessage.getText();
		return accountSuccessMessage;
	}
	
	
}
