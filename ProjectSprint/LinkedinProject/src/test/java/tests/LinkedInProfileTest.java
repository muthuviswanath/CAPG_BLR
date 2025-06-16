package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import repo.LinkedinBasePage;

public class LinkedInProfileTest {
	WebDriver driver;
	LinkedinBasePage basePage;
	@BeforeClass
	public void SetupBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		basePage = new LinkedinBasePage(driver);

	}

	@Test
	public void testdemo() {
		basePage.getSignInWithEmail().click();

	}
}
