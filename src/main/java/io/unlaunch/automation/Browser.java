package io.unlaunch.automation;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Browser {

    static {
        String os = System.getProperty("os.name");
        Settings settings;
        if (os.toLowerCase().startsWith("mac")) {
            settings = new MacOsSettings();
        } else {
            settings = new DefaultSettings();
        }

        System.setProperty("webdriver.chrome.driver", settings.getWebDriverLocation());
        hostname = settings.getHostname();
        apiHostname = settings.getApiHostname();
        logoutUrl = settings.getHostname() + "/logout";
        clearInputFieldKeySequence = settings.getClearInputFieldSequence();
    }

    public static  final String hostname;
    public static final String clearInputFieldKeySequence;
    public static final String emailAddress = "unlaunch.test+" + UUID.randomUUID().toString() + "@gmail.com";
    public static WebDriver driver = new ChromeDriver(getChromeOptions());
    public static final String logoutUrl;
    public static final String apiHostname;
    public static void goTo(String url) {
        driver.get(url);
    }


    public static void sleep(int seconds) {
        seconds = seconds +5;
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            System.out.println("Sleep interrupted");
        }
    }


    public static void click(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", webElement);
    }

    public static WebElement fluentWait(Function<WebDriver, WebElement> function) {
        Wait wait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return (WebElement) wait.until(function);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-using");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        return options;
    }
}
