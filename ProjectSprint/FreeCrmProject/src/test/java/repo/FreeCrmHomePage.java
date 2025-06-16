package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmHomePage {
	@FindBy(xpath = "//span[contains(text(),'Start Here')]")
	private WebElement startHereLink;

	WebDriver driver;
	public FreeCrmHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getStartHereLink() {
		return startHereLink;
	}
}
