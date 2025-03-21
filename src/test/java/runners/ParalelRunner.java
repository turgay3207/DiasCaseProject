package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.Driver;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/html-reports/cucumber.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        },
        features = "./src/test/resources/features",
        glue = {"stepdefinitions",
                "hooks"},
        monochrome = true,
        publish = true,
        dryRun = false,
        tags = "@ui"
)
public class ParalelRunner extends AbstractTestNGCucumberTests {

        @BeforeClass
       @Parameters("browser")
        public void setup(String browser) {
                Driver.getDriver(browser);
        }
}
