package com.capg.PomDemo.objectrepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	@FindBy(name = "q")
	private WebElement searchBox;

	WebDriver driver;
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void search(String query) throws InterruptedException {
		searchBox.sendKeys(query);
		Thread.sleep(3000);
		List<WebElement> suggestion_list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for(WebElement ele: suggestion_list) {
			if(ele.getText().equals("donald trump elon musk")) {
				ele.click();
				break;
			}	
		}
		System.out.println("Its time for lunch. Have a feast");
	}

}
