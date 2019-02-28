package testCases.stepdefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import ua.bytes.config.DriverProvider;
import ua.bytes.config.Settings;
import ua.bytes.config.SettingsProvider;
import ua.bytes.pageOpgects.MainPage;
import ua.bytes.pageOpgects.ResultPage;
import ua.bytes.pageOpgects.SitePage;


public class MyStepdefs {
    private DriverProvider driverProvider = DriverProvider.get();
    private MainPage mainPage;
    private ResultPage resultPage;
    private SitePage sitePage;
    protected Settings settings = SettingsProvider.getInstance().getSettings();

    @AfterSuite
    public void closebrowser() throws InterruptedException {
        try {
            if(driverProvider.getWebDriver() != null)
                driverProvider.getWebDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Given("^User opened search page$")
    public void user_opened_search_page() throws Throwable {
        System.out.println("User opened search page");
        mainPage = new MainPage();
        mainPage.navigateTo(settings.getBaseURL());
    }

    @When("^User inserts detected word$")
    public void user_inserts_detected_word() throws Throwable {
        System.out.println("User inserts detected word");
        mainPage.sendKeys();
    }

    @Then("^results of request appear on the page$")
    public void results_of_request_appear_on_the_page() throws Throwable {
        System.out.println("results of request appear on the page");
        resultPage = mainPage.showResults();
    }

    @Then("^defined site is opened after clicking first item$")
    public void definedSiteIsOpenedAfterClickingFirstItem() {
        sitePage = resultPage.openFirstPage();
    }

    @Then("^the title of the page must contain detected word$")
    public void theTitleOfThePageMustContainDetectedWord() {
        Assert.assertTrue(sitePage.getTitle().toLowerCase().contains(settings.getDetectedText()),"Header contains '" + settings.getDetectedText() +"'");
    }
}
