package ua.bytes.pageOpgects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.bytes.config.Driver;
import ua.bytes.config.Settings;

public class AbstractPage {
    protected static Driver driver = Driver.getDriver();
    protected WebDriver webDriver = driver.getWebDriver();
    private static Settings settings = driver.getSettings();

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AbstractPage navigateTo(String stringUrl) {
        webDriver.get(stringUrl);

        return this;
    }

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

    public String getTextBySelector(By by) {
        return webDriver.findElement(by).getText();
    }
}
