package com.saucedemo.tests;

import com.saucedemo.pages.LogInPage;
import introToTestNG.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    LogInPage logInPage;

    @BeforeMethod
    void setPages() {
        logInPage = new LogInPage(driver);
    }


    @Parameters({"userName", "passWord"})
    @Test(description = "Sauce Login Positve Test")
    void logInTest(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        logInPage.logIn(username, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
