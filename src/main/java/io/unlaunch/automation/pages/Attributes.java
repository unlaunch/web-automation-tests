/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author ghauri
 */
public class Attributes {
 
    public void createAttribute(String name, String type) { 
        Browser.sleep(5);
        
        WebElement attrLink = Browser.driver.findElement(By.className("__at_attributes"));
        attrLink.click();

        Browser.sleep(5);
        
        WebElement btnCreate = Browser.driver.findElement(By.className("__at_btn_create_attr"));
        btnCreate.click();
        
        Browser.sleep(5);
        
        WebElement modal = Browser.driver.switchTo().activeElement();
        WebElement attName = modal.findElement(By.className("__at_name"));
        attName.sendKeys(name);
        
        WebElement attType = modal.findElement(By.className("__at_type"));
        Select selectType = new Select(attType);
        selectType.selectByVisibleText(type);
        
        Browser.sleep(5);
        
        WebElement save = Browser.driver.findElement(By.className("__at_att_save"));
        save.submit();
        
    }
}
