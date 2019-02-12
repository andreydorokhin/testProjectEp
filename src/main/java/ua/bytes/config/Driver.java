package ua.bytes.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver INSTANCE = null;

    private WebDriver driver = null;

    private static final String browserType = "chrome";
    private static final String baseURL = "https://www.google.com";

    private Driver() throws NullPointerException {
        if (browserType.equalsIgnoreCase("mozilla")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Auto_QA\\WebDriversForSelenium\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Auto_QA\\WebDriversForSelenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "D:\\Projects\\Auto_QA\\WebDriversForSelenium\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
//        Instance.navigate().to(baseURL)
//        driver.manage().deleteAllCookies();
    }

    public static Driver getDriver(){
        if(INSTANCE == null){
            INSTANCE = new Driver();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public static void closeBrowser() {
        System.out.println("Browser " + browserType + " has been closed");

        INSTANCE.getWebDriver().close();
        INSTANCE = null;
    }

    public static void quitBrowser() {
        System.out.println("Browser " + browserType + " has been quit");

        INSTANCE.getWebDriver().quit();
        INSTANCE = null;
    }
}