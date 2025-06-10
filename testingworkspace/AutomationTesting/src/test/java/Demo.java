import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver drv = new ChromeDriver();
		drv.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);
		drv.manage().window().maximize();
		Thread.sleep(3000);
		drv.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(3000);
		drv.findElement(By.id("userName")).sendKeys("muthuviswanath");
		drv.findElement(By.xpath("(//input[@id='userName'])[1]")).sendKeys("Muthu Viswanathan");
		
	}
}
