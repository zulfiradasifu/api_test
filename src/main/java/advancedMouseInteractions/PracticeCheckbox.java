package advancedMouseInteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PracticeCheckbox {

        WebDriver driver;
        Actions actions;

        @BeforeEach
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            actions = new Actions(driver);
        }

     @Test
    public void testCheckbox() {
         driver.get("https://demoqa.com/checkbox");
         WebElement checkboxButton = driver.findElement(By.xpath("//button[@title='Toggle'][1]"));
         checkboxButton.click();

         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

     }
}
