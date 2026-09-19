package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = {"StepDefinations", "Hooks"},
        tags = "@UserStory1 or @UserStory2 or @UserStory3",
        plugin = {
                "pretty",
                "html:target/cucumber-report/report.html"
        }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}