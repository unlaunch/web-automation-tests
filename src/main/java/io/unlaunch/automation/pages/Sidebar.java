/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;

/**
 *
 * @author ghauri
 */
public class Sidebar {

    public void changeEnviroment() {

        Browser.sleep(10);
        Browser.driver.findElement(By.className("__at_env")).click();
        String text = Browser.driver.findElement(By.className("__at_env")).getText();

        if(text.equals("Test")) {
            Browser.driver.findElement(By.className("__at_env_Production")).click();
        } else {
            Browser.driver.findElement(By.className("__at_env_Test")).click();
        }
        
    }
}
