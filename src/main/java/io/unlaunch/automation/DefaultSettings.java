package io.unlaunch.automation;

import org.openqa.selenium.Keys;

public class DefaultSettings implements Settings {
    @Override
    public String getWebDriverLocation() {
        return  "src/main/resources/chromedriver";
    }

    @Override
    public  String getHostname() {
        return "https://app-qa.unlaunch.io";
    }

    @Override
    public String getClearInputFieldSequence() {
        return Keys.chord(Keys.CONTROL + "a" + Keys.DELETE);
    }
}
