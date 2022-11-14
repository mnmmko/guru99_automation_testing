package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import test.base_test;
@CucumberOptions(
        features = "src/main/reasources/feature",
        glue = "steps"
)

public class runner extends AbstractTestNGCucumberTests {
}
