package introToTestNG.fileUpload;

import introToTestNG.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadPractice extends TestBase {

    @Test(description = "File upload test")
    void fileUploadTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));
        String filePath ="/Users/techtorialacademy/Desktop/hobby.html";
        chooseFileButton.sendKeys(filePath);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        softAssert.assertEquals(header.getText(),"File Uploaded!");
        softAssert.assertTrue(filePath.contains(fileName.getText()));
        softAssert.assertAll();

    }

    @Test(description = "GURU99 File upload test")
    void fileUploadGuru99Test(){
        driver.get("https://demo.guru99.com/test/upload/");
        String filePath ="/Users/techtorialacademy/Desktop/hobby.html";
        driver.findElement(By.id("uploadfile_0")).sendKeys(filePath);
        driver.findElement(By.cssSelector("button#submitbutton")).click();
        WebElement successMessage = driver.findElement(By.xpath("//h3/center"));
        softAssert.assertEquals(successMessage.getText(),"1 file\nhas been successfully uploaded.");
        softAssert.assertAll();
    }
}
