/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author ghauri
 */
public class Targeting {

    public void addWhitelist() {

        Browser.sleep(10);

        WebElement targetUser = Browser.driver.findElement(By.cssSelector(".\\__at_btn_add_whitelist"));
        targetUser.click();

        Browser.sleep(2);

        WebElement on = Browser.driver.findElement(By.id("react-select-4-input"));
        for (int i = 0; i < 15; i++) {
            on.sendKeys(String.valueOf(i));
            on.sendKeys(Keys.ENTER);
        }
        WebElement off = Browser.driver.findElement(By.id("react-select-5-input"));

        for (int i = 0; i < 15; i++) {
            off.sendKeys(String.valueOf(i) + "0");
            off.sendKeys(Keys.ENTER);
        }
        WebElement gray = Browser.driver.findElement(By.id("react-select-6-input"));
        for (int i = 0; i < 15; i++) {
            gray.sendKeys(String.valueOf(i) + "00");
            gray.sendKeys(Keys.ENTER);
        }

        Browser.driver.findElement(By.cssSelector(".\\__at_btn_save")).click();

        Browser.sleep(5);

        Browser.driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }

    public void addWhitelistToOn() {

        Browser.sleep(10);

        WebElement targetUser = Browser.driver.findElement(By.cssSelector(".\\__at_btn_add_whitelist"));
        targetUser.click();

        Browser.sleep(2);

        WebElement on = Browser.driver.findElement(By.id("react-select-4-input"));
        for (int i = 0; i < 50; i++) {
            on.sendKeys(String.valueOf(i));
            on.sendKeys(Keys.ENTER);
        }
        
        Browser.driver.findElement(By.cssSelector(".\\__at_btn_save")).click();

        Browser.sleep(5);

        Browser.driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }

    public void addWhitelistToOff() {

//        WebElement targetUser = Browser.driver.findElement(By.className("__at_btn_add_whitelist"));
//        targetUser.click();
        WebElement off = Browser.driver.findElement(By.id("react-select-5-input"));
        for (int i = 0; i < 25; i++) {
            off.sendKeys(String.valueOf(i));
            off.sendKeys(Keys.ENTER);
        }
        
        Browser.driver.findElement(By.cssSelector(".\\__at_btn_save")).click();

        Browser.sleep(5);

        Browser.driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }

    public void removeWhiteList() {
        Browser.sleep(10);

        WebElement on = Browser.driver.findElement(By.id("react-select-4-input"));
        for (int i = 0; i < 15; i++) {
            on.sendKeys(Keys.BACK_SPACE);
        }
        
        Browser.sleep(10);
        
        WebElement off = Browser.driver.findElement(By.id("react-select-5-input"));
        for (int i = 0; i < 15; i++) {
            off.sendKeys(Keys.BACK_SPACE);
        }
        Browser.sleep(10);
        
        WebElement gray = Browser.driver.findElement(By.id("react-select-6-input"));
        for (int i = 0; i < 15; i++) {
            gray.sendKeys(Keys.BACK_SPACE);
        }
        
        Browser.sleep(5);
        Browser.driver.findElement(By.className("__at_btn_save")).click();

        Browser.sleep(5);
        Browser.driver.findElement(By.className("__at_okay")).click();

    }

    public void setDefaultRulePercentageRollout(String val1, String val2, String val3) {

        WebElement defaultRule = Browser.driver.findElement(By.className("__at_select_default_rule"));
        Select select = new Select(defaultRule);
        select.selectByVisibleText("Percentage Rollout");

        WebElement on = Browser.driver.findElement(By.className("__at_perc_on"));
        on.sendKeys(val1);
        WebElement off = Browser.driver.findElement(By.className("__at_perc_off"));
        off.sendKeys(val2);
        WebElement gray = Browser.driver.findElement(By.className("__at_perc_gray"));
        gray.sendKeys(val3);

        WebElement save = Browser.driver.findElement(By.className("__at_btn_save"));
        save.submit();

        WebElement alert = Browser.driver.switchTo().activeElement();
        alert.findElement(By.className("__at_okay")).click();

    }

    public void setDefaultRule(String var) {

        WebElement defaultRule = Browser.driver.findElement(By.className("__at_select_default_rule"));
        Select select = new Select(defaultRule);
        select.selectByVisibleText(var);

        WebElement save = Browser.driver.findElement(By.className("__at_btn_save"));
        save.submit();

        WebElement alert = Browser.driver.switchTo().activeElement();
        alert.findElement(By.className("__at_okay")).click();

    }

    public void setDefaultVariation(String var) {
        WebElement defaultRule = Browser.driver.findElement(By.className("__at_select_offvariation"));
        Select select = new Select(defaultRule);
        select.selectByVisibleText(var);

        WebElement save = Browser.driver.findElement(By.className("__at_btn_save"));
        save.submit();

        WebElement alert = Browser.driver.switchTo().activeElement();
        alert.findElement(By.className("__at_okay")).click();

    }
}
