package testCases;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ua.bytes.config.Driver;

public class FirstTest {
    private static WebDriver webDriver;

    @BeforeClass
    public void init() throws IOException {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        webDriver = Driver.getDriver().getWebDriver();

        webDriver.navigate().to("http://www.google.com");
        System.out.println("Browser is Opened.");
    }

    @Test
    public void EnterText() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        webDriver.findElement(By.name("q")).sendKeys("automation");
        webDriver.findElement(By.name("q")).submit();
        System.out.println("word automation Entered in Textbox");

    }

    @Test
    public void checkResultOfSearching() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition <Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("automation");
            }
        });

        System.out.println("Page title is: " + webDriver.getTitle());
        Allure.addAttachment("Page is opened", "Page title is: " + webDriver.getTitle());
    }

    @AfterClass
    public void closebrowser() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        Driver.getDriver().getWebDriver().close();
    }
}
