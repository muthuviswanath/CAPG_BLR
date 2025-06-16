package com.capgemini.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusListPage {

	@FindBy(xpath = "//label[contains(text(),'ULTRA DELUXE')]")
	private WebElement acSleeperFilter;

	@FindBy(xpath = "//div[@class='bus-item']//div[@id='selectButton2']//button")
	private WebElement viewSeatsButton;

	@FindAll(value = @FindBy(xpath = "//td//input"))
	private List<WebElement> seatList;

	@FindBy(xpath="//input[@id='txtMobileNo2']")
	private WebElement mobileNumberInput;

	@FindBy(xpath="//input[@id='txtEmailID2']")
	private WebElement emailInput;

	@FindBy(xpath = "//select[@id='dropdown-menu2']")
	private WebElement passengerTypeDropdown;

	@FindBy(xpath = "//select[@id='selectIdProof2']")
	private WebElement idProofDropdown;

	@FindBy(xpath = "//input[@id='txtIdProofReference2']")
	private WebElement idProofText;

	@FindBy(xpath = "//input[@id='name-1']")
	private WebElement passengerNameInput;

	@FindBy(xpath = "//input[@id='age-1']")
	private WebElement passengerAgeInput;

	@FindBy(xpath = "//button[@id='fareButton']")
	private WebElement fareButton;

	WebDriver driver;
	public BusListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public WebElement getAcSleeperFilter() {
		return acSleeperFilter;
	}
	public WebElement getViewSeatsButton() {
		return viewSeatsButton;
	}
	public List<WebElement> getSeatList() {
		return seatList;
	}
	public WebElement getMobileNumberInput() {
		return mobileNumberInput;
	}
	public WebElement getEmailInput() {
		return emailInput;
	}
	public WebElement getPassengerTypeDropdown() {
		return passengerTypeDropdown;
	}
	public WebElement getIdProofDropdown() {
		return idProofDropdown;
	}
	public WebElement getIdProofText() {
		return idProofText;
	}
	public WebElement getPassengerNameInput() {
		return passengerNameInput;
	}
	public WebElement getPassengerAgeInput() {
		return passengerAgeInput;
	}
	public WebElement getFareButton() {
		return fareButton;
	}
	
}
