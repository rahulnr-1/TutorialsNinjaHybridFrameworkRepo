package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHpSearch;
	

	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  
		public String retrieveNoProductMessageText() {
			String noProductMessageText = noProductMessage.getText();
			return noProductMessageText;
		}
	
		public boolean displayStatusOfHpValidProduct() {
			boolean displayStatus = validHpSearch.isDisplayed();
			return displayStatus;
		}
		
	}

