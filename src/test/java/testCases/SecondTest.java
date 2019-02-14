package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.bytes.pageOpgects.ResultPage;

public class SecondTest extends BaseTest{

    @Test
    public void TestTwo() throws InterruptedException {
        ResultPage resultPage = mainPage.navigateTo("https://www.google.com/").showResults("automation");

        Boolean result = resultPage.isExpectDomainOnSearchingResult("https://www.testautomationday.com", 5);

        Assert.assertTrue(result);
    }

}
