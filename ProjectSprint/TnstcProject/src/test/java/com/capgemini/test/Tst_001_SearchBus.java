package com.capgemini.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.TnstcHomePage;
import com.capgemini.pages.ValidateUserHomePage;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;

public class Tst_001_SearchBus extends BaseReport {
	WebDriver driver;
	static String excelpath;
	TnstcHomePage tnstcHomePage;
	ValidateUserHomePage validateUserHomePage;
	static String baseURL;
	static String screenshotPath;


	@BeforeClass
	public void browserSetup() {
		baseURL = "https://www.tnstc.in/OTRSOnline/";
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		excelpath = "src/test/resources/ExcelData/TestData.xlsx";
		tnstcHomePage = new TnstcHomePage(driver);
		validateUserHomePage = new ValidateUserHomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public String getUserLoginId() {
		return ExcelReader.getCellData(excelpath, "UserDetails", 1, 0);
	}

	public String getPassword() {
		return ExcelReader.getCellData(excelpath, "UserDetails", 1, 1);
	}

	@Test
	public void LoginToApp() throws Exception {

		//Step 1: Click on the login link
		tnstcHomePage.getLoginSignUpLink().click();
		Reporter.log("Clicked on Login/Sign up link", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoginLinkClicked");
		generateReportWithScreenshot("Click on the login link", screenshotPath);
		


		//Step 2: Enter user login ID
		tnstcHomePage.getUserLoginIdInput().sendKeys(getUserLoginId());
		Reporter.log("Entered user login ID: " + getUserLoginId(), true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "UserLoginIdEntered");
		generateReportWithScreenshot("Enter the user login ID", screenshotPath);

		//Step 3: Enter password
		tnstcHomePage.getPasswordInput().sendKeys(getPassword());
		Reporter.log("Entered password", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "PasswordEntered");
		generateReportWithScreenshot("Enter the password", screenshotPath);
		
		//Step 4: Enter captcha
		String predefinedCaptcha = tnstcHomePage.getPredefinedCaptchaText().getText();
		tnstcHomePage.getCaptchaInput().sendKeys(predefinedCaptcha);
		Reporter.log("Entered captcha: " + predefinedCaptcha, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CaptchaEntered");
		generateReportWithScreenshot("Enter the captcha", screenshotPath);

		//Step 5: Click on login button
		tnstcHomePage.getLoginButton().click();
		Reporter.log("Clicked on login button", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoginButtonClicked");
		generateReportWithScreenshot("Click on the login button", screenshotPath);
	}

	@Test(dependsOnMethods = "LoginToApp")
	public void SearchBus() throws Exception {

		//Step 6: Validate logged in user name
		String loggedInUserName = validateUserHomePage.getLoggedInUserNameText().getText();
		Reporter.log("Logged in user name validated: " + loggedInUserName, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoggedInUserNameValidated");
		generateReportWithScreenshot("Validate logged in user name", screenshotPath);

		//Step 7: Enter start place
		String startPlace = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 0);
		String endPlace = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 1);
		String date = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 2);

		validateUserHomePage.getMatchStartPlaceInput().sendKeys(startPlace);
		Reporter.log("Entered start place: " + startPlace, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "StartPlaceEntered");
		generateReportWithScreenshot("Enter start place", screenshotPath);
		
		Thread.sleep(1000); // Wait for input to process

		//Step 8: Select start place from suggestions
		for (WebElement place : validateUserHomePage.getPlaceSuggestionList()) {
			if (place.getText().equalsIgnoreCase("CHENNAI TAMBARAM")) {
				place.click();
				Reporter.log("Selected start place from suggestions: " + startPlace, true);
				Assert.assertTrue(true);
				screenshotPath = Screenshots.takeScreenShot(driver, "StartPlaceSelected");
				generateReportWithScreenshot("Select start place from suggestions", screenshotPath);
				break;
			}
		}

		//Step 9: Enter end place
		validateUserHomePage.getMatchEndPlaceInput().sendKeys(endPlace);
		Reporter.log("Entered end place: " + endPlace, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "EndPlaceEntered");
		generateReportWithScreenshot("Enter end place", screenshotPath);
		Thread.sleep(1000); // Wait for input to process

		//Step 10: Select end place from suggestions
		for (WebElement place : validateUserHomePage.getPlaceSuggestionList()) {
			if (place.getText().equalsIgnoreCase("BENGALURU")) {
				place.click();
				Reporter.log("Selected end place from suggestions: " + endPlace, true);
				Assert.assertTrue(true);
				screenshotPath = Screenshots.takeScreenShot(driver, "EndPlaceSelected");
				generateReportWithScreenshot("Select end place from suggestions", screenshotPath);
				break;
			}
		}

		//Step 11: Select date
		driver.findElement(By.xpath("//td/a[text()='"+date+"']")).click();
		Reporter.log("Selected date: " + date, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "DateSelected");
		generateReportWithScreenshot("Select date", screenshotPath);

		Thread.sleep(1000); // Wait for date selection to process

		//Step 12: Click on search button
		validateUserHomePage.getSearchButton().click();
		Reporter.log("Clicked on search button", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "SearchButtonClicked");		
		generateReportWithScreenshot("Click on the search button", screenshotPath);
		Thread.sleep(1000); // Wait for search to process

		Reporter.log("Search result page displayed successfully", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "SearchResultPageDisplayed");
		generateReportWithScreenshot("Search result page displayed", screenshotPath);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			Reporter.log("Browser closed successfully", true);
		}
		Reporter.log("Test completed successfully", true);
	}

}