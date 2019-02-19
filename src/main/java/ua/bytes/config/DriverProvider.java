/*
 * (C) Copyright 2019 Andrey Вщкщлршт
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package ua.bytes.config;

import io.github.bonigarcia.wdm.WebDriverManager;
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
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
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