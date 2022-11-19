package introToTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static utils.ElementUtils.getTexts;
import static utils.ElementUtils.sleep;

public class LogInTest {
    WebDriver driver;


    @BeforeClass
    void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Reporter.log("Chrome Browser Launched.");
        driver.manage().window().maximize();
    }

    @Test(description = "Log In Test practicetestautomation.com")
    void testLogIn(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Reporter.log("practicetestautomation.com Launched.");
        WebElement username=driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        submitButton.click();
        String expectedURL = "practicetestautomation.com/logged-in-successfully/";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedURL));
        Reporter.log("Logged in to practicetestautomation.com");
    }

    @Test(description = "Welcome Page Test", dependsOnMethods = "testLogIn")
    void testWelcomePage(){
        //Actual
        WebElement title = driver.findElement(By.className("post-title"));
        WebElement content = driver.findElement(By.xpath("//div[@class='post-content']/p"));
        List<WebElement> menuItems = driver.findElements(By.xpath("//li[starts-with(@id,'menu-item-')]"));
        WebElement logOutButton = driver.findElement(By.xpath("//a[starts-with(@class,'wp-block-button')]"));
        //Expected
        String expectedTitle = "Logged In Successfully";
        String expectedContent = "Congratulations student. You successfully logged in!";
        List<String> expectedMenuItems = Arrays.asList("HOME","PRACTICE","COURSES","BLOG","CONTACT");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(title.getText(),expectedTitle,"Title test failed!");
        softAssert.assertEquals(content.getText(),expectedContent,"Content test failed!");
        softAssert.assertEquals(getTexts(menuItems),expectedMenuItems,"List of Menu Item Test Failed.");
        softAssert.assertTrue(logOutButton.isEnabled(),"Log Out button test failed. It is not Enabled.");
        softAssert.assertAll();
        sleep(7000);
    }

    @Test(description = "Log Out Test")
    void logOutTest(){
        WebElement logOutButton = driver.findElement(By.xpath("//a[starts-with(@class,'wp-block-button')]"));
        logOutButton.click();
        WebElement header = driver.findElement(By.cssSelector("section[id='login'] > h2"));
        String expectedHeader = "Test login";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("practice-test-login"));
        softAssert.assertEquals(header.getText(),expectedHeader,"Header test failed");
        softAssert.assertAll();
    }


    @AfterClass
    void tearDown(){
        driver.quit();
        Reporter.log("Driver was teared down.");
    }
}
