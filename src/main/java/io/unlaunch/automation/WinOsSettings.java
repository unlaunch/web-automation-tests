package io.unlaunch.automation;

import org.openqa.selenium.Keys;

public class WinOsSettings implements Settings {
    @Override
    public String getWebDriverLocation() {
        return  "src/main/resources/chromedriver.exe";
    }

    @Override
    public  String getHostname() {
        return "https://app-qa.unlaunch.io";
    }

    @Override
    public String getApiHostname() {
        return "https://api-qa.unlaunch.io";
    }

    @Override
    public String getClearInputFieldSequence() {
        return Keys.chord(Keys.CONTROL + "a" + Keys.DELETE);
    }
}
