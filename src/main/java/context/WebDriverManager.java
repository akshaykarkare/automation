package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        driver = createLocalDriver();
        return driver;
    }

    private WebDriver createLocalDriver() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}