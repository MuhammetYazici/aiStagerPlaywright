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
        tags = "@UI or @Auth"
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}