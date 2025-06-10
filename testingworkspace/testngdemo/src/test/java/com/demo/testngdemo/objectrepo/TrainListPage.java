package com.demo.testngdemo.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainListPage {
@FindBy(linkText = "Logout")
private WebElement logoutLink;

WebDriver driver;
public TrainListPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void logout() {
	logoutLink.click();
}
}
