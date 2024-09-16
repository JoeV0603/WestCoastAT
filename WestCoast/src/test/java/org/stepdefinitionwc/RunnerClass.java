package org.stepdefinitionwc;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\joevi\\eclipse-workspace\\WestCoast\\src\\test\\resources\\Feature\\Endtoend.feature", 
                 glue = { "org.stepdefinitionwc" }, 
                 monochrome = true, 
                 plugin = { "pretty", "html:C:\\Users\\joevi\\eclipse-workspace\\WestCoast\\target//End2EndReport" })

public class RunnerClass {

}