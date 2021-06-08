package com.rgtcommunity.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\main\\java\\com\\rgtcommunity\\features",
glue = "com.rgtcommunity.stepdefinitions",tags = "@A",
plugin= {"pretty","html:target/MyReports/cucumber.html","json:target/MyReports/cucumber.json","junit:target/MyReports/cukes.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:failedscenarios/failedrun.txt","timeline:test-output-thread/"},
monochrome = true,
dryRun =false,
strict = true
)
public class Testngrunner extends AbstractTestNGCucumberTests
{
	
	
}
