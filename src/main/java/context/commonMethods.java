package context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.hooks;

import java.io.IOException;

public class commonMethods {
    protected WebDriver driver;
    protected PropertiesUtil properties;
    private TestContext testContext;
    protected stepdefinition.hooks hooks;

    public commonMethods(TestContext context){
        System.out.println("commonSD Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
        properties = testContext.getProperty();
        hooks= new hooks();
    }

    public void navigate(String URL) throws IOException {
        System.out.println("navigating to : "+ URL);
        EventFiringWebDriver d = new EventFiringWebDriver(driver);
        d.navigate().to(properties.readConfig("config",URL));
        //driver.navigate().to(properties.readConfig("config",URL));
    }

    public void click(String element){
        System.out.println("click on : "+ properties.readYml(element));
        driver.findElement(By.xpath(properties.readYml(element))).click();
    }

    public void demo(String element){
        Select s = new Select(driver.findElement(By.xpath(properties.readYml(element))));
        s.getOptions().size();
        s.getFirstSelectedOption().getText();

        Actions act = new Actions(driver);

    }
}
