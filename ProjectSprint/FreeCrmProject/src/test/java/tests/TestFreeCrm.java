package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import repo.CogmentoDashboard;
import repo.CogmentoLoginPage;
import repo.CompaniesPage;
import repo.FreeCrmHomePage;

public class TestFreeCrm {
	WebDriver driver;
	FreeCrmHomePage freeCrmHomePage;
	CogmentoLoginPage cogmentoLoginPage;
	CogmentoDashboard cogmentoDashboard;
	CompaniesPage companiesPage;

	@BeforeClass
	public void setUpBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		freeCrmHomePage = new FreeCrmHomePage(driver);
		cogmentoLoginPage = new CogmentoLoginPage(driver);
		cogmentoDashboard = new CogmentoDashboard(driver);
		companiesPage = new CompaniesPage(driver);

	}
	@Test
	public void testLoginAndNavigateToCompanies() throws Exception {
		// Navigate to the login page
		freeCrmHomePage.getStartHereLink().click();

		// Perform login
		cogmentoLoginPage.getUsername().sendKeys("chakribandaru333@gmail.com");
		cogmentoLoginPage.getPassword().sendKeys("Qaz@4545");
		cogmentoLoginPage.getLoginButton().click();

		// Verify that the dashboard is displayed
		assert cogmentoDashboard.getMainNav().isDisplayed() : "Dashboard not displayed";

		// Navigate to Companies page
		cogmentoDashboard.getCompaniesLink().click();

		// Verify that the Companies page is displayed
		assert companiesPage.getCreateButton().isDisplayed() : "Companies page not displayed";

		// Click on Create button
		companiesPage.getCreateButton().click();

		// Verify that the upload image field is displayed
		companiesPage.getUploadImage().click();
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		
		// To copy [Simulating Ctrl + c]
		StringSelection file = new StringSelection("D:\\images.xbm");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		// To paste [Simulating Ctrl + v]
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Simulate Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File uploaded successfully!");


	}
}
