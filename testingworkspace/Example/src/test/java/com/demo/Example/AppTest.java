package com.demo.Example;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("file:///D:/Capg_Blr/htmlfiles/demopage.html");
		Thread.sleep(2000);
		WebElement country_list = driver.findElement(By.xpath("//select[@id='countryselect']"));
		Select dropdown = new Select(country_list);

		//dropdown.selectByIndex("Nepal");
		//dropdown.selectByContainsVisibleText("Nepal");
		//dropdown.selectByValue("BAN");
		dropdown.selectByVisibleText("South Africa");


		WebElement fruit_list = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));
		Select fruits = new Select(fruit_list );
		for(int i=0; i<7;i++) {
			if (i%2 == 0) fruits.selectByIndex(i);
		}
		
		WebElement alert_text = driver.findElement(By.xpath("//input[@id='name']"));
		alert_text.sendKeys("Aravind");
		Thread.sleep(2000);
		WebElement alert_btn = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		alert_btn.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alert_msg = alert.getText();
		System.out.println("Alert Mesasge: " + alert_msg);
		Thread.sleep(2000);
		alert.dismiss();



	}
}
