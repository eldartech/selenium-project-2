package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.get("https://demoqa.com/droppable/");
    }

    @Test
    void dragAndDropTest(){
        WebElement sourceElement  = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(sourceElement,targetElement).perform();
        Assert.assertEquals(targetElement.getCssValue("background-color"),"rgb(70, 130, 180)");
        Assert.assertTrue(targetElement.getCssValue("background-color").contains("70, 130, 180"));
    }

    @Test
    void dragAndDropTestColor(){
        WebElement acceptTab = driver.findElement(By.id("droppableExample-tab-accept"));
        acceptTab.click();
        WebElement sourceAcceptable = driver.findElement(By.id("acceptable"));
        WebElement sourceNotAcceptable = driver.findElement(By.id("notAcceptable"));
        WebElement targetDroppable = driver.findElement(By.cssSelector("div.accept-drop-container > div#droppable"));
        actions.clickAndHold(sourceAcceptable).moveByOffset(10,10).perform();
        Assert.assertEquals(targetDroppable.getCssValue("background-color"),"rgb(60, 179, 113)");
        actions.release().dragAndDrop(sourceAcceptable,targetDroppable).perform();
        Assert.assertEquals(targetDroppable.getCssValue("background-color"),"rgb(70, 130, 180)");
        driver.navigate().refresh();
        try {
            acceptTab.click();
        }catch (StaleElementReferenceException e){
            for (int x=0;x<5;x++){
                WebElement acceptTabStale=driver.findElement(By.id("droppableExample-tab-accept"));
                acceptTabStale.click();
            }
        }
        WebElement source = driver.findElement(By.id("notAcceptable"));
        WebElement target = driver.findElement(By.cssSelector("div.accept-drop-container > div#droppable"));
        actions.dragAndDrop(source,target).perform();
        Assert.assertEquals(target.getCssValue("background-color"),"rgba(0, 0, 0, 0)");

    }

    @Test
    void dragAndDropTestColor2(){
        WebElement acceptTab = driver.findElement(By.id("droppableExample-tab-accept"));
        acceptTab.click();
        WebElement sourceAcceptable = driver.findElement(By.id("acceptable"));
        WebElement sourceNotAcceptable = driver.findElement(By.id("notAcceptable"));
        WebElement targetDroppable = driver.findElement(By.cssSelector("div.accept-drop-container > div#droppable"));
        actions.dragAndDrop(sourceNotAcceptable,targetDroppable).perform();
        Assert.assertEquals(targetDroppable.getCssValue("background-color"),"rgba(0, 0, 0, 0)");
        Assert.assertEquals(targetDroppable.getText(),"Drop here");
        actions.clickAndHold(sourceAcceptable).moveByOffset(10,10).perform();
        Assert.assertEquals(targetDroppable.getCssValue("background-color"),"rgb(60, 179, 113)");
        actions.release().dragAndDrop(sourceAcceptable,targetDroppable).perform();
        Assert.assertEquals(targetDroppable.getCssValue("background-color"),"rgb(70, 130, 180)");
        Assert.assertTrue(targetDroppable.getText().equalsIgnoreCase("dropped!"));

    }






}
