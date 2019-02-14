package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultPage showResults(String searchingText) {
        webDriver.findElement(By.name("q")).sendKeys(searchingText);
        webDriver.findElement(By.name("q")).submit();

        System.out.println("word 'automation' Entered in Textbox and Submited");
        Allure.addAttachment("MainPage Google.com", "word "+ searchingText + " Entered in Textbox and Submited");

        return new ResultPage(this.webDriver);
    }

    public MainPage navigateTo(String stringUrl) {
        super.navigateTo(stringUrl);

        return this;
    }
}
