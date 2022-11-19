package introToTestNG.jsExecutor;

import introToTestNG.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static utils.JSExecutorUtils.*;

public class JSPractice extends TestBase {
    @Test
    void jsExecutorTest1() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //navigating to URL
        js.executeScript("window.location= 'http://amazon.com/'");
        //getting current window title
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);
        WebElement cart = driver.findElement(By.cssSelector("span[class='nav-cart-icon nav-sprite']"));
        // clicking an element
        js.executeScript("arguments[0].click();",cart);
        String titleCart = js.executeScript("return document.title;").toString();
        System.out.println(titleCart);
        //get current URL
        String currentURL= js.executeScript("return document.URL;").toString();
        System.out.println(currentURL);
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        //Highlighting the element
        String script = "arguments[0].style.border='2px solid red'";
        js.executeScript(script,amazonLogo);
        js.executeScript("arguments[0].click();",amazonLogo);
        //Scroll by using the X and Y coordinates
        WebElement copyRight = driver.findElement(By.xpath("//div[contains(@class,'navFooterCopyright')]/span"));
       Point copyRightLocation = copyRight.getLocation();
       int xAxis=copyRightLocation.getX();
       int yAxis=copyRightLocation.getY();
       String scriptLocation = String.format("window.scrollTo(%d,%d)",xAxis,yAxis);
        js.executeScript("window.scrollTo("+xAxis+","+yAxis+")");
        //scroll to the view of element
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        js.executeScript("arguments[0].scrollIntoView(true);",searchBox);
        Thread.sleep(2000);
        //Refresh current page
        js.executeScript("history.go(0)");
        js.executeScript("alert('Welcome to Amazon');");
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }

    @Test
    void jsExecutorTest(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        jsNavigate(driver,"https://tutorialshut.com/demo-website-for-selenium-automation-practice/");
        //jsScroll(driver);
        WebElement submit =driver.findElement(By.id("submit"));
        jsSendKeys(driver,driver.findElement(By.id("comment")),"Hello!");
        jsSendKeys(driver,driver.findElement(By.xpath("//input[@name='author']")),"John001");
        jsSendKeys(driver,driver.findElement(By.id("email")),"john@gmail2.com");
        jsSendKeys(driver,driver.findElement(By.xpath("//input[@name='url']")),"techtorial2.com");
        jsScroll(driver,submit);
        jsHighlight(driver,submit);
        jsClick(driver,submit);
        jsScrollBy(driver,100,100);


//        js.executeScript("document.getElementById('comment').value='Hello! I wrote this using Javascript!';");
//        WebElement name = driver.findElement(By.xpath("//input[@name='author']"));
//        js.executeScript("arguments[0].value='John'",name);
//        js.executeScript("document.getElementById('email').value='john@gmail.com';");
//        WebElement website = driver.findElement(By.xpath("//input[@name='url']"));
//        js.executeScript("arguments[0].value='techtorial.com'",website);
//        WebElement checkBox = driver.findElement(By.xpath("//*[@id='wp-comment-cookies-consent']"));
//        js.executeScript("document.getElementById('wp-comment-cookies-consent').checked=true;");
//        js.executeScript("document.getElementById('submit').click();");
//        WebElement commentResult = driver.findElement(By.xpath("//*[@id='comment-994']/div/div[2]/div/header/div[1]/cite/b/a"));
    }
}
