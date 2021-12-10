package Pages;

import Step.BaseStep;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static Constants.Constants.*;
import static org.awaitility.Awaitility.await;

public class HomePage extends BaseStep {
    public HomePage(ChromeDriver driver){

        super(driver);
    }
    public void goUrlDev(){
        devTool();
        goUrl(URL);
    }
    public HomePage search() {

        sendKeys(SEARCH_BAR,TEXT);
        await().atMost(Duration.ofSeconds(10)).untilAsserted(
                () -> Assert.assertTrue(findElement(LIST_ELEMENTS).isDisplayed()));
        findElement(SEARCH_BAR).sendKeys(Keys.ENTER);
        return this;
    }
    public void goHome(){

        clickLeftElement(SEARCH_BAR,"a");
    }
    public void devGeo() {
        devToolGeo();
        goUrl("https://my-location.org/");

    }
    public void devDevice() {
        devToolDevice();
        goUrl("https://applitools.com/blog/selenium-4-chrome-devtools/");

    }
}
