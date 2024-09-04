package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNg {
    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("My Test Results");

       ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Quality Engineer","Kaushal Brahmbhatt");
        extent.createTest(path);
        return extent;

    }
}
