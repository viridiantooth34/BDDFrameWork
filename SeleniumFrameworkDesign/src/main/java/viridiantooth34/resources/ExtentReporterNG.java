package viridiantooth34.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String reportPath = System.getProperty("user.dir") + "\\ExtentReports\\report"+System.currentTimeMillis()+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("Test Report");
		spark.config().setReportName("Rick Bakshi");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Rick B");

		return extent;

	}
}
