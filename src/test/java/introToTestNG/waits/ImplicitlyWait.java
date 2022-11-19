package introToTestNG.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    void test1(){
        driver.get("https://www.expedia.com/");
        WebElement goingTo = driver.findElement(By.xpath("//button[@aria-label='Going to']/preceding-sibling::input"));
        WebElement submit = driver.findElement(By.xpath("//button[@data-testid='submit-button']"));
        goingTo.click();
        goingTo.sendKeys("New York"+ Keys.RETURN);
        submit.click();
    }


    @Test(description = "Implicit wait test")
    void herokuAppDynamicControl(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");
    }

}
