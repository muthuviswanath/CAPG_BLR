import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPracto {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.practo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.findElement(By.linkText("Login / Signup")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("muthuviswanath@outlook.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Veny@e71");
	driver.findElement(By.xpath("//button[@id='login']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//div[contains(text(),'Surgeries')]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//div[contains(text(),'Medicines')]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[@href='/health-products/skin-care/l']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[@href='/health-products/acne-care']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//button[text()='ADD'])[1]")).click();
	
}
}
