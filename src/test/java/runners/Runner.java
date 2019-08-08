package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberreports","json:target/report.json"},
        features = "/Users/Azika/Desktop/chicago11cucumberjUnit/src/test/resources/features",
        glue = "steps",
        tags = "@wikipedia",
        dryRun = true
)
public class Runner {

}