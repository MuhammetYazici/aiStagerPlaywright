package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/FeatureFiles",
    glue = {"StepDefinations", "Hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },
    tags = "@Positive or @Negative or @EdgeCase"
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}