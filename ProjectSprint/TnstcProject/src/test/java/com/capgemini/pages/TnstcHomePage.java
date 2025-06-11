package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TnstcHomePage {

	@FindBy(xpath =  "//li//a[@title='Login / Sign up']")
	private WebElement loginSignUpLink;

	@FindBy(id="txtUserLoginID")
	private WebElement userLoginIdInput;

	@FindBy(css = "#txtPassword")
	private WebElement passwordInput;

	@FindBy(xpath = "//span[@id='captcha']")
	private WebElement predefinedCaptchaText;

	@FindBy(xpath="//input[@id='txtCaptchaCode']")
	private WebElement captchaInput;

	@FindBy(xpath = "//button[@id='ValidateUser']")
	private WebElement loginButton;

	WebDriver driver;
	public TnstcHomePage	(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginSignUpLink(){
		return loginSignUpLink;
	}

	public WebElement getUserLoginIdInput(){
		return userLoginIdInput;
	}

	public WebElement getPasswordInput(){
		return passwordInput;
	}

	public WebElement getPredefinedCaptchaText(){
		return predefinedCaptchaText;
	}
	
	public WebElement getCaptchaInput(){
		return captchaInput;
	}
	public WebElement getLoginButton(){
		return loginButton;
	}
}
