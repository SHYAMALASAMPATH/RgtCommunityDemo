package com.rgtcommunity.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/","rerun:failedscenarios/failedrun.txt"
				}, 
		monochrome = true,
		glue = { "com.rgtcommunity.stepdefinitions" },
		features = { "src\\main\\java\\com\\rgtcommunity\\features" }
)

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}