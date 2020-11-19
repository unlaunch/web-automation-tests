/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Variation {

    public void addVariation() {

        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_link_variations"))).click();

        Browser.sleep(1);

        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_var_add"))).click();

        Browser.sleep(1);

        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_yes"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_variations[2].key_key"))).sendKeys("red");
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_save"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_ok"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_var_add"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_yes"))).click();

        Browser.sleep(1);

        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_variations[3].key_key"))).sendKeys("gray");
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_save"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_ok"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_var_add"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_yes"))).click();

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_variations[4].key_key"))).click();
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_variations[4].key_key"))).sendKeys("green");

        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_save"))).click();
        Browser.sleep(1);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.className("__at_btn_ok"))).click();

    }
}
