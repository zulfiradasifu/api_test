package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Demo {
    @Test
    public void testNambaFoodTitle()  {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/?language=ru");
        System.out.println(driver.getTitle());
        String expectedTitle = "Namba Food — круглосуточная служба доставки №1 в Бишкеке";
        Assertions.assertEquals(expectedTitle, driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.close();
    }


    @Test
    public void testGoogleSearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("Iphone");
        searchInputField.sendKeys(Keys.ENTER);

        driver.close();
    }
}
