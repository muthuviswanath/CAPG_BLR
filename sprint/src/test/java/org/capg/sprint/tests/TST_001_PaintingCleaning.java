package org.capg.sprint.tests;

import java.time.Duration;

import org.capg.sprint.repo.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TST_001_PaintingCleaning {

	WebDriver driver;
	String baseurl;
	HomePageObject homePageObject;
	
	@BeforeClass
	public void browserSetup() {
		driver = new ChromeDriver();
		baseurl = "https://www.nobroker.in/";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void pageSetup() {
		homePageObject = new HomePageObject(driver);
	}
	
	@Test
	public void testPaintingAndCleaning() {
	homePageObject.clickMenuButton();
	homePageObject.clickPaintingAndCleaningLink();
	
	}
}
