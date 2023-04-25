package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;
	@FindBy (id="input-email")
	WebElement emailField;
	
	
	@FindBy (id="input-password")
	WebElement passwordField;


	@FindBy (xpath="//input[@value='Login']")
	WebElement loginButton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement emailPasswordNoMatchWarning;
	
	
	
	
	
public LoginPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
}


public void enterEmailAddress(String emailText) {
	emailField.sendKeys(emailText);
}

public void passwordTextField(String passwordText) {
	passwordField.sendKeys(passwordText);
}

public void clickOnLoginButton() {
	loginButton.click();
}

public String getEmailPasswordNoMatchWarningText() {
	String warningText = emailPasswordNoMatchWarning.getText();
	return warningText;
}





}