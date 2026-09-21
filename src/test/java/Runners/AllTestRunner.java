package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/FeatureFiles",
    glue = {"StepDefinations", "Hooks"},
    tags = "@homepage or @login or @register",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class AllTestRunner extends AbstractTestNGCucumberTests {
}