/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crovate.unlaunch.pages;

import com.crovate.unlaunch.Browser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Register {

    String url = "https://app.unlaunch.io";
    String otpUrl = "https://app.unlaunch.io/otp";
    String projectUrl = "https://app.unlaunch.io/project";
    String otpSucessUrl = "https://app.unlaunch.io/company";

    public void doRegsiter() {
        Browser.goTo(url);

        WebElement accountElement = Browser.driver.findElement(By.linkText("Create Account"));
        accountElement.click();

        WebElement nameElement = Browser.driver.findElement(By.cssSelector("input[name=name]"));
        nameElement.sendKeys("Automated test");

        WebElement companyElement = Browser.driver.findElement(By.cssSelector("input[name=company]"));
        companyElement.sendKeys("UnlaunchTest");

        WebElement emailElement = Browser.driver.findElement(By.cssSelector("input[name=email]"));
        emailElement.sendKeys("tilikum-test-123@gmail.com");

        WebElement passwordElement = Browser.driver.findElement(By.cssSelector("input[name=password]"));
        passwordElement.sendKeys("Orca123");

        WebElement registerButton = Browser.driver.findElement(By.cssSelector("button[type=submit]"));
        registerButton.submit();
    }

    public void otp() {
        Browser.goTo(otpUrl);

        WebElement nameElement = Browser.driver.findElement(By.cssSelector("input[type=tel]"));
        nameElement.sendKeys("455148");

        WebElement verifyButton = Browser.driver.findElement(By.tagName("button"));
        verifyButton.submit();
    }

    public void company() {
        Browser.goTo(otpSucessUrl);

        WebElement cardElement = Browser.driver.findElement(By.className("div.card-title"));
        if (cardElement.isDisplayed()) {

            WebElement createProjButton = Browser.driver.findElement(By.cssSelector("button[type=submit]"));
            createProjButton.submit();
        }
    }

    public void createFirstProject() {
        Browser.goTo(projectUrl);

        WebElement nameElement = Browser.driver.findElement(By.cssSelector("input[name=name]"));
        nameElement.sendKeys("Unlaunch automated test");

        WebElement keyElement = Browser.driver.findElement(By.cssSelector("input[name=key]"));
        keyElement.sendKeys("Unlaunch-automated-test");

        WebElement descElement = Browser.driver.findElement(By.cssSelector("input[name=description]"));
        descElement.sendKeys("Automated test selenium");

        WebElement createButton = Browser.driver.findElement(By.cssSelector("button[type=submit]"));
        createButton.submit();
    }

    public void deleteUserBeforeRegister() throws MalformedURLException, IOException {

        System.out.println("DELETE_USER");
        URL url = new URL("https://api.unlaunch.io/api/v1/cleansweepuser?email=tilikum-test-123@gmail.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("X-Unlaunch-Secret", "49345A");
        
        int responseCode = con.getResponseCode();
        System.out.println("response code : " + responseCode);
    }
}
