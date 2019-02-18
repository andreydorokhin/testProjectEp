package ua.bytes.config;

import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;



public class Driver {
    private static Driver INSTANCE = null;
    private Settings settings = serializeSettings();
    Gson gson = new Gson();

    private WebDriver driver = null;

    private Driver() throws NullPointerException, IOException {
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
        }
    }

    public static Driver getDriver() {
        if(INSTANCE == null){
            try {
                INSTANCE = new Driver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    private Settings serializeSettings () throws NullPointerException, IOException{
        gson.serializeNulls();
        String json = new String(Files.readAllBytes(Paths.get("config.json")));
        Settings settings = gson.fromJson(json, Settings.class);
        System.out.println(settings.toString());

        return settings;
    }

    public Settings getSettings() {
        return settings;
    }
}