package ua.bytes.pageOpgects;

import org.openqa.selenium.By;


public class SitePage extends AbstractPage {
    private By titleOfSite = By.cssSelector(".apphub_AppName");

    public String getTitle() {
        return driver.findElement(titleOfSite).getText();
    }
}
