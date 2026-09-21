package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/FeatureFiles",
    glue = {"StepDefinations", "Hooks"},
    tags = "@smoke or @positive or @negative or @security or @edge-case",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}