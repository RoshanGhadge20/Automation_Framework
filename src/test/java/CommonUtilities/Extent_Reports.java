package CommonUtilities;

import java.io.File;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reports {
	ExtentSparkReporter extentsparkreporter;
	ExtentReports extentreports;
	ExtentTest extenttest;

	public void start_reporter() {
		File reportDir = new File(System.getProperty("user.dir") + "/Test_Reports");
		if (!reportDir.exists()) {
			reportDir.mkdirs();
		}
		extentsparkreporter = new ExtentSparkReporter(reportDir + "/Report.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(extentsparkreporter);

		// Adding reporting details
		extentsparkreporter.config().setDocumentTitle("Amazon Test Automation Report");
		extentsparkreporter.config().setReportName("QA,Test Reports");
		extentsparkreporter.config().setTheme(Theme.DARK);
		extentsparkreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, result.getThrowable());
		} else {
			extenttest.log(Status.SKIP, result.getThrowable());
		}
	}

	public void test_details(String des) {
		extenttest = extentreports.createTest(des);
	}

	public void tear_down() {
		extentreports.flush();
	}
}
