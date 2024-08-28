package viridiantooth34.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import viridiantooth34.TestComponents.BaseTest;
import viridiantooth34.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	WebDriver driver;
//	public Listeners(WebDriver driver){
//		//super();
//		this.driver = driver;
//		// TODO Auto-generated constructor stub
//	}
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		// not implemented
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// not implemented
		test.log(Status.PASS, "Test Passed:" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// not implemented
		// test.log(Status.FAIL, "Test Passed:"+result.getMethod().getMethodName());
		test.fail(result.getThrowable());

		Utilities utility = new Utilities();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//"+utility.takeFullScreenShot(driver)+".png");
		System.out.println(System.getProperty("user.dir")+"//"+utility.takeFullScreenShot(driver)+".png");
		// System.out.println("Screenshot for : "+result.getMethod().getMethodName());
		// TakeScreenshot

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		// not implemented
		extent.flush();
	}

}
