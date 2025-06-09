package com.demo.Example;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("file:///D:/Capg_Blr/htmlfiles/demopage.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String parent_window =driver.getWindowHandle(); 
		System.out.println(parent_window);
		WebElement new_window_button = driver.findElement(By.id("open_new_window"));
		new_window_button.click();
		Set<String> windows = driver.getWindowHandles();
		for(String win:windows) {
			if(!win.equals(parent_window)) {
				if(driver.switchTo().window(win).getTitle().equals("Google")){
					driver.switchTo().window(win);
					WebElement searchquery = driver.findElement(By.name("q"));
					searchquery.sendKeys("Selenium");
					Thread.sleep(2000);
				}
				Thread.sleep(2000);
				if(driver.switchTo().window(win).getTitle().equals("YouTube")){
					driver.switchTo().window(win);
					WebElement searchquery = driver.findElement(By.name("search_query"));
					searchquery.sendKeys("Shreya Goshal");
					Thread.sleep(2000);
				}
				Thread.sleep(2000);
				if(driver.switchTo().window(win).getTitle().equals("IRCTC Next Generation eTicketing System")){
					driver.switchTo().window(win);
					WebElement register = driver.findElement(By.linkText("REGISTER"));
					register.click();
					Thread.sleep(2000);
				}
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		WebElement applselect = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));
		Select list = new Select(applselect);
		list.selectByVisibleText("Apple");
		driver.quit();
	}
}
