package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import io.unlaunch.automation.sdk.EvaluateFeatureFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tutorial {

    public void apiEventReceived() {
        // Choose Java language
        WebElement element = Browser.driver.findElement(By.cssSelector("div.__at_select_language div div div div input"));
        Browser.fluentWait((WebDriver t) -> element);
        element.sendKeys("Java");
        element.sendKeys(Keys.ENTER);

        // Get sdkKey
        WebElement codeElement = Browser.driver.findElements(By.className("sdk_help_code")).get(1);
        String code = codeElement.getText();
        String sdkKey = code.substring(code.indexOf("prod-server"), code.indexOf("\")"));

        // Send api event
        EvaluateFeatureFlag evaluator = new EvaluateFeatureFlag();
        evaluator.initializeClient(sdkKey);
        evaluator.evalFlag("my-first-feature-flag", "identity");
        evaluator.close();

        // Make sure event is received
        Browser.sleep(3);
        WebElement successElement = Browser.driver.findElement(By.className("__at_p_tutorialsuccess"));
        assert successElement.getText().contains("Congratulations");
    }
}
