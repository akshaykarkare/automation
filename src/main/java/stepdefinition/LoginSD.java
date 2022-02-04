package stepdefinition;

import context.TestContext;
import context.WebDriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSD {
    WebDriver driver;
    WebDriverManager webDriverManager;
    private TestContext testContext;

    public LoginSD(TestContext context){
        System.out.println("test Step Def constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
    }

@Then("^")
    public void click(){
    driver.findElement(By.xpath("//a[text()='Sign in']")).click();
    }
}
