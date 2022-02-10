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
    @Given("^Print \"([^\"]*)\" statement$")
    public void print(String printText) throws IOException {
        System.out.println(printText);
        hooks.getScenario().log("trying to logg from LOGIN SD step def");
        hooks.takeScreenshot(driver);
    }

    @Given("^YML reader$")
    public void ymlReader(){
        System.out.println("yml reader :"+properties.readYml("Zoho_Home.signInLink"));
    }
}
