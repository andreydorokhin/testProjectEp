package testCases.stepdefination;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import ua.bytes.config.DriverProvider;
import ua.bytes.config.Settings;
import ua.bytes.config.SettingsProvider;
import ua.bytes.pageOpgects.MainPage;
import ua.bytes.pageOpgects.ResultPage;
import ua.bytes.pageOpgects.SitePage;


public class FirstScenarioStepdefs{

    private DriverProvider driverProvider = DriverProvider.get();
    private MainPage mainPage;
    private ResultPage resultPage;
    private SitePage sitePage;
    private Settings settings = SettingsProvider.getInstance().getSettings();


    @After
    public void before(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driverProvider.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }

    @After
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

    @When("^User inserts detected word and chooses first item from searching results$")
    public void userInsertsDetectedWordAndChoosesFirstItemFromSearchingResults() {
        mainPage.sendKeys();
        resultPage = mainPage.showResults();
        sitePage = resultPage.openFirstPage();
    }

    @Then("^the title of the opend page must contain detected word$")
    public void theTitleOfTheOpendPageMustContainDetectedWord() {
        Assert.assertTrue(sitePage.getTitle().toLowerCase().contains(settings.getDetectedText()),"Header contains '" + settings.getDetectedText() +"'");
    }

    @When("^User inserts detected word and clicks search buttom$")
    public void userInsertsDetectedWordAndClicksSearchButtom() {
        mainPage.sendKeys();
        resultPage = mainPage.showResults();
    }

    @Then("^detected link must be on one of the top five pages of search results$")
    public void detectedLinkMustBeOnOneOfTheTopFivePagesOfSearchResults() throws InterruptedException {
        Boolean result = resultPage.isExpectDomainOnSearchingResult(settings.getDomain(), 5);
        Assert.assertTrue(result);
    }
}