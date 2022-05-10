package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features=".//Features/Customer.feature",
		glue= {"stepDefinitions"},
		plugin= {"pretty", "html:test-output.html", "rerun:failedTestcase.txt"},
		dryRun=false,
		monochrome=true
		)

public class FailedRunner {

}
