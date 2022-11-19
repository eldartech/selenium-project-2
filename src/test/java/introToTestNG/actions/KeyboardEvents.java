package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyboardEvents {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @Test
    void keyboardActionTest(){
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        WebElement target = driver.findElement(By.id("target"));
        target.sendKeys(Keys.TAB);
    }

    @Test
    void keyboardActionTest2(){
        driver.get("https://www.google.com/");
        WebElement target = driver.findElement(By.name("q"));
      actions.moveToElement(target).keyDown(Keys.SHIFT).sendKeys("apple").keyUp(Keys.SHIFT).perform();
      target.sendKeys(Keys.ARROW_DOWN);
        target.sendKeys(Keys.ARROW_DOWN);
        target.sendKeys(Keys.ENTER);
        for (int i=5;i>0;i--){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();




    }



    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
