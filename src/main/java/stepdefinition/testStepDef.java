package stepdefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class testStepDef {

@Given("^Print \"([^\"]*)\" statement$")
public void printStatement(String printText) throws AWTException {
    System.out.println(printText);
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
  //  driver.findElements(By.xpath("")).size();
    Actions action = new Actions(driver);
    Robot robot = new Robot();
    //robot.keyPress(KeyEvent.VK_E);
    driver.quit();
}
}
