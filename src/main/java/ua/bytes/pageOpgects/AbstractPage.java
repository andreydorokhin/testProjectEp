/*
 * (C) Copyright 2019 Andrey Dorokhin
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
