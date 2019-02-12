package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import ua.bytes.config.Driver;

public class FirstTest {
    private static WebDriver webDriver;
//    private static Driver driver;

    @BeforeClass
    public void init() {
//        driver = Driver.getDriver();
        webDriver = Driver.getDriver().getWebDriver();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webDriver.navigate().to("http://www.google.com");
        System.out.println("Browser is Opened.");
    }

    @Test
    public void EnterText() throws InterruptedException {
        webDriver.findElement(By.name("q")).sendKeys("automation");
        webDriver.findElement(By.name("q")).submit();
        System.out.println("Facebook Entered in Textbox");
        Thread.sleep(5000);
    }

    @AfterClass
    public void closebrowser() {
        Driver.closeBrowser();
    }
}
