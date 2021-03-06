import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepdefinition"},
        tags = "@zoho",
        plugin = {"html:target/cucumber-reports/htmlReports.html","json:target/cucumber-reports/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/rerun.txt"},
        monochrome = true
)
public class CucumberRunnerTest {

}



