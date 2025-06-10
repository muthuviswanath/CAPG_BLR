package org.capg.sprint.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	@FindBy(xpath = "//div[text()='Menu']")
	private WebElement menuButton;

	@FindBy(xpath = "//a[contains(text(),'Painting & Cleaning')]")
	private WebElement paintingAndCleaningLink;

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickMenuButton() {
		menuButton.click();
	}
	public void clickPaintingAndCleaningLink() {
		paintingAndCleaningLink.click();
	}
}
