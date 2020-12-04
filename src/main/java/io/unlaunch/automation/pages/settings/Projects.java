/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages.settings;

import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Projects {

    public void createProject() {

        WebElement settings = driver.findElement(By.className("__at_nav_settings"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();

        WebElement members = driver.findElement(By.className("__at_projects"));
        Browser.fluentWait((WebDriver t) -> members);
        members.click();

        Browser.sleep(5);
        WebElement btn = driver.findElement(By.className("__at_create_project"));
        Browser.fluentWait((WebDriver t) -> btn);
        btn.click();

        Browser.sleep(5);
        WebElement name = driver.findElement(By.className("__at_name"));
        Browser.fluentWait((WebDriver t) -> name);
        name.click();
        name.sendKeys("Selenium Automation Testing");

        WebElement desc = driver.findElement(By.className("__at_description"));
        Browser.fluentWait((WebDriver t) -> desc);
        desc.click();
        desc.sendKeys("Selenium tests");

        driver.findElement(By.className("__at_btn_save")).click();

        Browser.sleep(5);
        driver.findElement(By.className("__at_confirm")).click();
    }

    public void deleteProject() {

        WebElement settings = driver.findElement(By.className("__at_nav_settings"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();

        WebElement members = driver.findElement(By.className("__at_projects"));
        Browser.fluentWait((WebDriver t) -> members);
        members.click();

        Browser.sleep(10);
        WebElement btn = driver.findElement(By.className("__at_delete_selenium-automation-testing"));
        Browser.fluentWait((WebDriver t) -> btn);
        btn.click();

        Browser.sleep(5);
        WebElement deleteText = driver.findElement(By.className("__at_flag_name"));
        Browser.fluentWait((WebDriver t) -> deleteText);
        deleteText.sendKeys("Selenium Automation Testing");

        driver.findElement(By.className("__at_delete")).click();
        
        Browser.sleep(10);
        driver.findElement(By.className("__at_delete_confirm")).click();
    }
}
