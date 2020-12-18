package stepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Cucumber/CucumberPractice.feature"},
		glue = {"stepDef"},
		plugin = {"pretty" , 
				"json:target/Cucumber-Reports/cucumber.json",
				"html:target/Cucumber-Reports/cucumber.html"},
		monochrome = true
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {


}
