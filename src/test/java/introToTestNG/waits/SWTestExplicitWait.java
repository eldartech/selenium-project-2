package introToTestNG.waits;

import introToTestNG.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static utils.ElementUtils.visibilityOfElementLocated;


public class SWTestExplicitWait extends TestBase {

    @Test(description = "Test without explicit wait")
    void swTestWithoutWaits(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        datePicker(15).click();
//        invisibilityOfElementLocated(driver,3,By.id("raDiv"));
        WebElement selectedDate=visibilityOfElementLocated(driver,6,By.id("ctl00_ContentPlaceholder1_Label1"));


        Assert.assertEquals(selectedDate.getText().toUpperCase(),getExpectedDate(15));
    }

    public WebElement datePicker(int date){
        return driver.findElement(By.xpath("//a[text()='"+date+"']"));
    }

    public String getExpectedDate(int date){
        LocalDate currentDate = LocalDate.now();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();
        DayOfWeek dayOfWeek=LocalDate.of(year,month,date).getDayOfWeek();
        return String.format("%s, %s %d, %d",dayOfWeek.toString(),month,date,year);
    }
}
