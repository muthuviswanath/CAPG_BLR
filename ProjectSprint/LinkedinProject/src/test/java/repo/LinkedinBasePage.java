package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinBasePage {
	@FindBy(xpath = "//a[normalize-space()='Sign in with email']")
	private WebElement signInWithEmail;

	WebDriver driver;
	public LinkedinBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInWithEmail() {
		return signInWithEmail;
	}
}
