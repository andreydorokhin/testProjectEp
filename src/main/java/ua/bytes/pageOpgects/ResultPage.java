package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends AbstractPage {
    private By firstLink = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a[1]/h3");
    private By nextPageResultButton = By.xpath("//*[@id=\"pnnext\"]/span[2]");

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SitePage openFirstPage() {
        webDriver.findElement(firstLink).click();
        Allure.addAttachment("ResultPage click first link", "First link was clicked");

        return new SitePage(webDriver);
    }

    public ResultPage showNextResultPage() {
        webDriver.findElement(nextPageResultButton).click();
        Allure.addAttachment("ResultPage click next page button", "next result page was clicked");

        return this;
    }

    public boolean isExpectDomainOnSearchingResult(String expectedDomain, int numberOfResultPage) throws InterruptedException {
        boolean isExpectDomain = false;

        for (int i = 1; i < numberOfResultPage; i++) {
            if (webDriver.getPageSource().contains(expectedDomain)) {
                isExpectDomain = true;
            }else {
                showNextResultPage();

                Thread.sleep(4000);
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
