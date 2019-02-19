package ua.bytes.pageOpgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    private By textbox = By.name("q");

    public ResultPage showResults(String searchingText) {
        driver.findElement(textbox).sendKeys(searchingText);
        driver.findElement(textbox).submit();

        System.out.println("word '"+settings.getDetectedText()+"' Entered in Textbox and Submited");
        Allure.addAttachment("MainPage "+settings.getBaseURL()+"", "word "+ searchingText + " Entered in Textbox and Submited");

        return new ResultPage();
    }

    public MainPage navigateTo(String stringUrl) {
        super.navigateTo(stringUrl);

        return this;
    }
}
