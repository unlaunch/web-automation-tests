/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ghauri
 */
public class Registration {
    private final WebDriverWait webDriverWait = new WebDriverWait(Browser.driver, 5);

    public void register() {
        Browser.goTo(Browser.hostname);

        WebElement accountElement = Browser.driver.findElement(By.className("__at_link_create"));
        Browser.fluentWait(((t) -> {
            return accountElement;
        }));
        accountElement.click();

        WebElement nameElement = Browser.driver.findElement(By.cssSelector("input[name=name]"));
        nameElement.sendKeys("Automated test");

        WebElement companyElement = Browser.driver.findElement(By.cssSelector("input[name=company]"));
        companyElement.sendKeys("UnlaunchTest");

        WebElement emailElement = Browser.driver.findElement(By.cssSelector("input[name=email]"));
        emailElement.sendKeys(Browser.emailAddress); // TODO remove this
//        emailElement.sendKeys("unlaunch.test+" + UUID.randomUUID().toString() + "@gmail.com"); // TODO for localhost

        WebElement passwordElement = Browser.driver.findElement(By.cssSelector("input[name=password]"));
        passwordElement.sendKeys("Orca123");

        WebElement registerButton = Browser.driver.findElement(By.cssSelector("button[type=submit]"));
        registerButton.submit();
    }

    public void otp() {
        Browser.fluentWait((WebDriver d) -> d.findElement(By.cssSelector("input[type=tel]"))).sendKeys("455148");
        //WebElement button = Browser.driver.findElement(By.tagName("button"));
        //button.submit();
    }

    public void company() {
        Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_btn_company"))).click();
    }

    public void createFirstProject() {
        webDriverWait.until(ExpectedConditions.urlContains("/project"));

        WebElement nameElement = Browser.driver.findElement(By.cssSelector("input[name=name]"));
        nameElement.sendKeys("Unlaunch automated test");

//        WebElement keyElement = Browser.driver.findElement(By.cssSelector("input[name=key]"));
//        keyElement.sendKeys("Unlaunch-automated-test");

        WebElement descElement = Browser.driver.findElement(By.cssSelector("input[name=description]"));
        descElement.sendKeys("Automated test selenium");

        WebElement createButton = Browser.driver.findElement(By.cssSelector("button[type=submit]"));
        createButton.submit();
    }

    public void skipMembers() {
        Browser.sleep(5);
        webDriverWait.until(ExpectedConditions.urlContains("/add/members"));
        WebElement btn = Browser.driver.findElement(By.className("__at_btn_skip"));
        btn.click();
    }

    public void verifySuccessfullLogin() {
        Browser.sleep(5);
        webDriverWait.until(ExpectedConditions.urlContains("/features"));

        WebElement btn = Browser.driver.findElement(By.className("__at_btn_create"));
        Browser.fluentWait((WebDriver t) -> btn);
        if (!btn.isDisplayed()) {
            throw new RuntimeException("cannot verify it login was successful. Create Flag Button wasn't found");
        }
    }

    public void deleteUserBeforeRegister() throws MalformedURLException, IOException {

        System.out.println("DELETE_USER");
        URL url = new URL("https://api.unlaunch.io/api/v1/cleansweepuser?email=" + Browser.emailAddress);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("X-Unlaunch-Secret", "49345A");
        
        int responseCode = con.getResponseCode();
        System.out.println("response code : " + responseCode);
    }
}
