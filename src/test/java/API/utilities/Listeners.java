package API.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {

	ExtentTest test;
	ExtentReports reports;

	public Listeners() throws IOException {
		reports = ExtentReportManager.getReport();
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.createTest(result.getName());
		System.out.println("Test started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test success");

		test.log(Status.PASS, "Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.FAIL, "Fail");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.SKIP, "Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		reports.flush();
	}

}
