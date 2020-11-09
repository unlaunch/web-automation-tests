/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ghauri
 */
public class Browser {

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_macOS");
    }

    public static final String hostname = "https://app.unlaunch.io";

    public static final String emailAddress = "unlaunch.test@gmail.com";

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

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void waitUntilUrlLoadsOrTimeout(String url, int timeoutInSeconds) {
        int totalInMillis = timeoutInSeconds * 1000 + 1000;
        while (true) {
            if (Browser.getCurrentUrl().endsWith(url)) {
                break;
            } else {
                sleep(1);
                totalInMillis -= 1000;

                if (totalInMillis < 0)  {
                    throw new RuntimeException("The expected URL" + url + " was not loaded in " + timeoutInSeconds +
                            " seconds");
                }
            }
        }
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            System.out.println("Sleep interrupted");
        }
    }

    public static void quit() {
        driver.quit();
    }



}
