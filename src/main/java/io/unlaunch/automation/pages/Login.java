/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Login {
    
    String url = "https://app.unlaunch.io";
    
    public void doLogin() {
        Browser.driver.manage().window().maximize();
        Browser.driver.manage().deleteAllCookies();
        Browser.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Browser.goTo(url);
        
        WebElement emailElement = Browser.driver.findElement(By.cssSelector("input.__at_email"));
        emailElement.sendKeys("fghauri@crovateoffshore.com");
        WebElement passwordElement = Browser.driver.findElement(By.cssSelector("input.__at_password"));
        passwordElement.sendKeys("Orca1234");
        WebElement loginButton = Browser.driver.findElement(By.cssSelector("button.__at_btn_login"));
        loginButton.submit();

    }

    boolean isLoggedIn() throws InterruptedException {
        WebElement sidebar = Browser.driver.findElement(By.cssSelector("div.__at_sidebar"));
        return sidebar.isDisplayed();
    }
    
}
