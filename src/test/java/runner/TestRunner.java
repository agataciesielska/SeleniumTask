package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features",
        glue = {"steps"},
        tags = {"@testgate"},
        strict = false
)

public class TestRunner extends AbstractTestNGCucumberTests {
}