/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crovate.unlaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ghauri
 */
public class Browser {

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    public static WebDriver driver = new ChromeDriver();

    public static void goTo(String url) {
        driver.get(url);
    }

    public static String title() {
        return driver.getTitle();
    }

    public static void close() {
        driver.close();
    }

}
