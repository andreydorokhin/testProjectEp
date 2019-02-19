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

package testCases;

        import io.qameta.allure.Allure;
        import org.testng.Assert;

        import org.testng.annotations.Test;
        import ua.bytes.pageOpgects.ResultPage;

public class FirstTest extends BaseTest{

    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        ResultPage resultPage = mainPage.navigateTo(settings.getBaseURL()).showResults(settings.getDetectedText());
        String title = resultPage.openFirstPage().getTitle();
        Allure.addAttachment("check of Header","Header contains '" + settings.getDetectedText() + "'");

        Assert.assertTrue(title.toLowerCase().contains(settings.getDetectedText()),"Header contains '" + settings.getDetectedText() +"'");
    }

}
