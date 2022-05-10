package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(

		features=".//Features",
		glue= {"stepDefinitions"},
		plugin= {"pretty","html:target/teset-output.html"},
		dryRun=false,
		monochrome=true,
		tags= "@regression"
		)



public class Runner {

}
