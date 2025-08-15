package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(System.getProperty("user.dir") +"test-output/extent-report.html");
        }
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Emma");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        sparkReporter.config().setTimelineEnabled(true);
        // Đảm bảo CSS/JS được nhúng vào file HTML để Jenkins load không bị mất
        sparkReporter.config().setCss("body { zoom: 90%; }");
        return extent;
    }
}
