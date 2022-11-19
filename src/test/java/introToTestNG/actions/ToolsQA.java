package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ToolsQA {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
        driver.get("https://demoqa.com/buttons");
    }

    @Test(description = "Test for dynamic click.")
    void testClick() {
        WebElement clickButton=driver.findElement(By.xpath("//button[.='Click Me']"));
        assertTrue(clickButton.isEnabled(),"Testing Click isEnabled Failed");
        actions.click(clickButton).perform();
        WebElement clickMessage=driver.findElement(By.id("dynamicClickMessage"));
        assertEquals(clickMessage.getText(),"You have done a dynamic click","Test Click Message Failed");
    }

    @Test(description = "Test Right Click.")
    void testRightClick() {
        WebElement rightClick= driver.findElement(By.xpath("//button[.='Right Click Me']"));
        assertTrue(rightClick.isEnabled(),"Testing Right Click isEnabled Failed");
        actions.contextClick(rightClick).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        assertEquals(rightClickMessage.getText(),"You have done a right click","Test Right Click Message Failed");
    }

    @Test(description = "Test Double Click.")
    void testDoubleClick() {
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(.,'Double Click')]"));
        Assert.assertTrue(doubleClickButton.isEnabled(),"Testing Double Click isEnabled Failed");
        actions.doubleClick(doubleClickButton).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(doubleClickMessage.getText(),"You have done a double click","Test Double Click Message Failed");

    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
