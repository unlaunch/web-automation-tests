/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages.featuerflag;

import io.unlaunch.automation.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class Targeting {

    public void addWhitelist() {

        Browser.sleep(2);


        try {
            WebElement flagNavLink = Browser.driver.findElement(By.linkText("Feature Flags"));
            Browser.fluentWait((WebDriver t) -> flagNavLink);
            flagNavLink.click();

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement flagNavLink = Browser.driver.findElement(By.linkText("Feature Flags"));
            Browser.fluentWait((WebDriver t) -> flagNavLink);
            flagNavLink.click();
        }



        WebElement flagLink = Browser.driver.findElement(By.linkText("test-flag"));
        Browser.fluentWait((WebDriver t) -> flagLink);
        flagLink.click();


        WebElement targetUser = Browser.driver.findElement(By.cssSelector("button.__at_btn_add_whitelist"));
        Browser.fluentWait((WebDriver t) -> targetUser);
        targetUser.click();

        WebElement on = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_on div div div input"));
        Browser.fluentWait((WebDriver t) -> on);
        for (int i = 0; i < 15; i++) {
            on.sendKeys(String.valueOf(i));
            on.sendKeys(Keys.ENTER);
        }

        WebElement off = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_off div div div input"));
        Browser.fluentWait((WebDriver t) -> off);
        for (int i = 0; i < 15; i++) {
            off.sendKeys(String.valueOf(i) + "0");
            off.sendKeys(Keys.ENTER);
        }
        WebElement gray = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_gray div div div input"));
        Browser.fluentWait((WebDriver t) -> gray);
        for (int i = 0; i < 15; i++) {
            gray.sendKeys(String.valueOf(i) + "00");
            gray.sendKeys(Keys.ENTER);
        }

        Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();

    }

    public void addWhitelistToOn() {

//        Browser.sleep(3);
        WebElement targetUser = Browser.driver.findElement(By.cssSelector("button.__at_btn_add_whitelist"));
        Browser.fluentWait((WebDriver t) -> targetUser);
        targetUser.click();

//        Browser.sleep(2);
        WebElement on = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_on div div div input"));
        Browser.fluentWait((WebDriver t) -> on);

        for (int i = 0; i < 50; i++) {
            on.sendKeys(String.valueOf(i));
            on.sendKeys(Keys.ENTER);
        }

        Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(3);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void addWhitelistToOff() {
//        Browser.sleep(3);

        WebElement off = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_off div div div input"));
        Browser.fluentWait((WebDriver t) -> off);
        for (int i = 51; i < 76; i++) {
            off.sendKeys(String.valueOf(i));
            off.sendKeys(Keys.ENTER);
        }

        Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(3);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void removeWhiteList() {
//        Browser.sleep(2);

        WebElement on = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_on div div div input"));
        Browser.fluentWait((WebDriver t) -> on);
        for (int i = 0; i < 15; i++) {
            on.sendKeys(Keys.BACK_SPACE);
        }

//        Browser.sleep(2);
        WebElement off = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_off div div div input"));
        Browser.fluentWait((WebDriver t) -> off);
        for (int i = 0; i < 15; i++) {
            off.sendKeys(Keys.BACK_SPACE);
        }
//        Browser.sleep(2);

        WebElement gray = Browser.driver.findElement(By.cssSelector("div.__at_multiselect_gray div div div input"));
        Browser.fluentWait((WebDriver t) -> gray);
        for (int i = 0; i < 15; i++) {
            gray.sendKeys(Keys.BACK_SPACE);
        }

//        Browser.sleep(2);
        Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void setDefaultRulePercentageRollout(String val1, String val2, String val3) {
//        Browser.sleep(3);

        WebElement defaultRule = Browser.driver.findElement(By.cssSelector("div.__at_select_default div div div input"));
        Browser.fluentWait(((t) -> {
            return defaultRule;
        }));
        defaultRule.sendKeys("percentageRollout");
        defaultRule.sendKeys(Keys.ENTER);

        WebElement on = Browser.driver.findElement(By.cssSelector("input.__at_perc_on"));
        on.sendKeys(Browser.clearInputFieldKeySequence);
        on.sendKeys(val1);

        WebElement off = Browser.driver.findElement(By.cssSelector("input.__at_perc_off"));
//        off.click();
//        off.clear();
        off.sendKeys(Browser.clearInputFieldKeySequence);
        off.sendKeys(val2);

        WebElement gray = Browser.driver.findElement(By.cssSelector("input.__at_perc_gray"));
//        gray.click();
//        gray.clear();
        gray.sendKeys(Browser.clearInputFieldKeySequence);
        gray.sendKeys(val3);

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_save"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(3);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void setDefaultRule(String var) {

//        Browser.sleep(2);
        WebElement defaultRule = Browser.driver.findElement(By.cssSelector("div.__at_select_default div div div input"));
        Browser.fluentWait((WebDriver t) -> defaultRule);
        defaultRule.sendKeys(var);
        defaultRule.sendKeys(Keys.ENTER);

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_save"))).click();
//Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void setDefaultVariation(String var) {

//        Browser.sleep(2);
        WebElement defaultRule = Browser.driver.findElement(By.cssSelector("div.__at_select_offvariation div div div input"));
        Browser.fluentWait((WebDriver t) -> defaultRule);
        defaultRule.sendKeys(var);
        defaultRule.sendKeys(Keys.ENTER);

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_save"))).click();
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();

//Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();
//
//        Browser.sleep(2);
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();
    }

    public void addTargettingRule(String attr, String type, String value, Integer index) {

//        Browser.sleep(2);
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_rule_add")).click();
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_rule_add"))).click();
        
//        Browser.sleep(1);

        WebElement clauseAttr = Browser.driver.findElement(By.cssSelector("div.__at_select_attr_" + index + " div div div input"));
        Browser.fluentWait((WebDriver t) -> clauseAttr);
        clauseAttr.sendKeys(attr);
        clauseAttr.sendKeys(Keys.ENTER);

//        Browser.sleep(1);

        WebElement clauseOp = Browser.driver.findElement(By.cssSelector("div.__at_select_op_" + index + " div div div input"));
        Browser.fluentWait((WebDriver t) -> clauseOp);
        clauseOp.sendKeys("Equals");
        clauseOp.sendKeys(Keys.ENTER);

//        Browser.sleep(2);

        if (type.equals("Boolean")) {
            WebElement clauseboolValue = Browser.driver.findElement(By.cssSelector("div.__at_select_bool_" + index + " div div div input"));
            Browser.fluentWait((WebDriver t) -> clauseboolValue);
            clauseboolValue.sendKeys(value);
            clauseboolValue.sendKeys(Keys.ENTER);

        } else {
            WebElement clauseValue = Browser.driver.findElement(By.cssSelector("input.__at_value_" + index));
            Browser.fluentWait((WebDriver t) -> clauseValue);
            clauseValue.sendKeys(value);
            clauseValue.sendKeys(Keys.ENTER);
        }

        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_save"))).click();
//Browser.driver.findElement(By.cssSelector("button.__at_btn_save")).click();

//        Browser.sleep(2);
        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok"))).click();
//        Browser.driver.findElement(By.cssSelector("button.__at_btn_ok")).click();

    }

    public void delTargettingRule(Integer i) {

//        WebElement e = Browser.fluentWait((WebDriver t) -> t.findElement(By.linkText("test-flag")));
//        Browser.click(e);
        WebElement e;
        e = Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_rule_del_" + i)));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_save")));
        Browser.click(e);

        Browser.fluentWait((WebDriver t) -> t.findElement(By.cssSelector("button.__at_btn_ok")));
        Browser.click(e);


    }
}
