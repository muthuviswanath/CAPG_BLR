package com.capg.PomDemo.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "LOGIN")
	private WebElement login_link;
	
	@FindBy(xpath = "//input[@formcontrolname='userid']")
	private WebElement usernameTextBox;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@type='submit'][text()='SIGN IN']")
	private WebElement signInButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void login(String username, String password){
		//Click on the login link
		login_link.click();
		
		//Enter the username
		usernameTextBox.sendKeys(username);
		
		//Enter the password
		passwordTextBox.sendKeys(password);		
	}
	public void clickSignIn() {
		signInButton.click();
	}
	
	
	
	
}
