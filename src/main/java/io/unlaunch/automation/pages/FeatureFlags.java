/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ghauri
 */
public class FeatureFlags {

    public void createFeatureFlag(String name, String key, int numberOfVariations) {
        Browser.sleep(15);

        WebElement flagLink = Browser.driver.findElement(By.linkText("Feature Flags"));
        flagLink.click();

        Browser.sleep(15);

        WebElement btnCreateFlag = Browser.driver.findElement(By.className("__at_btn_create"));
        btnCreateFlag.click();

        Browser.sleep(5);

        WebElement modal = Browser.driver.switchTo().activeElement();
        System.out.println("tag name " + modal.getTagName());

        WebElement nameFlag = modal.findElement(By.name("name"));
        nameFlag.sendKeys(name);

        WebElement flahKey = modal.findElement(By.name("key"));
        flahKey.sendKeys(key);

        WebElement description = modal.findElement(By.name("description"));
        description.sendKeys("Test feature flag");

        int i = 1;
        String[] s = {"on", "off", "gray"};

        while (numberOfVariations >= i) {

            if (i > 2) {
                WebElement btnAddVariation = modal.findElement(By.className("__at_btn_var_add"));
                btnAddVariation.click();
            }

            int n = i - 1;
            WebElement var = modal.findElement(By.name("variations[" + n + "].key"));
            var.sendKeys(Keys.BACK_SPACE);
            var.sendKeys(s[n]);
            i++;
        }

        WebElement btnSave = modal.findElement(By.cssSelector("button[type=submit]"));
        btnSave.submit();
    }

    public void archiveFlag() {
        Browser.sleep(10);

        WebElement flagLink = Browser.driver.findElement(By.linkText("test-archive-flag"));
        flagLink.click();

        Browser.sleep(5);

        WebElement settings = Browser.driver.findElement(By.id("nav-settings-tab"));
        settings.click();

        Browser.sleep(10);

        WebElement btnArchive = Browser.driver.findElement(By.className("__at_btn_archive"));
        Browser.sleep(2);
        btnArchive.click();

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".react-confirm-alert-button-group > button:nth-child(1)")).click();
        
        Browser.sleep(5);
        
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }

}
