package introToTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class TestBase {
    public WebDriver driver;
    public SoftAssert softAssert;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser){
        driver= Driver.getDriver(browser);
//        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
