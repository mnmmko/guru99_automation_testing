package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        tags = "@tast01",
        glue = "com/example/steps",
        plugin = {
                "json:target/cucmber.json",
                "html:target/reports.html"

        }
)

public class runner extends AbstractTestNGCucumberTests {
}
