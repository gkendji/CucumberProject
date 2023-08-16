package cucumberOptions;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true)

@Test	
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
			
}
