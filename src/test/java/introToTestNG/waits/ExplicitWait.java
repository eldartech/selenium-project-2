package introToTestNG.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static utils.ElementUtils.invisibilityOfElementLocated;

public class ExplicitWait {

    WebDriver driver;
    @BeforeClass
    void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Explicitly Wait - Heroku App")
    void testExplicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement message  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));//its gone
        Assert.assertEquals(message.getText(),"It's gone!");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        String actualMessage = driver.findElement(By.id("message")).getText();
        String expectedMessage = "It's back!";
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        invisibilityOfElementLocated(driver,6,By.id("loading"));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(),"It's gone!");


    }
}
