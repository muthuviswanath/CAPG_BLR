package com.capgemini.driversetup;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SetupDriver {

	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;		
		if(driver == null) {
			switch(browserName.toLowerCase()) {
			case "chrome":
				ChromeOptions chrome_options = new ChromeOptions();
				Map<String, Object> chromeprefs = new HashMap<String, Object>();
				chromeprefs.put("profile.default_content_settings.popups",1);
				chromeprefs.put("profile.default_content_setting_values.notifications",1);
				chromeprefs.put("profile.default_content_setting_values.geolocation",1);
				chrome_options.setExperimentalOption("prefs", chromeprefs);
				driver = new ChromeDriver(chrome_options);
				break;
			case "edge":
				EdgeOptions edge_options = new EdgeOptions();
				Map<String, Object> edgeprefs = new HashMap<String, Object>();
				edgeprefs.put("profile.default_content_settings.popups",1);
				edgeprefs.put("profile.default_content_setting_values.notifications",1);
				edgeprefs.put("profile.default_content_setting_values.geolocation",1);
				edge_options.setExperimentalOption("prefs", edgeprefs);
				driver = new EdgeDriver(edge_options);
				break;
			case "firefox":
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("dom.disable_open_during_load", false);
				profile.setPreference("dom.webnotifications.enabled", true);
				profile.setPreference("permissions.default.desktop-notification", 1);
				profile.setPreference("permissions.default.geo", 1);
				FirefoxOptions ffoptions = new FirefoxOptions();
				ffoptions.setProfile(profile);
				driver = new FirefoxDriver(ffoptions);
				break;

			default:
				throw new IllegalArgumentException("Browser not supported: " + browserName);
			}
		}
		return driver;
	}

}
