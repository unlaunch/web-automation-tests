package io.unlaunch.automation;

import org.openqa.selenium.Keys;

public class MacOsSettings  implements Settings {
    @Override
    public String getWebDriverLocation() {
        return "src/main/resources/chromedriver_macOS";
    }

    @Override
    public String getHostname() {
        // return "https://app-qa.unlaunch.io";
        return "http://localhost:3000";
    }

    @Override
    public String getClearInputFieldSequence() {
        return Keys.chord(Keys.COMMAND + "a" + Keys.DELETE);
    }
}
