package com.rgtcommunity.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\main\\java\\com\\rgtcommunity\\features"},
		glue = {"com.rgtcommunity.stepdefinitions"},
		tags= "@A",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"})
public class MyTestRunner 
{

}
