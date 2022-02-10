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
         hooks.getScenario().log("trying to logg from HOME SD step def");
          hooks.takeScreenshot(driver);
    }

    //ClickOnElement
    @Then("^click on \"([^\"]*)\"$")
    public void clickOn(String element) throws IOException {
        System.out.println("clicking: "+ element);
        click(element);
        //driver.findElement(By.xpath(properties.readConfig("homeXpath","signInLink"))).click();
       // driver.findElement(By.xpath(properties.readYml("Zoho_Home.signInLink"))).click();

    }
}
