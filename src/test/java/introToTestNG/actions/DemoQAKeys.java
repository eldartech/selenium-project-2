package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static utils.ElementUtils.pageDown;

public class DemoQAKeys {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }
    @Test
    void testKeyBoardButtons() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("John");
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("x").keyUp(Keys.COMMAND).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
        pageDown(driver);
    }
}
