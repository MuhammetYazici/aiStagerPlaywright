package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinations", "Hooks"},
    tags = "@regression or @smoke",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}