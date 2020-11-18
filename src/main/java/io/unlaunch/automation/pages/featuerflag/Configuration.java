/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author ghauri
 */
public class Configuration {

    public void addConfiguration() {
        Browser.sleep(10);

        driver.findElement(By.cssSelector("#nav-configuration-tab > .text-normal")).click();

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-body .btn")).click();

        for (int i = 0; i < 3; i++) {

            driver.findElement(By.name("variations[0].configs[" + i + "].key")).click();
            driver.findElement(By.name("variations[0].configs[" + i + "].key")).sendKeys("a" + i);
            driver.findElement(By.name("variations[0].configs[" + i + "].value")).click();
            driver.findElement(By.name("variations[0].configs[" + i + "].value")).sendKeys("123");

            if (i < 2) {
                driver.findElement(By.cssSelector(".\\__at_var_add_variations\\[0\\]")).click();
            }
        }

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

        Browser.sleep(10);

        driver.findElement(By.cssSelector(".card:nth-child(2) > .card-body .btn")).click();

        for (int i = 0; i < 25; i++) {
            driver.findElement(By.name("variations[1].configs[" + i + "].key")).click();
            driver.findElement(By.name("variations[1].configs[" + i + "].key")).sendKeys("a1" + i);
            driver.findElement(By.name("variations[1].configs[" + i + "].value")).click();
            driver.findElement(By.name("variations[1].configs[" + i + "].value")).sendKeys("435");

            
            if (i < 24) {
                driver.findElement(By.cssSelector(".\\__at_var_add_variations\\[1\\]")).click();
            }
        }

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".btn-outline-dark")).click();

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".card:nth-child(3) > .card-body")).click();

        for (int i = 0; i < 25; i++) {
            driver.findElement(By.name("variations[2].configs[" + i + "].key")).click();
            driver.findElement(By.name("variations[2].configs[" + i + "].key")).sendKeys("a11" + i);
            driver.findElement(By.name("variations[2].configs[" + i + "].value")).click();
            driver.findElement(By.name("variations[2].configs[" + i + "].value")).sendKeys("898");
            if (i < 24) {
                driver.findElement(By.cssSelector(".\\__at_var_add_variations\\[2\\]")).click();
                Browser.sleep(1);
            }
        }

        Browser.sleep(5);

        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();
        Browser.sleep(8);
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-body:nth-child(2) div:nth-child(2) span:nth-child(1)")).click();
        Browser.sleep(5);

        Actions act =  new Actions(driver);
        WebElement e = Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector(".\\__at_variations\\[0\\]\\.configs\\[1\\]\\.key_del")));
        act.moveToElement(e).click().perform();

        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_save")).click();
        Browser.sleep(5);
        driver.findElement(By.cssSelector(".\\__at_btn_ok")).click();

    }

}
