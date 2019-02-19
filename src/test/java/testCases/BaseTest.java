package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ua.bytes.config.DriverProvider;
import ua.bytes.config.Settings;
import ua.bytes.config.SettingsProvider;
import ua.bytes.pageOpgects.MainPage;


public class BaseTest {
    private DriverProvider driverProvider = DriverProvider.get();
    protected MainPage mainPage = new MainPage();
    protected Settings settings = SettingsProvider.getInstance().getSettings();

    @BeforeClass
    public void init() {
        long id = Thread.currentThread().getId();
        System.out.println("+++++++++++++++++Before test-method. Thread id is: " + id);

    }

    @AfterSuite
    public void closebrowser() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("-----------------After test-method. Thread id is: " + id);

        try {
            if(driverProvider.getWebDriver() != null)
                driverProvider.getWebDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
