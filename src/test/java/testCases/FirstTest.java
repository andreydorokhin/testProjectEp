package testCases;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        String title = mainPage.showResults("automation").getTextBySelector(By.cssSelector(".apphub_AppName"));
        Allure.addAttachment("check of Header","Header contains 'automation'");

        Assert.assertTrue(title.toLowerCase().contains("automation"),"Header contains 'automation'");
    }

}
