package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    //1. create private static WebDriver
    private static WebDriver driver;

    //2. private constructor, to prevent instantiation of class(create object)
    // from another classes
    private Driver() {}

    //3.create the public method to access the webdriver
    public static WebDriver getDriver(String driverName) {
        if (driver == null) {
            switch (driverName.toLowerCase()) {
                case "gridchrome":
                    String url = "http://13.59.7.33:4444";//13.59.7.33
                    File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
                    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                    desiredCapabilities.setBrowserName("chrome");
                    desiredCapabilities.setPlatform(Platform.ANY);
                    try {
                        driver = new RemoteWebDriver(new URL(url),desiredCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        }
        return driver;
    }
}
