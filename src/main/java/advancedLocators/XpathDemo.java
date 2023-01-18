package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathDemo {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void testFindByXpath(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Kamila");

        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kamila@mail.ru");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Bishkek");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Karakol");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.close();

    }
}
