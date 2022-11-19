package introToTestNG.iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageIframe {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setUp(){
       // System.setProperty("webdriver.chrome.driver","path");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.get("file:///Users/techtorialacademy/Desktop/main.html");
    }

    @Test(description = "Nested Iframe testing")
    void mainPageNestedIframeTest(){
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Amount of iframes in main page: "+iframes.size());
        driver.switchTo().frame("demoqa");
        List<WebElement> iframes2 = driver.findElements(By.tagName("iframe"));
        System.out.println("Amount of iframes in main page: "+iframes2.size());
        WebElement mainHeader = driver.findElement(By.className("main-header"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertEquals(mainHeader.getText(),"Nested Frames");
        WebElement parentIframe = driver.findElement(By.xpath("//iframe[contains(@src,'sampleiframe')]"));
        driver.switchTo().frame(parentIframe);
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(),"Parent frame");
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Child Iframe");
        driver.switchTo().parentFrame();  // switching to 1st parent
        driver.switchTo().parentFrame();  // switching to grand-parent
        Assert.assertEquals(mainHeader.getText(),"Nested Frames");
        driver.switchTo().defaultContent();// switching to HTML node(main node)
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(.,'Elon Musk')]")).getText(),"Elon Musk");


    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
