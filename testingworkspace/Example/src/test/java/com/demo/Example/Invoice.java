package com.demo.Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoice {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("file:///D:/Capg_Blr/htmlfiles/demopage.html");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
}
}
