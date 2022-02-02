import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepdefinition"},
        tags = "@zoho",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true
)
public class CucumberRunnerTest {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("extent-config.xml"));
    }

}



