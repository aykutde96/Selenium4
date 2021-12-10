package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static ChromeDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        setDriver(new ChromeDriver(options));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(3));
        driver.manage().window().fullscreen();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    public static ChromeDriver getDriver() {
        return driver;
    }

    public static void setDriver(ChromeDriver driver) {
        BaseTest.driver = driver;
    }
}
