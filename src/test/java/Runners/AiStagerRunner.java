package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = {"StepDefinations", "Hooks"},
        tags = "@TC_HP_001 or @TC_HP_002 or @TC_HP_003 or @TC_HP_004 or @TC_HP_005 or @TC_LOG_001 or @TC_LOG_002 or @TC_LOG_003 or @TC_REG_001 or @TC_REG_002",
        plugin = {
                "pretty",
                "html:target/cucumber-report/index.html"
        }
)
public class AiStagerRunner extends AbstractTestNGCucumberTests {
}