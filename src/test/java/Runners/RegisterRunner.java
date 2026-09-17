package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinations", "Hooks"},
    tags = "@pozitif or @edge_case or @negatif",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class RegisterRunner extends AbstractTestNGCucumberTests {
}