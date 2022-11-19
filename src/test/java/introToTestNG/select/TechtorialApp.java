package introToTestNG.select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.ElementUtils.getTexts;

public class TechtorialApp {
    @Test
    void test1(){
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("file:///Users/techtorialacademy/Downloads/Techtorial%20(2).html");
        List<WebElement> leftMenuOptions1=driver.findElements(By.cssSelector("tr.mouseOut"));
        List<String> expectedMenuOptions= Arrays.asList("Home","Java","Selenium","Cucumber","TestNG","Rest Api","SQL");
        List<String> actualMenuOptions=getTexts(leftMenuOptions1);
        Assert.assertEquals(actualMenuOptions,expectedMenuOptions);
    }

    @Test
    void validateDefaultCountry(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorial%20(2).html");
        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("phone")).sendKeys("1231231234");
        driver.findElement(By.name("userName")).sendKeys("john.doe@gmail.com");
        driver.findElement(By.name("address1")).sendKeys("4101 Ravenswood");
        driver.findElement(By.name("address2")).sendKeys("suite 116");
        driver.findElement(By.name("city")).sendKeys("Fort Lauderdale");
        driver.findElement(By.name("state")).sendKeys("Florida");
        driver.findElement(By.name("postalCode")).sendKeys("432243");
        Select selectCountry=new Select(driver.findElement(By.name("country")));
        Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(),"UNITED STATES");
    driver.close();
    }

    @Test
    void validateCountrySelection(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorial%20(2).html");
        Select selectCountry=new Select(driver.findElement(By.name("country")));
        selectCountry.selectByIndex(0);
        Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(),"ALBANIA","Test Fist Option");
        selectCountry.selectByIndex(selectCountry.getOptions().size()-1);
        Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(),"ZIMBABWE","Test Last Option");
        selectCountry.selectByVisibleText("FINLAND");
        Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(),"FINLAND","Test Option By Visible Text");
        selectCountry.selectByValue("210");
        Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(),"UGANDA","Test Option By Value");
        driver.close();
    }

    @Test
    void validateCountOfCountries(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorial%20(2).html");
        Select selectCountry=new Select(driver.findElement(By.name("country")));
        Assert.assertEquals(selectCountry.getOptions().size(),264,"Test Count of Countries Failed");
        driver.close();
    }

    @Test
    void validateSortingOfOptions(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorial%20(2).html");
        Select selectCountry=new Select(driver.findElement(By.name("country")));
        List<WebElement> countryElements=selectCountry.getOptions();
        ArrayList<String> actualList = new ArrayList<>();
        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement country: countryElements){
            actualList.add(country.getText());
           // expectedList.add(country.getText());
        }
        expectedList.addAll(actualList);
        Collections.sort(expectedList);
        Assert.assertEquals(actualList,expectedList);
        driver.close();
    }










}
