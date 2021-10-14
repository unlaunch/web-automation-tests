/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages.featureflags;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Settings {

    public void changeFlagName() {
        Browser.sleep(3);
        WebElement settings = driver.findElement(By.id("nav-settings-tab"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();
        
        Browser.sleep(3);
        WebElement flagName = driver.findElement(By.className("__at_name"));
        Browser.fluentWait((WebDriver t) -> flagName);
        flagName.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        flagName.sendKeys("changed");

        driver.findElement(By.className("__at_btn_save")).click();

        Browser.fluentWait((WebDriver d) -> d.findElement(By.cssSelector("button.__at_btn_ok"))).click();

    }

    public void changeFlagDescription() {
        Browser.sleep(3);
        WebElement flagDesc = driver.findElement(By.className("__at_desc"));
        Browser.fluentWait((WebDriver t) -> flagDesc);
        flagDesc.sendKeys(Browser.clearInputFieldKeySequence);
        flagDesc.sendKeys("flag description changed");

        driver.findElement(By.className("__at_btn_save")).click();
        
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_ok"))).click();
    }

    public void setFlagToClientSide() {
        Browser.sleep(3);
        WebElement clientAccess = driver.findElement(By.className("__at_check_clientside"));
        Browser.fluentWait((WebDriver t) -> clientAccess);
        clientAccess.click();

        driver.findElement(By.className("__at_btn_save")).click();
        
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_ok"))).click();

    }
}
