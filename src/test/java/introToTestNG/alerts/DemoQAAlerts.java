package introToTestNG.alerts;

import introToTestNG.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.ElementUtils.sleep;

public class DemoQAAlerts extends TestBase {


    @Test(description = "Demo QA - Simple Alert Test")
    void simpleAlertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement simpleAlertClick = driver.findElement(By.id("alertButton"));
        simpleAlertClick.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "You clicked a button";
        Assert.assertEquals(actualMessage,expectedMessage,"Alert Message Test Failed.");
        Thread.sleep(2000);
        alert.accept();
        driver.close();
    }

    @Test(description = "Demo QA -  Simple test time delay")
    void simpleAlertTimeDelayTest(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.cssSelector("#timerAlertButton"));
        clickButton.click();
        sleep(6000);
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "This alert appeared after 5 seconds";
        Assert.assertEquals(actualMessage,expectedMessage,"Alert Message Test Failed.");
        alert.accept();
    }

    @Test(description = "Confirm Alert Test")
    void confirmAlertTest(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Do you confirm action?";
        Assert.assertEquals(actualMessage,expectedMessage,"Alert Message Test Failed.");
        alert.accept();
        WebElement result = driver.findElement(By.id("confirmResult"));
        Assert.assertTrue(result.getText().contains("Ok"));
        clickButton.click();
        alert.dismiss();
        Assert.assertTrue(result.getText().contains("Cancel"));
    }

    @Test(description = "Demo QA - Prompt Alert Test")
    void promptAlertTest(){
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Please enter your name";
        Assert.assertEquals(actualMessage,expectedMessage,"Alert Message Test Failed.");
        String expectedText = "password";
        alert.sendKeys(expectedText);
        alert.accept();
        WebElement result = driver.findElement(By.id("promptResult"));
        Assert.assertTrue(result.getText().contains(expectedText));
    }
}


























