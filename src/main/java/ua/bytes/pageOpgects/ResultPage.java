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

package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class ResultPage extends AbstractPage {
    private By links = By.xpath("//h3");
    private By nextPageResultButton = By.id("pnnext");

    public SitePage openFirstPage() {
        driver.findElements(links).get(0).click();
        Allure.addAttachment("ResultPage click first link", "First link was clicked");

        return new SitePage();
    }

    public ResultPage showNextResultPage() {
        driver.findElement(nextPageResultButton).click();
        Allure.addAttachment("ResultPage click next page button", "next result page was clicked");

        return this;
    }

    public boolean isExpectDomainOnSearchingResult(String expectedDomain, int numberOfResultPage) throws InterruptedException {
        boolean isExpectDomain = false;

        for (int i = 1; i < numberOfResultPage; i++) {
            if (driver.getPageSource().contains(expectedDomain)) {
                isExpectDomain = true;
            }else {
                showNextResultPage();
            }
        }

        if (isExpectDomain){
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is On Result");
        }else {
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is NOT On Result");
        }

        return isExpectDomain;
    }
}
