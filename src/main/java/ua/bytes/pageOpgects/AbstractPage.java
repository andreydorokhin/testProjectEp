package ua.bytes.pageOpgects;

import org.openqa.selenium.WebDriver;
import ua.bytes.config.Driver;
import ua.bytes.config.Settings;

public class AbstractPage {
    protected static Driver driver;
    protected WebDriver webDriver = driver.getWebDriver();
    private static Settings settings = driver.getSettings();


    public static void closeBrowser() {
        System.out.println("Browser " + settings.getBrowser() + " has been closed");

        driver.getWebDriver().close();
        driver = null;
    }

    public static void quitBrowser() {
        System.out.println("Browser " + settings.getBrowser() + " has been quit");

        driver.getWebDriver().quit();
        driver = null;
    }
}
