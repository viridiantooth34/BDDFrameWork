package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/cucumber", glue = "viridiantooth34.StepDefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestRunner implements AbstractTestNGCucumberTests {

}
