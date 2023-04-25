package com.tutorialsninja.qa.test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.SuccessPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	driver =	initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	
	HomePage homepage = new HomePage(driver);
	homepage.clickOnMyAccount();
	
	homepage.selectRegisterOption();
	}

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
	
	@Test(priority=1)
	public void verifyRegisteringWithOnlyMandatoryFields() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.firstNameTextField(dataProp.getProperty("firstName"));
		registerpage.lastNameTextField(dataProp.getProperty("lastName"));
		registerpage.emailTextField(Utilities.generateEmailWithTimeStamp());
		registerpage.telephoneTextField(dataProp.getProperty("telephoneNumber"));
		registerpage.passwordTextField(prop.getProperty("validPassword"));
		registerpage.confirmPasswordTextField(prop.getProperty("validPassword"));
		registerpage.clickOnAgreeButton();
		registerpage.clickOnContinueButton();
		
		SuccessPage successpage = new SuccessPage(driver);
		String actualMessage = successpage.accountCreatedSuccessMessage();
		Assert.assertEquals(actualMessage, "Your Account Has Been Created!","Account created message is not displayed");
		
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringWithAllFields() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.firstNameTextField(dataProp.getProperty("firstName"));
		registerpage.lastNameTextField(dataProp.getProperty("lastName"));
		registerpage.emailTextField(Utilities.generateEmailWithTimeStamp());
		registerpage.telephoneTextField(dataProp.getProperty("telephoneNumber"));
		registerpage.passwordTextField(prop.getProperty("validPassword"));
		registerpage.confirmPasswordTextField(prop.getProperty("validPassword"));
		registerpage.newsLetterRadioButtonOption();
		registerpage.clickOnAgreeButton();
		registerpage.clickOnContinueButton();
		
		SuccessPage successpage = new SuccessPage(driver);
		String actualMessage = successpage.accountCreatedSuccessMessage();
		Assert.assertEquals(actualMessage, "Your Account Has Been Created!","Account created message is not displayed");
		
		

		
	}
	
	@Test(priority=3)
	public void verifyRegisteringWithExistingEmailId() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.firstNameTextField(dataProp.getProperty("firstName"));
		registerpage.lastNameTextField(dataProp.getProperty("lastName"));
		registerpage.emailTextField(prop.getProperty("validEmail"));
		registerpage.telephoneTextField(dataProp.getProperty("telephoneNumber"));
		registerpage.passwordTextField(prop.getProperty("validPassword"));
		registerpage.confirmPasswordTextField(prop.getProperty("validPassword"));
		registerpage.clickOnAgreeButton();
		registerpage.clickOnContinueButton();
		
		String actualDuplicateEmailWarningMessage = registerpage.duplicateEmailWarningText();
		Assert.assertEquals(actualDuplicateEmailWarningMessage, dataProp.getProperty("duplicateEmailWarning"),"Email Warning message is not displayed");
		
	
		   
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringWithoutFillingAnyDetails() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		
		registerpage.clickOnContinueButton();
		
		String actualPrivacyPolicyMessage = registerpage.privacyPolicyWarningText();
		Assert.assertEquals(actualPrivacyPolicyMessage, dataProp.getProperty("privacyPolicyWarning"), "Privacy policy message not displayed");
	
		String actualFirstNameWarningMessage = registerpage.firstNameWarningText();
		Assert.assertEquals(actualFirstNameWarningMessage, dataProp.getProperty("firstNameWarning"),"First Name Warning Not displayed");

		String actualLastNameWarningMessage = registerpage.lastNameWarningText();
		Assert.assertEquals(actualLastNameWarningMessage, dataProp.getProperty("lastNameWarning"),"Last Name Warning Not displayed");

		String actualEmailWarningMessage = registerpage.emailAddressWarningText();
		Assert.assertEquals(actualEmailWarningMessage, dataProp.getProperty("emailAddressWarning"),"Email Warning Not displayed");
		
		String actualTelephoneWarningMessage = registerpage.telephoneWarningText();
		Assert.assertEquals(actualTelephoneWarningMessage, dataProp.getProperty("telephoneWarning"),"Telephone Warning Not displayed");

		String actualPasswordWarningMessage = registerpage.passwordWarningText();
		Assert.assertEquals(actualPasswordWarningMessage, dataProp.getProperty("passwordWarning"),"Password Warning Not displayed");

		

	
	
	
	
	
	}
	
	
	
	
}

