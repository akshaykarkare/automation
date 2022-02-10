package stepdefinition;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.io.IOException;

public class commonSD extends context.commonMethods{
    public commonSD(TestContext context){
    super(context);
    }

    //Open Website
    @Given("^Open \"([^\"]*)\" Website$")
    public void openURL(String URL) throws IOException {
        System.out.println("Opening: "+URL);
        navigate(URL);
        driver.navigate().to(properties.readConfig("config",URL));
    }

    //ClickOnElement
    @Then("^click on \"([^\"]*)\"$")
    public void clickOn(String element) throws IOException {
        System.out.println("clicking: "+ element);
        click(element);
    }
    //print to report
    @Given("^Print \"([^\"]*)\" statement$")
    public void print(String printText) {
        hooks.getScenario().log(printText);
    }

    //take screenshot
    @Given("^capture screenshot$")
    public void takeScreenshot() throws IOException {
        hooks.takeScreenshot(driver);
    }
}
