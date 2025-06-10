package com.capg.PomDemo.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.capg.PomDemo.objectrepository.GooglePage;

public class Lunch {
	static WebDriver driver;
	static String baseURL = "https://www.google.com";
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		GooglePage g = new GooglePage(driver);
		g.search("donal trump");
	}
}
