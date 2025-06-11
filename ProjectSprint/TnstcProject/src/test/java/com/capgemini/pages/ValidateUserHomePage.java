package com.capgemini.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ValidateUserHomePage {
	@FindBy(xpath = "//b")
	private WebElement loggedInUserNameText;
	
	@FindBy(id="matchStartPlace")
	private WebElement matchStartPlaceInput;
	
	@FindBy(id="matchEndPlace")
	private WebElement matchEndPlaceInput;
	
	
	@FindBy(xpath="//button[@id='searchButton']")
	private WebElement searchButton;
	
	@FindAll(value = @FindBy(xpath="//ul/li[@class='ui-menu-item']"))
	private List<WebElement> placeSuggestionList;
	
	
	WebDriver driver;
	public ValidateUserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLoggedInUserNameText() {
		return loggedInUserNameText;
	}
	
	public WebElement getMatchStartPlaceInput() {
		return matchStartPlaceInput;
	}
	public WebElement getMatchEndPlaceInput() {
		return matchEndPlaceInput;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public List<WebElement> getPlaceSuggestionList() {
		return placeSuggestionList;
	}

}
