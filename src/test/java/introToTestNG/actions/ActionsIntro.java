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

import java.util.List;

public class ActionsIntro {
    WebDriver chrome;


    @AfterClass
    void tearDown(){
        chrome.quit();
    }
    @Test
    void herokuHoverTest(){

        chrome.navigate().to("https://the-internet.herokuapp.com/hovers");
        chrome.manage().window().maximize();
        WebElement user1=chrome.findElement(By.xpath("//h5[.='name: user1']/parent::div/preceding-sibling::img"));
        Actions actions = new Actions(chrome);
        actions.moveToElement(user1).perform();

    }

    @Test
    void herokuHoverTestAction(){
        chrome.navigate().to("https://the-internet.herokuapp.com/hovers");
        chrome.manage().window().maximize();
        List<WebElement> users = chrome.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> userHeadings = chrome.findElements(By.tagName("h5"));
        Actions actions=new Actions(chrome);
        int i=0;
        for (WebElement user:users) {
            actions.moveToElement(user).perform();

            Assert.assertTrue(userHeadings.get(i++).getText().contains("name: user"));
        }
    }
    @Test
    void herokuContextClickTest(){
        chrome.navigate().to("https://the-internet.herokuapp.com//context_menu");
        chrome.manage().window().maximize();

        Actions actions=new Actions(chrome);
        actions.contextClick(chrome.findElement(By.cssSelector("div#hot-spot"))).perform();


    }

 /*   @Test
    void herokuContextClickTest2(){
        chrome.navigate().to("https://the-internet.herokuapp.com//context_menu");
        chrome.manage().window().maximize();

        Actions actions=new Actions(chrome);
        Action action=actions.moveToElement(chrome.findElement(By.cssSelector("div#hot-spot"))).contextClick().build();
        action.perform();

    }*/

    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        chrome=new ChromeDriver();
    }
}
