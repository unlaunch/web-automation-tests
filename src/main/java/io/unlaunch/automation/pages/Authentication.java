/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Authentication {
    
    public void login(String emailAddress, String password) {
        
        WebElement emailElement = Browser.driver.findElement(By.cssSelector("input.__at_email"));
        Browser.fluentWait((WebDriver d) -> emailElement);
        emailElement.sendKeys(emailAddress);

        WebElement passwordElement = Browser.driver.findElement(By.cssSelector("input.__at_password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = Browser.driver.findElement(By.cssSelector("button.__at_btn_login"));
        loginButton.submit();

    }

    boolean isLoggedIn() {
        WebElement sidebar = Browser.driver.findElement(By.cssSelector("div.__at_sidebar"));
        Browser.fluentWait((WebDriver t) -> sidebar);
        return sidebar.isDisplayed();
    }
    
    public void logout() {
        WebElement userEmail = Browser.driver.findElement(By.id("bd-versions"));
        userEmail.click();
        
        WebElement logoutItem = Browser.driver.findElement(By.linkText("Logout"));
        logoutItem.click();
    }
    
    public boolean verifyLogout() {
//        Browser.waitUntilUrlLoadsOrTimeout("/login", 5);
//        
//        Browser.sleep(2);
//        
        WebElement loginButton = Browser.driver.findElement(By.cssSelector("button.__at_btn_login"));
        Browser.fluentWait((WebDriver t) -> loginButton);
        return loginButton.isDisplayed();
    }
    
}
