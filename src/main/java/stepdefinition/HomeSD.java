package stepdefinition;

import context.PropertiesUtil;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;

import java.awt.*;
import java.io.IOException;

public class HomeSD {
    WebDriver driver;
    PropertiesUtil properties;
    private TestContext testContext;
    stepdefinition.hooks hooks;

    public HomeSD(TestContext context){
        System.out.println("commonSD Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
        properties = testContext.getProperty();
        hooks= new hooks();
    }

}

