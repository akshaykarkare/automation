package stepdefinition;

import context.PropertiesUtil;
import context.TestContext;
import context.WebDriverManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.HookTestStep;
import io.cucumber.plugin.event.HookType;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.UUID;

public class HomeSD {
    WebDriver driver;
    PropertiesUtil properties;
    Scenario scenario;
    private TestContext testContext;

    public HomeSD(TestContext context){
        System.out.println("zoho Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
        properties = testContext.getProperty();
    }

    @Given("^Open Zoho Website$")
    public void openURL() throws IOException {
        System.out.println("Navigating to Zoho Website ");
        driver.navigate().to(properties.readConfig("config","URL"));
    }

    @Then("^Click$")
    public void click() throws IOException {
        driver.findElement(By.xpath(properties.readConfig("homeXpath","signInLink"))).click();
    }

}

