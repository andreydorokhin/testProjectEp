package testCases;

        import io.qameta.allure.Allure;
        import org.testng.Assert;

        import org.testng.annotations.Test;
        import ua.bytes.pageOpgects.ResultPage;

public class FirstTest extends BaseTest{

    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        ResultPage resultPage = mainPage.navigateTo(settings.getBaseURL()).showResults(settings.getDetectedText());
        String title = resultPage.openFirstPage().getTitle();
        Allure.addAttachment("check of Header","Header contains '" + settings.getDetectedText() + "'");

        Assert.assertTrue(title.toLowerCase().contains(settings.getDetectedText()),"Header contains '" + settings.getDetectedText() +"'");
    }

}
