package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "stepDefinition",
        monochrome = true, tags = "@Regressionn", plugin = {"html:target/cucumber-report.html"})

public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
