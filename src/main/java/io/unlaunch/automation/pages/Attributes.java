/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author ghauri
 */
public class Attributes {

    public void createAttribute(String name, String type) {
        Browser.sleep(2);
        
        WebElement attrLink = Browser.driver.findElement(By.linkText("Attributes"));
        attrLink.click();

        Browser.sleep(3);

        Browser.driver.findElement(By.cssSelector("button.__at_btn_create")).click();
        Browser.sleep(3);

        Browser.driver.findElement(By.cssSelector("input.__at_name")).sendKeys(name);
        Select attrType = new Select(Browser.driver.findElement(By.cssSelector("select.__at_type")));
        attrType.selectByVisibleText(type);

        WebElement save = Browser.driver.findElement(By.cssSelector("button.__at_btn_save"));
        save.submit();
    }
}
