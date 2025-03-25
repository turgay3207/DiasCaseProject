package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
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
        tags = "@api"  //Ui tagleri:@hepsiburada @ui //// API tagi: @api

)
public class Runner extends AbstractTestNGCucumberTests {


}
