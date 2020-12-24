/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.sdk;

import io.unlaunch.UnlaunchAttribute;
import io.unlaunch.UnlaunchClient;
import io.unlaunch.UnlaunchFeature;
import io.unlaunch.automation.Browser;
import static io.unlaunch.automation.Browser.driver;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ghauri
 */
public class EvaluateFeatureFlag {

    private static final Logger LOG = LogManager.getLogger(EvaluateFeatureFlag.class);
    private static UnlaunchClient client;

    public UnlaunchClient getClient() {
        return client;
    }

    public static void initializeClient(String sdkKey) {
        client = UnlaunchClient.builder().host(Browser.apiHostname).sdkKey(sdkKey).build();

        try {
            client.awaitUntilReady(10, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            LOG.error("client wasn't ready " + e.getMessage());
        }

    }

    public static void close() {
        client.shutdown();
    }

    public String evalInactiveFlagReturnsDefaultVariation() {

        String variation = client.getVariation("test-archive-flag", "user-123");
        return variation;
    }

    public String evalFlagReturnsControlVariation() {

        String variation = client.getVariation("test-archive-flag", "user-456");
        return variation;
    }

    public String evalWhiteListForOnVariation() {

        String variation = client.getVariation("test-flag", "1");
        return variation;
    }

    public String evalWhiteListForOffVariation() {

        String variation = client.getVariation("test-flag", "52");
        return variation;
    }

    public String evalWhiteListWithRandomUser() {

        String variation = client.getVariation("test-flag", "123");
        return variation;
    }

    public boolean evalDefaultRulePercentageRollout() {

        // Get variation
        int onCount = 0;
        int offCount = 0;
        int grayCount = 0;
        for (int i = 0; i < 100; i++) {
            String variation = client.getVariation("test-flag", String.valueOf(i) + "0");
            if (variation.equals("on")) {
                onCount++;
            } else if (variation.equals("off")) {
                offCount++;
            } else if (variation.equals("gray")) {
                grayCount++;
            }
        }

        return (onCount >= 28 && onCount <= 36) && (offCount >= 28 && offCount <= 36) && (grayCount >= 28 && grayCount <= 36);
    }

    public String evalTargetingRuleForString() {

        String variation = client.getVariation("test-flag", "user-123", UnlaunchAttribute.newString("device", "ABCS"));
        return variation;
    }

    public String evalTargetingRuleForInteger() {

        String variation = client.getVariation("test-flag", "user-123", UnlaunchAttribute.newNumber("ltv", 123));
        return variation;
    }

    public String evalTargetingRuleForBoolean() {

        String variation = client.getVariation("test-flag", "user-123", UnlaunchAttribute.newBoolean("paid", true));
        return variation;
    }

    public Map<String, String> evalVariantConfigurations() {

        UnlaunchFeature feature = client.getFeature("test-flag-3-conf", "user-123");
        Map<String, String> variationConfigAsMap = feature.getVariationConfigAsMap();

        return variationConfigAsMap;
    }

    public static String getSdkKey() {
        Browser.sleep(15);
        WebElement settings = driver.findElement(By.className("__at_nav_settings"));
        Browser.fluentWait((WebDriver t) -> settings);
        settings.click();

        Browser.sleep(5);
        WebElement members = driver.findElement(By.className("__at_projects"));
        Browser.fluentWait((WebDriver t) -> members);
        members.click();

        WebElement serverKey = Browser.driver.findElement(By.className("__at_server_key-unlaunch-automated-test"));
        Browser.fluentWait((WebDriver t) -> serverKey);
        return serverKey.getText();
    }
}
