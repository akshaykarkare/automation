package stepdefinition;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class hooks {
    public WebDriver driver;
    public static Scenario scenario;
    private TestContext testContext;

    public hooks(){
        System.out.println("hooks default constructor");
    }

    public hooks(TestContext context){
        System.out.println("hooks constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
    }

    @Before
    public void beforeHook(Scenario scenario) throws IOException {
        System.out.println("Before Scenario");
        this.scenario=scenario;
    }

    public Scenario getScenario(){
        return this.scenario;
    }

    @After
    public void afterHook(Scenario scenario) throws IOException {
        System.out.println("After Scenario");
        takeScreenshot(driver);
        driver.quit();
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        System.out.println(System.getProperty("user.dir"));
        Date date = new Date();
        System.out.println(date.toString());

        String path = System.getProperty("user.dir")+"/screenshots/"+scenario.getName()+"_"+date.toString()+".png";
        File DestFile=new File(path);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        scenario.attach(scrShot.getScreenshotAs(OutputType.BYTES),"image/png",scenario.getName());
        scenario.log("logging using scenario");
    }

}
