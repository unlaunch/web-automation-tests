/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ghauri
 */
public class FeatureFlags {

    public void createFeatureFlag(int numberOfVariations) {
        Browser.sleep(5);

        Browser.goTo(Browser.hostname);

        WebElement flagLink = Browser.driver.findElement(By.linkText("Feature Flags"));
        flagLink.click();

        WebElement btnCreateFlag = Browser.driver.findElement(By.className("__at_btn_createFlag"));
        btnCreateFlag.click();

        Browser.sleep(5);

        WebElement modal = Browser.driver.switchTo().activeElement();
        System.out.println("tag name " + modal.getTagName());

        WebElement name = modal.findElement(By.name("name"));
        name.sendKeys("test-archive-flag");

        WebElement key = modal.findElement(By.name("key"));
        key.sendKeys("test-archive-flag");

        WebElement description = modal.findElement(By.name("description"));
        description.sendKeys("Test Archive feature");

        int i = 1;
        while (numberOfVariations >= i) {

            if (numberOfVariations > 2) {
                WebElement btnAddVariation = modal.findElement(By.linkText("+ Add Variation"));
                btnAddVariation.click();
            }

            int n = i - 1;
            WebElement var = modal.findElement(By.name("variations[" + n + "].key"));
            var.sendKeys("var" + i);
            i++;
        }

        WebElement btnSave = modal.findElement(By.cssSelector("button[type=submit]"));
        btnSave.submit();
    }

    public void archiveFlag() {
        Browser.sleep(10);

        WebElement flagLink = Browser.driver.findElement(By.partialLinkText("flag"));
        flagLink.click();

        Browser.sleep(5);

        String actual = Browser.driver.getWindowHandle();
        WebElement settings = Browser.driver.findElement(By.id("nav-settings-tab"));
        settings.click();

        Browser.sleep(10);

        WebElement btnArchive = Browser.driver.findElement(By.cssSelector("button[type=button]"));
        
        Browser.sleep(2);
        btnArchive.click();

        Browser.sleep(5);

        WebElement btnYes = Browser.driver.findElement(By.linkText("Yes"));
        btnYes.click();

        Browser.sleep(2);

        WebElement btnOkay = Browser.driver.findElement(By.linkText("Okay"));
        btnOkay.click();

    }

}
