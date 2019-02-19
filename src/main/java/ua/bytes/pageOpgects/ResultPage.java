package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class ResultPage extends AbstractPage {
    private By firstLink = By.xpath("//*[@id=\"rso\"]//a[1]/h3");
    private By nextPageResultButton = By.xpath("//*[@id=\"pnnext\"]/span[2]");

    public SitePage openFirstPage() {
        driver.findElement(firstLink).click();
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
