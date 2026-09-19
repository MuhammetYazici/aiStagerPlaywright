package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinations", "Hooks"},
    tags = "@Home or @Login or @Register",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}