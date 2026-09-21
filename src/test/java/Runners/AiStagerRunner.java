package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = {"StepDefinations", "Hooks"},
        tags = "@AiStager",
        plugin = {"pretty", "html:target/site/cucumber-pretty.html"}
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}