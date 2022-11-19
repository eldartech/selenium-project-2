package introToTestNG.windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Set;

public class WindowIntro {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testWindow1(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        System.out.println("Page info before switch: ");
        System.out.println("Parent: "+driver.getTitle());
        clickHereButton.click();
        System.out.println("Child: "+driver.getTitle());
        System.out.println("Url Child: "+driver.getCurrentUrl());
        String parentID = driver.getWindowHandle();
        Set<String> pageIDs = driver.getWindowHandles();
        for (String id: pageIDs) {
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
            }
        }
        System.out.println("Page info after switch: ");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        System.out.println("switching back to parent");
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


    }
    @Test
    void testWindow2(){
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        String parentID = driver.getWindowHandle();
//        Set<String> pageIDs = driver.getWindowHandles();
//        Iterator<String> iterator = pageIDs.iterator();
//        while (iterator.hasNext()){
//            String currentID = iterator.next();
//            if (!currentID.equals(parentID)){
//                driver.switchTo().window(currentID);
//            }
//        }
        BrowserUtils.switchWindowByURL(driver,driver.getCurrentUrl());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"This is a sample page");

    }
}
