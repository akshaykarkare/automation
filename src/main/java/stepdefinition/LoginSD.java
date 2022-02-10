package stepdefinition;

import context.PropertiesUtil;
import context.TestContext;
import context.WebDriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSD {
    WebDriver driver;
    WebDriverManager webDriverManager;
    PropertiesUtil properties;
    private TestContext testContext;
    hooks hooks;

    public LoginSD(TestContext context){
        System.out.println("test Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
        properties = testContext.getProperty();
        hooks= new hooks();
    }

}
