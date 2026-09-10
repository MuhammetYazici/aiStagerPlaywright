package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinations", "Hooks"},
        tags = "@negative_auth",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
