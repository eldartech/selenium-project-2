package introToTestNG.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsDoubleClick {
    @Test(description = "PrimeFaces.org Double Click Test")
    void doubleClickTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml?jfwid=d8c37");
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(text(),'click')]"));
        Actions actions = new Actions(driver);
        for (int i=0; i<buttons.size();i++){
            Thread.sleep(2000);
            switch (buttons.get(i).getText()){
                case "click":
                    actions.click(buttons.get(i)).perform();
                    break;
                case "doubleclick":
                    actions.doubleClick(buttons.get(i)).perform();
                    break;
            }
        }
    }


}
