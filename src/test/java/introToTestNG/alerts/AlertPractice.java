package introToTestNG.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertPractice {
    WebDriver webDriver;

    @BeforeClass
    void setWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @Test(description = "Sweet Alert Test - JavaScript Alert")
    void sweetAlertTest() {
        webDriver.get("https://sweetalert.js.org/");
        Reporter.log("Launched sweetalert");
        WebElement alertPreview = webDriver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        alertPreview.click();
        Alert alert = webDriver.switchTo().alert();
        String alertMessage = alert.getText();
        String expectedMessage = "Oops, something went wrong!";
        Assert.assertEquals(alertMessage, expectedMessage, "Alert message test failed.");
        alert.accept();
    }


    @Test(description = "Sweet Alert Test - HTML")
    void sweetAlertHTMLTest() {
        webDriver.get("https://sweetalert.js.org/");
        Reporter.log("Launched sweetalert");
        WebElement alertPreview = webDriver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        alertPreview.click();
        String actualAlertMessage = webDriver.findElement(By.cssSelector("div.swal-text")).getText();
        String expectedAlertMessage = "Something went wrong!";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        webDriver.findElement(By.xpath("//button[contains(@class,'button--confirm') and text()='OK']")).click();
    }


    @Test(description = "JS - Simple Alert Test - Herokuapp")
    void simpleAlertTest() {
        webDriver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Reporter.log("Launched herokuapp");
        WebElement jsAlert = webDriver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlert.click();
        Alert alert = webDriver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS Alert";
        Assert.assertEquals(actualMessage, expectedMessage);
        alert.accept();
        WebElement resultMessage = webDriver.findElement(By.id("result"));
        String expectedResult = "You successfully clicked an alert";
        String expectedColor = "rgb(0, 128, 0)"; //color: Green
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resultMessage.getText(), expectedResult);
        softAssert.assertEquals(resultMessage.getCssValue("color"), expectedColor);
        softAssert.assertAll();
    }

    @Test(description = "JS - Confirmation Alert - Herokuapp")
    void confirmationAlertTest() {
        webDriver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Reporter.log("Launched herokuapp");
        WebElement jsConfirm = webDriver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Alert alert = webDriver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS Confirm";
        Assert.assertEquals(actualMessage, expectedMessage, "Alert Message Test Failed.");
        alert.accept();
        String actualResult = webDriver.findElement(By.id("result")).getText();
        String expectedOKResult = "You clicked: Ok";
        Assert.assertEquals(actualResult, expectedOKResult, "Alert Acceptance Confirmation Result Test Failed.");
        jsConfirm.click();
        alert.dismiss();
        String actualCancelResult = webDriver.findElement(By.id("result")).getText();
        String expectedCancelResult = "You clicked: Cancel";
        Assert.assertEquals(actualCancelResult, expectedCancelResult, "Alert Cancellation Confirmation Result Test Failed.");
    }


    @Test(description = "JS - Prompt Alert - Herokuapp")
    void promptAlertTest() {
        webDriver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Reporter.log("Launched herokuapp");
        WebElement jsPrompt = webDriver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        Alert alert = webDriver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS prompt";
        Assert.assertEquals(actualMessage, expectedMessage, "Alert Message Test Failed.");
        String expectedText="Password";
        alert.sendKeys(expectedText);
        alert.accept();
        WebElement result = webDriver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains(expectedText),"Alert Input Value Test Failed");
        jsPrompt.click();
        alert.dismiss();
        Assert.assertTrue(result.getText().contains("null"),"Alert Null Value for Cancel Option Failed");
        jsPrompt.click();
        alert.accept();
        Assert.assertEquals(result.getText(),"You entered:");
        jsPrompt.click();
        alert.sendKeys(expectedText);
        alert.dismiss();
        Assert.assertFalse(result.getText().contains(expectedText));

    }


    @AfterClass
    void tearDown() {
        webDriver.quit();
    }


}
