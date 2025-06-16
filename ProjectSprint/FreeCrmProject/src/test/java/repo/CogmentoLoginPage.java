package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CogmentoLoginPage {

	@FindBy(xpath = "//input[@type='text']")
	private WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginButton;

	WebDriver driver;
	public CogmentoLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}

}
