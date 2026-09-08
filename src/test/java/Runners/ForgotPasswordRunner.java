package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinations","Hooks"},
        tags = "@ForgotPassword",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"}
)

public class ForgotPasswordRunner extends AbstractTestNGCucumberTests {
}
