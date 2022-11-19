package introToTestNG.select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MDBMultipleSelections {
    @Test
    public void testMultipleSelections(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://demoqa.com/select-menu");
        WebElement dropDown= driver.findElement(By.xpath("//div[@id='select-wrapper-808180']"));
//        Select select=new Select(dropDown);
//        select.selectByIndex(2);
        dropDown.click();
    }
}
