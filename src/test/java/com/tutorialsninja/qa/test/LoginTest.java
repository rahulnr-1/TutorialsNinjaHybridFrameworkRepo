package com.tutorialsninja.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	driver =	initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	
	HomePage homePage = new HomePage(driver);
	homePage.clickOnMyAccount();
	homePage.selectLoginOption();
		
	}

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email,String password){
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.passwordTextField(password);
		loginpage.clickOnLoginButton();
			
		
		AccountPage accountpage = new AccountPage(driver);
		
		Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption());
	
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		
		loginpage.passwordTextField(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		
		String actualWarningMessage = loginpage.getEmailPasswordNoMatchWarningText();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
		
	
	}
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
	

		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.passwordTextField(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
	
		String actualWarningMessage = loginpage.getEmailPasswordNoMatchWarningText();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
		
	
	}	
	
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailAndvalidPassword() {
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.passwordTextField(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
	
		String actualWarningMessage = loginpage.getEmailPasswordNoMatchWarningText();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingAnyCredentials() {
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.clickOnLoginButton();
	
		String actualWarningMessage = loginpage.getEmailPasswordNoMatchWarningText();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
		
	}	


}
