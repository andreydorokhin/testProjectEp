package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import ua.bytes.config.Driver;

public class FirstTest {
    private static WebDriver webDriver;

    @BeforeClass
    public void init() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        webDriver = Driver.getDriver().getWebDriver();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
//        Thread.sleep(5000);
//        System.out.println("Page title is: " + webDriver.getTitle());
//
//        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition <Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("automation");
//            }
//        });
//
//        System.out.println("Page title is: " + webDriver.getTitle());
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
    }

    @AfterClass
    public void closebrowser() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

        Driver.closeBrowser();
    }
}
