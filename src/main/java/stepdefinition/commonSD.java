package stepdefinition;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class commonSD extends context.commonMethods{
    public commonSD(TestContext context){
    super(context);
    }

    //Open Website
    @Given("^Open \"([^\"]*)\" Website$")
    public void openURL(String URL) throws IOException {
        System.out.println("Opening: "+URL);
        navigate(URL);
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

    //testing purpose
    @Given("^interview preparation")
    public void ip() throws InterruptedException{
        Thread.sleep(500);
    }
}
