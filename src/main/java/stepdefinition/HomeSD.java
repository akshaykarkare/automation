package stepdefinition;

import context.PropertiesUtil;
import context.TestContext;
import context.WebDriverManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.UUID;

public class HomeSD {
    WebDriver driver;
    PropertiesUtil properties;
    Scenario scenario;
    private TestContext testContext;
    hooks hooks;

    public HomeSD(TestContext context){
        System.out.println("zoho Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
        properties = testContext.getProperty();
        hooks= new hooks();

    }

    @Given("^Open Zoho Website$")
    public void openURL() throws IOException {
        System.out.println("Navigating to Zoho Website ");
        driver.navigate().to(properties.readConfig("config","URL"));
        hooks.getScenario().log("trying to logg from HOME SD step def");
        hooks.takeScreenshot(driver);
    }

    @Then("^Click$")
    public void click() throws IOException {
        driver.findElement(By.xpath(properties.readConfig("homeXpath","signInLink"))).click();
    }

}

