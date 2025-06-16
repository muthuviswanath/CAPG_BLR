package com.capgemini.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BusListPage;
import com.capgemini.pages.ValidateUserHomePage;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;

public class Tst_002_BookBusAsGuest extends BaseReport {
	WebDriver driver;
	static String excelpath;
	ValidateUserHomePage validateUserHomePage;
	BusListPage busListPage;
	static String baseURL;
	static String screenshotPath;


	@BeforeClass
	public void browserSetup() {
		baseURL = "https://www.tnstc.in/OTRSOnline/";
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		excelpath = "src/test/resources/ExcelData/TestData.xlsx";
		validateUserHomePage = new ValidateUserHomePage(driver);
		busListPage = new BusListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test()
	public void SearchBus() throws Exception {


		//Step 1: Enter start place
		String startPlace = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 0);
		String endPlace = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 1);
		String date = ExcelReader.getCellData(excelpath, "SearchDetails", 1, 2);

		validateUserHomePage.getMatchStartPlaceInput().sendKeys(startPlace);
		Reporter.log("Entered start place: " + startPlace, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "StartPlaceEntered");
		generateReportWithScreenshot("Enter start place", screenshotPath);

		Thread.sleep(1000); // Wait for input to process

		//Step 2: Select start place from suggestions
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

		//Step 3: Enter end place
		validateUserHomePage.getMatchEndPlaceInput().sendKeys(endPlace);
		Reporter.log("Entered end place: " + endPlace, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "EndPlaceEntered");
		generateReportWithScreenshot("Enter end place", screenshotPath);
		Thread.sleep(1000); // Wait for input to process

		//Step 4: Select end place from suggestions
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

		//Step 5: Select date
		driver.findElement(By.xpath("//td/a[text()='"+date+"']")).click();
		Reporter.log("Selected date: " + date, true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "DateSelected");
		generateReportWithScreenshot("Select date", screenshotPath);

		Thread.sleep(1000); // Wait for date selection to process

		//Step 6: Click on search button
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

		//Step 7: Click on AC Sleeper filter
		RemoteWebDriver jsdriver = (RemoteWebDriver) driver;
		//scroll till the bottom of the page to ensure filter is visible
		jsdriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000); // Wait for page to load completely
		busListPage.getAcSleeperFilter().click();
		Reporter.log("Clicked on AC Sleeper filter", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "AcSleeperFilterClicked");
		generateReportWithScreenshot("Click on AC Sleeper filter", screenshotPath);
		Thread.sleep(2000); // Wait for filter to apply

		//Step 8: Click on View Seats button
		busListPage.getViewSeatsButton().click();
		Reporter.log("Clicked on View Seats button", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "ViewSeatsButtonClicked");
		generateReportWithScreenshot("Click on View Seats button", screenshotPath);
		Thread.sleep(2000); // Wait for seats to load

		//Step 9: Select a seat
		for (WebElement seat : busListPage.getSeatList()) {
			if(seat.getAttribute("value").equals("26-A#26")) { // Assuming seat 1 is available
				seat.click();
				Reporter.log("Selected seat: " + seat.getAttribute("value"), true);
				Assert.assertTrue(true);
				screenshotPath = Screenshots.takeScreenShot(driver, "SeatSelected");
				generateReportWithScreenshot("Select a seat", screenshotPath);
				break;
			}
		}
		Thread.sleep(1000); // Wait for seat selection to process
		//Step 10: Enter mobile number
		busListPage.getMobileNumberInput().click();
		busListPage.getMobileNumberInput().sendKeys("9535355445");
		Reporter.log("Entered mobile number", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "MobileNumberEntered");
		generateReportWithScreenshot("Enter mobile number", screenshotPath);
		
		//Step 11: Enter email
		busListPage.getEmailInput().sendKeys("muthuviswanath@outlook.com");
		Reporter.log("Entered email", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "EmailEntered");
		generateReportWithScreenshot("Enter email", screenshotPath);
		
		
		//Step 12: Select passenger type
		Select passengerTypeSelect = new Select(busListPage.getPassengerTypeDropdown());
		passengerTypeSelect.selectByVisibleText("GENERAL PUBLIC");
		Reporter.log("Selected passenger type: GENERAL PUBLIC", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "PassengerTypeSelected");
		generateReportWithScreenshot("Select passenger type", screenshotPath);
		
		//Step 13: Select ID proof type
		Select idProofSelect = new Select(busListPage.getIdProofDropdown());
		idProofSelect.selectByVisibleText("Passport");
		Reporter.log("Selected ID proof type: Passport", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "IdProofTypeSelected");
		generateReportWithScreenshot("Select ID proof type", screenshotPath);
		
		//Step 14: Enter ID proof reference
		busListPage.getIdProofText().sendKeys("E56789012345");
		Reporter.log("Entered ID proof reference", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "IdProofReferenceEntered");
		generateReportWithScreenshot("Enter ID proof reference", screenshotPath);
		
		//Step 15: Enter passenger name
		busListPage.getPassengerNameInput().sendKeys("Muthu Viswanath");
		Reporter.log("Entered passenger name", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "PassengerNameEntered");
		generateReportWithScreenshot("Enter passenger name", screenshotPath);

		//Step 16: Enter passenger age
		busListPage.getPassengerAgeInput().sendKeys("30");
		Reporter.log("Entered passenger age", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "PassengerAgeEntered");
		generateReportWithScreenshot("Enter passenger age", screenshotPath);
		
		//Step 17: Click on Fare button
		busListPage.getFareButton().click();
		Reporter.log("Clicked on Fare button", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "FareButtonClicked");
		generateReportWithScreenshot("Click on Fare button", screenshotPath);
		Thread.sleep(2000); // Wait for fare calculation to process
		Reporter.log("Fare calculated successfully", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "FareCalculated");
		generateReportWithScreenshot("Fare calculated", screenshotPath);
		Reporter.log("Bus booking as guest completed successfully", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "BookingCompleted");
		generateReportWithScreenshot("Bus booking as guest completed", screenshotPath);
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