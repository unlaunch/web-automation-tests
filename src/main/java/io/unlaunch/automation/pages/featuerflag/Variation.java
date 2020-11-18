/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;

/**
 *
 * @author ghauri
 */
public class Variation {

    public void addVariation() {

        // TODO fix sleep
        Browser.sleep(5);
        driver.findElement(By.cssSelector("#nav-variation-tab > .text-normal")).click();

        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_selection")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
        Browser.sleep(5);
        driver.findElement(By.className("__at_variations[2].key_key")).sendKeys("red");
        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_selection")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
        Browser.sleep(5);
        driver.findElement(By.className("__at_variations[3].key_key")).sendKeys("gray");
        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_selection")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_yes")).click();
        Browser.sleep(5);
        driver.findElement(By.className("__at_variations[4].key_key")).click();
        driver.findElement(By.className("__at_variations[4].key_key")).sendKeys("green");
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }
}
