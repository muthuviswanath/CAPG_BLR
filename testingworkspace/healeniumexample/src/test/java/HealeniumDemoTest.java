

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealeniumDemoTest {
    public static void main(String[] args) {
        WebDriver base = new ChromeDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(base);

        try {
            driver.get("http://127.0.0.1:5500/check.html");

            // Give time for ID randomization and dynamic changes
            Thread.sleep(6000);

            // 1️ Heal randomized ID
            WebElement loginBtn = driver.findElement(By.id("login-btn"));
            loginBtn.click();
            System.out.println("✅ Clicked login button");

            // 2️ Hidden element now visible
            WebElement hiddenDiv = driver.findElement(By.id("hidden-div"));
            System.out.println("👀 Hidden text now visible: " + hiddenDiv.getText());

            // 3️ Button renamed to “Submit Request”
            WebElement renamed = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            renamed.click();
            System.out.println("✅ Renamed button clicked");

            // 4️ Toggle content div
            WebElement toggle = driver.findElement(By.id("toggle-section"));
            toggle.click();
            System.out.println("🔁 Clicked toggle section");

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
