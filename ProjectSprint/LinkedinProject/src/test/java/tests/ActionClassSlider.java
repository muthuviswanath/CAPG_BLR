package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassSlider {
	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.id("slider"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 25, 0).perform();
	
	}
}
