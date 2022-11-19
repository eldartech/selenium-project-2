package introToTestNG.iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Set;

import static utils.ElementUtils.sleep;

public class IframePractice {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    void testIframe1(){
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframe);
        //index= 0
        //id= mce_0_ifr
        //WebElement= driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"))
        WebElement text = driver.findElement(By.id("tinymce"));
        Assert.assertEquals(text.getText(),"Your content goes here.");
        text.clear();
        text.sendKeys("the-internet.herokuapp.com");
        Assert.assertEquals(text.getText(),"the-internet.herokuapp.com");
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(heading.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @Test
    void testNestedIframe(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.tagName("body"));
        Assert.assertTrue(left.getText().equals("LEFT"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.id("content"));
        Assert.assertTrue(middle.getText().equalsIgnoreCase("middle"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertEquals(right.getText(),"RIGHT");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertEquals(bottom.getText(),"BOTTOM");
    }

    @Test
    void testIframe2() throws InterruptedException {
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        WebElement category2= driver.findElement(By.linkText("Category2"));
        category2.click();
        Thread.sleep(2000);
        BrowserUtils.switchWindowByTitle(driver,"BasicJava Archives - qavalidation");
        Assert.assertEquals(driver.getTitle(),"BasicJava Archives - qavalidation");
    }

    @Test(description = "Testing of iframes and window")
    void testingOfIframe(){
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        category3.click();
        String parentID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();
        for (String id:ids){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
            }
        }
        sleep(3000);
        WebElement heading = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']/h1"));
        Assert.assertTrue(heading.getText().startsWith("Category Archives"));

    }
}
