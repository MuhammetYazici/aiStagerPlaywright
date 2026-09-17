package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinations", "Hooks"},
        tags = "@positive or @negative or @edge_case",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/solutions-report.html",
                "json:target/cucumber-reports/solutions-report.json"
        }
)
public class SolutionsRunner extends AbstractTestNGCucumberTests {
}