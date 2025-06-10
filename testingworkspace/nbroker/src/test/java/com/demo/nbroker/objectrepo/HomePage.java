package com.demo.nbroker.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//div[text()='Buy']")
	private WebElement buy_link;

	@FindBy(xpath = "//div[text()='Rent']")
	private WebElement rent_link;

	@FindBy(xpath = "//input[@id='listPageSearchLocality']")
	private WebElement search_textbox;
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void buy_property(String locality) throws InterruptedException {
		buy_link.click();
		search_textbox.sendKeys(locality);
		Thread.sleep(3000); // Wait for suggestions to load
		Actions actions = new Actions(driver);
		actions.moveByOffset(550, 495).click().perform(); // Click on the suggestion
	}

}