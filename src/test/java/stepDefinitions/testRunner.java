package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class testRunner {
    @RunWith(Cucumber.class)
    @CucumberOptions(features="src/test/resources/features",
            glue={"stepDefinitions"})
    public class TestRunner {
    }

    monochrome = true

    plugin = { "pretty", "html:target/reports"}
    plugin = { "pretty", "json:target/reports/cucumber.json"}
    plugin = { "pretty",  "junit:target/reports/cucumber.xml"}

    tags="@smoketest"
}
