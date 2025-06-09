package com.demo.testngdemo.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.demo.testngdemo.objectrepo.IrctcHomePage;
import com.demo.testngdemo.objectrepo.TrainListPage;


public class TestNgAnnotations {
/*
 * @BeforeSuite - Before starting the suite: Setup system properties for the suite.
 * @BeforeTest - Before the start if the test: Setup test-specific configurations.
 * @BeforeClass - Before the class: Initialize the web browser, navigation steps, setup configurations.
 * @BeforeMethod - Before each test method: Setup preconditions for each test method.
 * @test - Test method: Execute the actual test case.
 * @AfterMethod - After each test method: Cleanup after each test method execution.
 * @AfterClass - After the class: Close the web browser and perform any necessary cleanup.
 * @AfterTest - After the test: Perform any cleanup after the test execution.
 * @AfterSuite - After the suite: Final cleanup after all tests in the suite have run.
 *
 * */
	
	WebDriver driver;
	String baseUrl;
	IrctcHomePage irctcHomePage;
	TrainListPage trainListPage;
	@BeforeSuite
	public void setupSuite() {
		// Setup system properties for the suite
		Reporter.log("Setting up system properties for the suite.");
		Reporter.log("Choosing the QA Server for testing.");
		
	
	}
	
	@BeforeTest
	public void setupTest() {
		baseUrl = "https://www.irctc.co.in/nget/train-search"; // Example URL, replace with actual
		// Setup test-specific configurations
		Reporter.log("Setting up test-specific configurations.");
		Reporter.log("Setting up the test environment.");
	}
	@BeforeClass
	public void setupClass() {
	driver = new ChromeDriver();
	driver.navigate().to(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	irctcHomePage = new IrctcHomePage(driver);
	}
	
//	@BeforeMethod
//	public void Login() throws InterruptedException {
//		irctcHomePage.logIntoApp("mutviswa", "Uht5tfpm");
//	}
	
	@Test
	public void testChooseTrain() throws InterruptedException {
		// Test case to choose a train
		irctcHomePage.chooseTrain("SBC", "MAS");
		Reporter.log("Train search executed successfully.");
	}
//	@AfterMethod
//	public void logout() {
//		trainListPage = new TrainListPage(driver);
//		trainListPage.logout();
//	}
	
	@AfterClass
	public void tearDownClass() {
		// Close the web browser and perform any necessary cleanup
		if (driver != null) {
			driver.quit();
			Reporter.log("Browser closed successfully.");
		}
	}
	
	
}
