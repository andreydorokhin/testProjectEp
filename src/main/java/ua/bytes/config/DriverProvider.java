package ua.bytes.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class DriverProvider {
    private static DriverProvider INSTANCE = null;
    private Settings settings = SettingsProvider.getInstance().getSettings();
    private WebDriver driver = null;

    private DriverProvider() throws IOException {
        if (settings.getBrowser().equalsIgnoreCase("mozilla")) {
            System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "drivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static DriverProvider get() {
        if(INSTANCE == null){
            try {
                INSTANCE = new DriverProvider();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}