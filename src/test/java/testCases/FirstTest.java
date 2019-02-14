package testCases;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;
import ua.bytes.pageOpgects.AbstractPage;
import ua.bytes.pageOpgects.ResultPage;

public class FirstTest extends BaseTest{

    private By firsLinkXpath = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a[1]/h3");

    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        ResultPage resultPage = mainPage.navigateTo("https://www.google.com/").showResults("automation");
        String title = resultPage.openFirstPage().getTextBySelector(firsLinkXpath);
        Allure.addAttachment("check of Header","Header contains 'automation'");

        Assert.assertTrue(title.toLowerCase().contains("automation"),"Header contains 'automation'");
    }

}
