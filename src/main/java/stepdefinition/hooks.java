package stepdefinition;

import context.PropertiesUtil;
import context.TestContext;
import context.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class hooks {
    WebDriver driver;
    private TestContext testContext;

    public hooks(TestContext context){
        System.out.println("hooks constructor");
        testContext=context;
        driver = testContext.getWebDriverManager().getDriver();
    }

    @After
    public void afterHook(Scenario scenario) throws IOException {

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);


        //Move image file to new destination
        System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir")+"/screenshots/"+scenario.getName()+".png";
        File DestFile=new File(path);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        scenario.attach(scrShot.getScreenshotAs(OutputType.BYTES),"image/png",scenario.getName());
        scenario.log("logging using scenario");
        driver.quit();


    }
}
