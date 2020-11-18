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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        logoutUrl = settings.getHostname() + "/logout";
        clearInputFieldKeySequence = settings.getClearInputFieldSequence();
    }

    public static  final String hostname;
    public static final String clearInputFieldKeySequence;
    public static final String emailAddress = "unlaunch.test+" + UUID.randomUUID().toString() + "@gmail.com";
    public static WebDriver driver = new ChromeDriver(getChromeOptions());
    public static final String logoutUrl;

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
                    throw new RuntimeException("The expected URL" + url + " was not loaded Settings " + timeoutInSeconds +
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

    public static void waitForPageLoad() {
        ExpectedCondition<Boolean> condition = (WebDriver driver1) -> 
                ((JavascriptExecutor) driver1).executeScript("return document.readyState")
                        .toString()
                        .equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(condition);
        } catch (Exception e) {
            throw new RuntimeException("Timeout waiting for page load request to complete");
        }
    }

    public static void click(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", webElement);
    }

    public static WebElement fluentWait(Function<WebDriver, WebElement> function) {
//        sleep(2);
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
