package context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.navigate().to(properties.readConfig("config",URL));
    }

    public void click(String element){
        System.out.println("click on : "+ properties.readYml(element));
        driver.findElement(By.xpath(properties.readYml(element))).click();
    }
}
