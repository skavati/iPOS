package cucumber;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/featureFiles"
		,glue={"stepDefinition"},format = {"pretty"}
		)
 


public class CucumberRunner {
	

}
