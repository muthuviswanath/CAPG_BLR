package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NoBrokerHiddenElements {
	static WebDriver driver;

		public static void main(String[] args) throws Exception{
			ChromeOptions chrome_options = new ChromeOptions();
			Map<String, Object> chromeprefs = new HashMap<String, Object>();
			chromeprefs.put("profile.default_content_settings.popups",1);
			chromeprefs.put("profile.default_content_setting_values.notifications",1);
			chromeprefs.put("profile.default_content_setting_values.geolocation",1);
			chrome_options.setExperimentalOption("prefs", chromeprefs);
			driver = new ChromeDriver(chrome_options);

			driver.manage().window().maximize();
			driver.get("https://www.nobroker.in/bangalore/commercial_rent");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			Thread.sleep(2000); // Wait for the suggestions to load
			
			// Step 1: Search for locality
			WebElement searchlocality = driver.findElement(By.id("listPageSearchLocality"));
			searchlocality.click();
			searchlocality.sendKeys("BTM");
			Thread.sleep(4000); // Wait for the suggestions to load
			
			// Step 2: Use JavaScript to display the hidden autocomplete list
			WebElement autocompletelist= driver.findElement(By.id("autocomplete-dropdown-container"));
			String javascript = "var element = arguments[0];" +
					"element.style.display = 'block';";
			((JavascriptExecutor) driver).executeScript(javascript, autocompletelist);
			
			// Step 3: Click on the second option in the autocomplete list
			WebElement secondoption = driver.findElement(By.xpath("//div[@id='autocomplete-dropdown-container']/div[1]"));
			secondoption.click();
			Thread.sleep(2000); // Wait for the page to load
			
			// Step 4: Click on the "Property Type" dropdown
			WebElement propertytype = driver.findElement(By.xpath("//div[text()='Property Type']"));
			propertytype.click();
			Thread.sleep(2000); // Wait for the property type options to load
			
			// Step 5: Use JavaScript to display the hidden property type list
			WebElement propertylist = driver.findElement(By.xpath("//div[@class=contains(text(),'nb-select__menu')]"));
			String propertylistjavascript = "var element = arguments[0];" +
					"element.style.display = 'block';";
			((JavascriptExecutor) driver).executeScript(propertylistjavascript, propertylist);
			
			// Step 6: Click on the "Showroom" option in the property type list
			WebElement propertyoption = driver.findElement(By.xpath("//div[@class=contains(text(),'nb-select__menu')]//input[@value='SHOWROOM']"));
			propertyoption.click();
			Thread.sleep(2000); // Wait for the page to load
			
			// Step 7: Click on the "Search" button
			WebElement searchbutton = driver.findElement(By.xpath("//button[text()='Search']"));
			searchbutton.click();
			Thread.sleep(5000); // Wait for the search results to load
			
		}
	}
