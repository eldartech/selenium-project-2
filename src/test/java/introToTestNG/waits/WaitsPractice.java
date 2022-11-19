package introToTestNG.waits;

import introToTestNG.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsPractice extends TestBase {
    @Test(description = "Test to wait to see webelement name ")
    void test1() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.findElement(By.xpath("//button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement changingText = driver.findElement(By.id("demo"));
        wait.until(ExpectedConditions.textToBePresentInElement(changingText,"WebDriver"));
        Assert.assertTrue(changingText.isDisplayed(), "failed");
    }
}
