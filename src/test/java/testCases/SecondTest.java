package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.bytes.pageOpgects.ResultPage;

public class SecondTest extends BaseTest{

    @Test
    public void TestTwo() throws InterruptedException {
        ResultPage resultPage = mainPage.navigateTo(settings.getBaseURL()).showResults(settings.getDetectedText());

        Boolean result = resultPage.isExpectDomainOnSearchingResult(settings.getDomain(), 5);

        Assert.assertTrue(result);
    }
}
