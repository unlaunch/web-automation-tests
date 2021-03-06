/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author ghauri
 */
public class FeatureFlags {

    public void createFeatureFlag(String name, String key, int numberOfVariations) {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);
        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_btn_create")));
        Browser.click(e);

        Browser.sleep(2); // TODO fix. Waits for modal to load

        WebElement modal = Browser.driver.switchTo().activeElement();

        WebElement nameFlag = modal.findElement(By.name("name"));
        Browser.fluentWait(((t) -> {
            return nameFlag;
        }));
        nameFlag.sendKeys(name);

        WebElement description = modal.findElement(By.name("description"));
        description.sendKeys("Test feature flag");

        int i = 1;
        String[] s = {"gray", "black"};

        while (numberOfVariations >= i) {

            if (i > 2) {
                WebElement btnAddVariation = modal.findElement(By.className("__at_btn_var_add"));
                btnAddVariation.click();
                int varIndex = i - 1;
                int sId = numberOfVariations - i;

                WebElement var = modal.findElement(By.name("variations[" + varIndex + "].key"));
                Browser.fluentWait((WebDriver t) -> var);
                var.sendKeys(s[sId]);
            }
            i++;
        }

        WebElement btnSave = modal.findElement(By.cssSelector("button[type=submit]"));
        btnSave.submit();
    }

    public void archiveFlag() {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);
        
        Browser.sleep(2);
        WebElement flagLink = Browser.driver.findElement(By.linkText("test-archive-flag"));
        Browser.fluentWait((WebDriver t) -> flagLink);
        flagLink.click();
        
        Browser.sleep(2);
        WebElement settings = Browser.driver.findElement(By.id("nav-settings-tab"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();

        WebElement btnArchive = Browser.driver.findElement(By.className("__at_btn_archive"));

        Browser.fluentWait((WebDriver t) -> btnArchive);
        btnArchive.click();
        
        Browser.sleep(2);
        WebElement textFlag = driver.findElement(By.className("__at_flag_name"));
        Browser.fluentWait((WebDriver t) -> textFlag);
        textFlag.sendKeys("test-archive-flag");
        
        WebElement deleteBtn = driver.findElement(By.className("__at_delete"));
        deleteBtn.click();
        
        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector(".\\__at_btn_ok"))).click();


    }
    
    public void deleteFlag() {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);
        
        Browser.sleep(2);
        WebElement linkArchive = Browser.driver.findElement(By.className("__at_link_archive"));
        Browser.fluentWait((WebDriver t) -> linkArchive);
        linkArchive.click();

        Browser.sleep(2);
        WebElement btnDelete = Browser.driver.findElement(By.className("__at_btn_delete"));
        Browser.fluentWait((WebDriver t) -> btnDelete);
        btnDelete.click();
        
        Browser.sleep(2);
        WebElement textDelete = Browser.driver.findElement(By.className("__at_flag_name"));
        Browser.fluentWait((WebDriver t) -> textDelete);
        textDelete.sendKeys("test-archive-flag");
        
        WebElement deleteModalBtn = Browser.driver.findElement(By.className("__at_delete"));
        Browser.fluentWait((WebDriver t) -> deleteModalBtn);
        deleteModalBtn.click();
        
        Browser.sleep(2);
        WebElement okayBtn = Browser.driver.findElement(By.className("__at_btn_ok"));
        Browser.fluentWait((WebDriver t) -> okayBtn);
        okayBtn.click();

    }
}
