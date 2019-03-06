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

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    private final By textbox = By.name("q");

    public void sendKeys() {
        driver.findElement(textbox).sendKeys(settings.getDetectedText());

    }

    public ResultPage showResults() {
        driver.findElement(textbox).submit();

        System.out.println("word '"+settings.getDetectedText()+"' Entered in Textbox and Submited");
        Allure.addAttachment("MainPage "+settings.getBaseURL()+"", "word "+ settings.getDetectedText() + " Entered in Textbox and Submited");

        return new ResultPage();
    }

    public void navigateTo(String stringUrl) {
        super.navigateTo(stringUrl);

    }
}
