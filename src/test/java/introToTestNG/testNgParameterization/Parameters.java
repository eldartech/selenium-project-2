package introToTestNG.testNgParameterization;

import introToTestNG.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Parameters extends TestBase {
    @org.testng.annotations.Parameters("toolName")
    @Test(description = "without parameters")
    void test1(String name){
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));

        searchBox.sendKeys(name+ Keys.RETURN);
    }
}
