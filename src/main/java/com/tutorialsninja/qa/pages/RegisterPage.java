package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	 
	@FindBy(id="input-firstname")
private	WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private	WebElement lastNameField;
	
	@FindBy(id="input-email")
	private	WebElement emailField;
	
	@FindBy(id="input-telephone")
	private	WebElement telephoneField;
	
	@FindBy(id="input-password")
	private	WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private	WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement clickOnAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickOnContinue;
	
	
	@FindBy(xpath="//input[@name='newsletter']")
	private WebElement newsletterRadioButton;
	
	
	@FindBy(xpath="//div[contains (@class,'alert-dismissible')]")
	private WebElement duplicateEmail;
	
	
	@FindBy(xpath="//div[contains (@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[3]/div/div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[4]/div/div")
	private WebElement emailAddressWarningMessage;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[5]/div/div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
	private WebElement passwordWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public void firstNameTextField(String firstname) {
		firstNameField.sendKeys(firstname);
	}
	
	public void lastNameTextField(String lastname) {
		lastNameField.sendKeys(lastname);
	}
	
	public void emailTextField(String email) {
		emailField.sendKeys(email);
	}
	
	public void telephoneTextField(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void passwordTextField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void confirmPasswordTextField(String password) {
		confirmPasswordField.sendKeys(password);
	}
	
	public void clickOnAgreeButton() {
		clickOnAgree.click();
	}
	
	public void clickOnContinueButton() {
		clickOnContinue.click();
	}
	
	public void newsLetterRadioButtonOption() {
		newsletterRadioButton.click();
	}
	
	public String duplicateEmailWarningText() {
		String duplicateEmailWarning = duplicateEmail.getText();
		return duplicateEmailWarning;
	}
	
	public String privacyPolicyWarningText() {
		String privacyPolicyWarning = privacyPolicyWarningMessage.getText();
		return privacyPolicyWarning;
		}

	public String firstNameWarningText() {
		String firstNameWarning = firstNameWarningMessage.getText();
		return firstNameWarning;
	}
	
	public String lastNameWarningText() {
			String lastNameWarning = lastNameWarningMessage.getText();
			return lastNameWarning;
	}
	
	public String emailAddressWarningText() {
		String emailAddressWarning = emailAddressWarningMessage.getText();
		return emailAddressWarning;
	}
	
	public String telephoneWarningText() {
		String telephoneWarning = telephoneWarningMessage.getText();
		return telephoneWarning;
	}
	
	public String passwordWarningText() {
		String passwordWarning = passwordWarningMessage.getText();
		return passwordWarning;
	}
	
}