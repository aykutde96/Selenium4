package Constants;

import org.openqa.selenium.By;

public class Constants {
    public static String URL = "https://google.com";
    public static String TEXT = "Testinium";
    public static final By SEARCH_BAR = By.name("q");
    public static final By LIST_ELEMENTS = By.xpath("//li[@role='presentation']");
}
