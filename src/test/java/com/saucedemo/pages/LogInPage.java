package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver=driver;
    }

    private By userName=By.id("user-name");
    private By password=By.id("password");
    private By logInButton=By.id("login-button");

    public WebElement getUserName(){
        return driver.findElement(userName);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getLogInButton(){
        return driver.findElement(logInButton);
    }

    /**
     * method which logs in to Sauce Application
     * @param userName
     * @param password
     */
    public void logIn(String userName,String password){
        getUserName().sendKeys(userName);
        getPassword().sendKeys(password);
        getLogInButton().click();
    }


}
