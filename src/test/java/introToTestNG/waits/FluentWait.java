package introToTestNG.waits;

import introToTestNG.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static utils.ElementUtils.fluentWait;

public class FluentWait extends TestBase {

    @Test(description = "Heroku app - fluent wait test")
    void fluentTest1(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//total time to wait
                .pollingEvery(Duration.ofSeconds(3))//frequency to check
                .ignoring(NoSuchElementException.class);//ignoring the exception

        WebElement message = wait.until(e -> e.findElement(By.id("message")));
        String actualMessage = message.getText();
        String expectedMessage = "It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        By message2=By.id("message");
        fluentWait(driver,20,5,message2);
        softAssert.assertEquals(driver.findElement(message2).getText(),"It's back!");
        softAssert.assertAll();

    }

    @Test(description = "wait for alert")
    void waitAlertTest(){
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }









}
