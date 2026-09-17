package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinations", "Hooks"},
    tags = "@Pozitif or @EdgeCase",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class AccountTestRunner extends AbstractTestNGCucumberTests {
}