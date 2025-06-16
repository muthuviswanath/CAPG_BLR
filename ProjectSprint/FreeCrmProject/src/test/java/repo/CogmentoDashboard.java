package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CogmentoDashboard {
	@FindBy(xpath = "//div[@id='main-nav']")
	private WebElement mainNav;

	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	private WebElement companiesLink;

	WebDriver driver;
	public CogmentoDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getMainNav() {
		return mainNav;
	}
	public WebElement getCompaniesLink() {
		return companiesLink;
	}

}
