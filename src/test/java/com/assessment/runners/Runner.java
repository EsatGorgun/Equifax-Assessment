package com.assessment.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        plugin      =   "html:target/cucumber/cucumber-report.html",
        features    =   "src\\test\\resources\\features",
        glue        =   "com\\assessment\\step_Definitions",
        dryRun      =   false
        )

public class Runner {

}
