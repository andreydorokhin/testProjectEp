package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ua.bytes.config.Driver;
import ua.bytes.pageOpgects.MainPage;

import java.io.IOException;

public class BaseTest {
    private Driver driver = Driver.getDriver();
    protected MainPage mainPage = new MainPage(driver.getWebDriver());

    @BeforeClass
    public void init() throws IOException {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

    }

    @AfterClass
    public void closebrowser() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);

    }
}
