package omf.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"./src/main/resources"},
        tags = "@regression",
        glue = {"omf"},
        dryRun = false,
        plugin = {"json:target/jsonReports/cucumber.json",
                "pretty", "html:target/RunCuke/cucumber.html"}
        , monochrome = true
)
public class TestRunner {
}

