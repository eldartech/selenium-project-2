package introToTestNG.select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDiary {
    @Test
    public void testDropDownShirts() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement dropDown1= driver.findElement(By.cssSelector("select#Shirts"));
        Select select=new Select(dropDown1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Shirt","Shirts Drop Down Validation Failed.");
        select.selectByIndex(1);
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red Shirt","Shirts Drop Down Validation Failed.");
        select.selectByValue("yellow");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Yellow Shirt","Shirts Drop Down Validation Failed.");
        select.selectByVisibleText("Blue Shirt");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Shirt","Shirts Drop Down Validation Failed.");
        driver.quit();
    }

    @Test
    public void testDropDownSkirts() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement dropDown1= driver.findElement(By.cssSelector("select#Skirts"));
        Select select=new Select(dropDown1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Skirt","Skirts Drop Down Validation Failed.");
        select.selectByIndex(1);
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red Skirt","Skirts Drop Down Validation Failed.");
        select.selectByValue("YellowSkirt");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Yellow Skirt","Skirts Drop Down Validation Failed.");
        select.selectByVisibleText("Blue Skirt");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Skirt","Skirts Drop Down Validation Failed.");
        driver.quit();
    }
}
