package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue= {"StepDefinitions"},
monochrome = true,

plugin = {"pretty", "junit:target/junit/report.xml",
		"html:target/html/HtmlReports",
		"json:target/JSONReports/report.json"},
tags="@Sorting_HL"

		)

public class pra {

	public pra() {
		// TODO Auto-generated constructor stub
	}

}
