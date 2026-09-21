package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = {"StepDefinations", "Hooks"},
        tags = "@US-AI-01 or @US-NAV-02",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}