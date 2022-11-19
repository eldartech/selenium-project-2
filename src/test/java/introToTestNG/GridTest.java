package introToTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void testGrid() throws MalformedURLException {
        String url = "http://13.59.7.33:4444";
        URL url1=new URL(url);
        File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(url1,desiredCapabilities);
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium Grid"+ Keys.ENTER);

    }
}
