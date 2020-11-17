/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ghauri
 */
public class Variation {

    public void addVariation() {
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector("#nav-variation-tab > .text-normal"));
        })).click();
//        driver.findElement(By.cssSelector("#nav-variation-tab > .text-normal")).click();
        
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".btn-outline-dark"));
        })).click();
//        driver.
        
//        Browser.sleep(10);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_yes"));
        })).click();
//        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
        
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.name("variations[2].key"));
        })).click();

//        driver.findElement(By.name("variations[2].key")).click();
        driver.findElement(By.name("variations[2].key")).sendKeys("red");
        driver.findElement(By.cssSelector(".btn-primary:nth-child(4)")).click();
        
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_ok"));
        })).click();
//        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();
        
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".btn-outline-dark"));
        })).click();
//        driver.findElement(By.cssSelector(".btn-outline-dark")).click();
        
//        Browser.sleep(5);
        
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_yes"));
        })).click();
//        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
//        Browser.sleep(5);
        
        Browser.fluentWait(((t) -> {
            return t.findElement(By.name("variations[3].key"));
        })).sendKeys("gray");
//        driver.findElement(By.name("variations[3].key")).sendKeys("gray");
        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
        
//        Browser.sleep(5);
        
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_ok"));
        })).click();

//        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".btn-outline-dark"));
        })).click();
//        driver.findElement(By.cssSelector(".btn-outline-dark")).click();
        
        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_yes"));
        })).click();
//        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
//        Browser.sleep(5);
        
        Browser.fluentWait(((t) -> {
            return t.findElement(By.name("variations[4].key"));
        })).click();
//        driver.findElement(By.name("variations[4].key")).click();
        driver.findElement(By.name("variations[4].key")).sendKeys("green");
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".btn:nth-child(4)"));
        })).click();
//        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
        
//        Browser.sleep(5);
        Browser.fluentWait(((t) -> {
            return t.findElement(By.cssSelector(".\\__at_btn_ok"));
        })).click();
//        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }
}
