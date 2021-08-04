package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(glue="", plugin = {"json:${buildDir}/reports/tests/cucumber-report.json"} ,features="src/test/resources")
//@CucumberOptions(
//        features = {"."},
//        glue = {"Sample.DemoTest", "/src/test/resources"},
//        monochrome = true,
//        plugin = {"json:${buildDir}/reports/tests/cucumber-report.json"}
//)
public class CucumberTest {}