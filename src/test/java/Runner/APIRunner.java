package Runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;
import org.apache.commons.io.FileUtils;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.junit.Assert.assertTrue;

@KarateOptions(features="classpath:Sample",tags="~@ignore")

public class APIRunner {

    @Test
    public void testParallel() {

        Results results = Runner.parallel(getClass(), 2);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

    public static void generateReport(String karateOutputPath) {

        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
        List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Karate Gradle");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

    @Test
    public void executeKarateTest() {
        Runner.Builder aRunner = new Runner.Builder();
        aRunner.path("classpath:Sample");
        Results result = aRunner.parallel(5);
        // Extent Report
        CustomExtentReport extentReport = new CustomExtentReport()
                .withKarateResult(result)
                .withReportDir(result.getReportDir())
                .withReportTitle("Karate Test Execution Report");
        extentReport.generateExtentReport();

    }
}
