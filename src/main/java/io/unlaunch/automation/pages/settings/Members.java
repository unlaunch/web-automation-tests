/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages.settings;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Members {
    
    public void addMember() {
        
        WebElement settings = driver.findElement(By.className("__at_nav_settings"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();

        WebElement members = driver.findElement(By.className("__at_members"));
        Browser.fluentWait((WebDriver t) -> members);
        members.click();
        
        Browser.sleep(5);
        WebElement btn = driver.findElement(By.className("__at_add_member"));
        Browser.fluentWait((WebDriver t) -> btn);
        btn.click();
        
        Browser.sleep(5);
        WebElement email = driver.findElement(By.className("__at_email"));
        Browser.fluentWait((WebDriver t) -> email);
        email.click();
        email.sendKeys("unlaunch.test+" + UUID.randomUUID().toString() + "@gmail.com");
        
        driver.findElement(By.className("__at_btn_add")).click();
        
    }
}
