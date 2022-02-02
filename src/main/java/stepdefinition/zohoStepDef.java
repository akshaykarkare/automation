package stepdefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class zohoStepDef {

    @Given("^Open \"([^\"]*)\" URL$")
    public void openURL(String URL){
        System.out.println("user wants to navigate to URL : "+URL);
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.quit();
    }
}

