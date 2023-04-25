package com.tutorialsninja.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	
	public SearchTest(){
		
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	driver =	initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		HomePage homepage = new HomePage(driver);
		
		homepage.searchTextField(dataProp.getProperty("validProduct"));
		homepage.searchButtonOption();
		
		SearchPage searchpage = new SearchPage(driver);
	Assert.assertTrue(searchpage.displayStatusOfHpValidProduct());

	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		HomePage homepage = new HomePage(driver);
		homepage.searchInvalidProduct(dataProp.getProperty("invalidProduct"));
		homepage.searchButtonOption();
		
		SearchPage searchpage = new SearchPage(driver);
		String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage,"abcd","No product message in search results is not displayed");
	
	
	}
	@Test(priority=3,dependsOnMethods= {"verifySearchWithInvalidProduct"})
	public void verifySearchWithNoProduct() {
		HomePage homepage = new HomePage(driver);
		
		homepage.searchButtonOption();
		
		SearchPage searchpage = new SearchPage(driver);
		String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProductTextInSearchResults"),"No Product Text In Search results is not displayed");

	}
}
