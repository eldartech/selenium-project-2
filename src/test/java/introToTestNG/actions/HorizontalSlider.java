package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HorizontalSlider {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    void testSlider1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement sliderPoint = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(sliderPoint).moveByOffset(55,0).release().perform();
        WebElement range = driver.findElement(By.cssSelector("span#range"));
        String maxRange = "5";
        Assert.assertEquals(range.getText(),maxRange);
        Thread.sleep(2000);
        actions.clickAndHold(sliderPoint).moveByOffset(-55,0).release().perform();
        String minRange = "0";
        assertTrue(range.getText().equals(minRange));
        actions.moveToElement(sliderPoint).sendKeys(Keys.RIGHT).perform();

    }

    //keep moving the slider towards the max range
    //it should move one step at the time
    @Test
    void sliderAllRangeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement sliderPoint = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.cssSelector("span#range"));
        int xOffset = -45;
        double expectedRange = 0.5;
        while (!range.getText().equals("5")){
            actions.clickAndHold(sliderPoint)
                    .moveByOffset(xOffset,0)
                    .release()
                    .perform();
            xOffset+=10;
            Thread.sleep(1000);
            String actual = range.getText().contains(".")?range.getText():range.getText().concat(".0");
            System.out.println(actual);
            Assert.assertEquals(actual,""+expectedRange);
            expectedRange+=0.5d;
        }
    }

    @Test
    void sliderAllRangeTest2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement sliderPoint = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.cssSelector("span#range"));
        actions.clickAndHold(sliderPoint).moveByOffset(-55,0).perform();
        while (!range.getText().equals("5")){
            actions.sendKeys(Keys.UP)
                    .perform();
            Thread.sleep(1000);
        }
    }

    @Test
    void verticalSliderTest(){
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");
        WebElement dragPointer = driver.findElement(By.xpath("//span[@aria-orientation='vertical']"));
        WebElement tenPoint = driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='10']"));
        WebElement zeroPoint = driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='0']"));

        Point locationTen = tenPoint.getLocation();
        Point locationZero = zeroPoint.getLocation();
        System.out.println(locationTen.getX()+","+locationTen.getY());
        System.out.println(locationZero.getX()+","+locationZero.getY());
        System.out.println(locationTen.getY()-locationZero.getY());

        actions.clickAndHold(dragPointer).moveByOffset(0,-95).release().perform();
        actions.clickAndHold(dragPointer).moveByOffset(0,50).release().perform();

    }



    @AfterClass
    void tearDown(){
        driver.quit();
    }



}
