package testCases;

import org.testng.annotations.AfterSuite;
import ua.bytes.config.DriverProvider;
import ua.bytes.config.Settings;
import ua.bytes.config.SettingsProvider;
import ua.bytes.pageOpgects.MainPage;


public class BaseTest {
    private DriverProvider driverProvider = DriverProvider.get();
    protected MainPage mainPage = new MainPage();
    protected Settings settings = SettingsProvider.getInstance().getSettings();


    @AfterSuite
    public void closebrowser() throws InterruptedException {
        try {
            if(driverProvider.getWebDriver() != null)
                driverProvider.getWebDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
