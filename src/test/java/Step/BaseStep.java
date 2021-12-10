package Step;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;
import org.openqa.selenium.devtools.v95.log.Log;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class BaseStep extends BaseTest {
    static ChromeDriver driver;
    WebDriverWait webDriverWait ;

    public BaseStep(ChromeDriver driver) {
        BaseStep.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goUrl(String url){
        driver.get(url);
    }
    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void clickAboveElement(By by,String tagName){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
        findElement(RelativeLocator.with(By.tagName(tagName)).above(findElement(by))).click();
    }
    public void clickRightElement(By by,String tagName){

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
        findElement(RelativeLocator.with(By.tagName(tagName)).toRightOf(findElement(by))).click();
    }
    public void clickLeftElement(By by,String tagName){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
        findElement(RelativeLocator.with(By.tagName(tagName)).toLeftOf(findElement(by))).click();
    }
    public void clickNearElement(By by,String tagName){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
        findElement(RelativeLocator.with(By.tagName(tagName)).near(findElement(by))).click();
    }

    public void click(By by){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }
    public void clickBelowElement(By by,String tagName){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
        findElement(RelativeLocator.with(By.tagName(tagName)).below(findElement(by))).click();
    }
    public void devTool(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());

        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("-------------------------------------------");
            System.out.println("Request ID = " + logEntry.getNetworkRequestId());
            System.out.println("URL = " + logEntry.getUrl());
            System.out.println("Source = " + logEntry.getSource());
            System.out.println("Level = " + logEntry.getLevel());
            System.out.println("Text = " + logEntry.getText());
            System.out.println("Timestamp = " + logEntry.getTimestamp());
            System.out.println("-------------------------------------------");
        });
    }
    public void devToolGeo(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(48.864716),
                Optional.of(2.349014),
                Optional.of(1)));
    }
    public void devToolDevice(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(375,
                812,
                80,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
    }
}
