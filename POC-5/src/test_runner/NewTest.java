package test_runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="FEATURES" , glue="TestNG_Tests")
public class NewTest extends AbstractTestNGCucumberTests{
  
}
