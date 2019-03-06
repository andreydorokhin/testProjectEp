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

package testCases.stepdefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ua.bytes.pageOpgects.MainPage;
import ua.bytes.pageOpgects.ResultPage;
import ua.bytes.pageOpgects.SitePage;


public class FirstScenarioStepdefs{

    private MainPage mainPage;
    private ResultPage resultPage;
    private SitePage sitePage;
    private Boolean isLinkOnResultsPage;


    @Given("^User navigates to the google page$")
    public void user_navigates_to_the_google_page() throws Throwable {
        mainPage = new MainPage();
        mainPage.navigateTo(mainPage.settings.getBaseURL());
    }

    @When("^User submit searching word$")
    public void user_submit_searching_word() throws Throwable {
        mainPage.sendKeys();
    }

    @Then("^Result page should be shown$")
    public void result_page_should_be_shown() throws Throwable {
        resultPage = mainPage.showResults();
    }

    @Given("^User is on result page$")
    public void user_is_on_result_page() throws Throwable {
        resultPage.waitPageLoaded();
    }

    @When("^User navigates first link$")
    public void user_navigates_first_link() throws Throwable {
        sitePage = resultPage.openFirstPage();
    }

    @Then("^Title must contain specific text$")
    public void title_must_contain_specific_text() throws Throwable {
        Assert.assertTrue(sitePage.getTitle().toLowerCase().contains(sitePage.settings.getDetectedText()),"Header contains '" + sitePage.settings.getDetectedText() +"'");
    }

    @When("^User is searching specific link on results pages$")
    public void userIsSearchingSpecificLinkOnResultsPages() throws InterruptedException {
        isLinkOnResultsPage = resultPage.isExpectDomainOnSearchingResult(resultPage.settings.getDomain(), 5);
    }

    @Then("^detected link must be on the result page$")
    public void detected_link_must_be_on_the_result_page() throws Throwable {
        Assert.assertTrue(isLinkOnResultsPage);
    }

}
