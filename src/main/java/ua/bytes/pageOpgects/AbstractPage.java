package ua.bytes.pageOpgects;

import org.openqa.selenium.WebDriver;
import ua.bytes.config.DriverProvider;
import ua.bytes.config.Settings;
import ua.bytes.config.SettingsProvider;

public class AbstractPage {
    protected WebDriver driver = DriverProvider.get().getWebDriver();
    public static Settings settings = SettingsProvider.getInstance().getSettings();

    public AbstractPage navigateTo(String stringUrl) {
        driver.get(stringUrl);

        return this;
    }
}
