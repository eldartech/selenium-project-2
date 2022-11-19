package introToTestNG.testNgParameterization;

import introToTestNG.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PhptravelsLogIn extends TestBase {


    @Test(dataProvider = "credentials",dataProviderClass = PhpTravelsTestData.class)
    void phpLogInTest(String username,String password){
        driver.navigate().to("https://www.phptravels.net/login");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
