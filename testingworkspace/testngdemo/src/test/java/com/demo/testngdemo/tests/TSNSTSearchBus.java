package com.demo.testngdemo.tests;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.testngdemo.objectrepo.TNSTCHomePage;

public class TSNSTSearchBus {
	WebDriver driver;
	static String baseUrl = "https://www.tnstc.in/OTRSOnline/";
	TNSTCHomePage tnstcHomePage;
	JSONParser jsonParser;
	@BeforeClass
	public void navigation() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl); // Example URL, replace with actual
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void setupTest() {
		tnstcHomePage = new TNSTCHomePage(driver);
		jsonParser = new JSONParser();
	}
	@Test(dependsOnMethods = "login")
	public void searchBus() throws Exception {
		System.out.println("Executed First");
		FileReader freader = new FileReader("./src/test/resources/TestData.json");
		
		//upcasting
		Object obj = jsonParser.parse(freader);
		
		//downcasting
		JSONObject busdetails = (JSONObject) obj;
		
		String source = (String) busdetails.get("source");
		String destn = (String) busdetails.get("destination");
		String traveldate  = (String) busdetails.get("traveldate");
	
		
		tnstcHomePage.searchBus(source, destn, traveldate);
		Thread.sleep(5000);
	}

	@Test
	public void login() throws Exception {
		FileReader freader = new FileReader("./src/test/resources/TestData.properties");
		Properties prop = new Properties();
		prop.load(freader);
		tnstcHomePage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
	}

}
