package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends AbstractPage {
    private By firstLink = By.xpath("//div[@id='isearch']//a[1]/h3");
    private By nextPageResultButton = By.xpath("//div[@id='navcnt']//span[2]");

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultPage openFirstPage() {
        webDriver.findElement(firstLink).click();
        Allure.addAttachment("ResultPage click first link", "First link was clicked");

        return new ResultPage(webDriver);
    }

    public ResultPage showNextResultPage() {
        webDriver.findElement(nextPageResultButton).click();
        Allure.addAttachment("ResultPage click next page button", "next result page was clicked");

        return this;
    }

    public boolean isExpectDomainOnSearchingResult(String expectedDomain, int numberOfResultPage) {
        boolean isExpectDomain = false;

        for (int i = 0; i < numberOfResultPage; i++) {
            if (webDriver.getPageSource().contains(expectedDomain)) {
                isExpectDomain = true;
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
