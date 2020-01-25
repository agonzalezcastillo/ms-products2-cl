package com.bct.msproducts2cl;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources", strict = true, plugin ="json:target/cucumber-report.json")
public class CucumberTest {
}
