package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinations", "Hooks"},
    tags = "@Positive or @Negative or @StateManagement or @UI or @EdgeCase",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class SolutionsRunner extends AbstractTestNGCucumberTests {
}