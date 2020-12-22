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
import org.openqa.selenium.Keys;
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

        Browser.sleep(5);
        WebElement members = driver.findElement(By.className("__at_members"));
        Browser.fluentWait((WebDriver t) -> members);
        members.click();

        Browser.sleep(5);
        WebElement btn = driver.findElement(By.className("__at_add_member"));
        Browser.fluentWait((WebDriver t) -> btn);
        btn.click();

        Browser.sleep(5);
        int number = 100 + (int)(Math.random() * ((899) + 1));

        WebElement email = driver.findElement(By.cssSelector("div.__at_email div div div div input"));
        Browser.fluentWait((WebDriver t) -> email);
        Browser.click(email);
        email.sendKeys("unlaunch.test" + number + "@gmail.com");
        email.sendKeys(Keys.ENTER);

        driver.findElement(By.className("__at_btn_add")).click();
        
        Browser.sleep(5);
        driver.findElement(By.className("__at_btn_ok")).click();

    }
}
