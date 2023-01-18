package advancedMouseInteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PracticeActions {
    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testDoubleClick(){
        driver.get("https://demoqa.com/buttons");
        actions = new Actions(driver);
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClickButton).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assertions.assertTrue(doubleClickMessage.getText().contains("You have done a double click"));

    }

    @Test
    public void testRightClick() {

        driver.get("https://demoqa.com/buttons");
        actions = new Actions(driver);
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assertions.assertTrue(rightClickMessage.getText().contains("You have done a right click"));
    }

    @Test
    public void testSimpleClick(){
        actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        WebElement simpleClickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(simpleClickButton).perform();
        WebElement simpleClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assertions.assertTrue(simpleClickMessage.getText().contains("You have done a dynamic click"));
    }

    @AfterEach
    public void closeDriver(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}