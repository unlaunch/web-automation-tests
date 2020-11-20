/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author ghauri
 */
public class Attributes {

    public void createAttribute(String name, String type) {

        WebElement e = Browser.driver.findElement(By.className("__at_link_attributes_list"));
        Browser.fluentWait((WebDriver t) -> e);
        Browser.click(e);

        WebElement btn = Browser.driver.findElement(By.cssSelector("button.__at_btn_create"));
        Browser.fluentWait((WebDriver t) -> btn);
        Browser.click(btn);

        WebElement input = Browser.driver.findElement(By.cssSelector("input.__at_name"));
        Browser.fluentWait((WebDriver t) -> input);
        input.sendKeys(name);

        Select attrType = new Select(Browser.driver.findElement(By.cssSelector("select.__at_type")));
        attrType.selectByVisibleText(type);

        WebElement save = Browser.driver.findElement(By.cssSelector("button.__at_btn_save"));
        save.submit();
    }
}
