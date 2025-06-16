package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage {
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement createButton;

	@FindBy(xpath = "//input[@name='image']")
	private WebElement uploadImage;

	WebDriver driver;
	public CompaniesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public WebElement getCreateButton() {
		return createButton;
	}
	public WebElement getUploadImage() {
		return uploadImage;
	}
}
