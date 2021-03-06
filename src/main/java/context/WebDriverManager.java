package context;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

        if(false){
            System.setProperty("webdriver.ie.driver","driver/IE Driver ServerIEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();

        //driver.manage().window().setSize(new Dimension(100,100));
        //driver.manage().window().setPosition(new Point(100, 10));
        return driver;
    }
}