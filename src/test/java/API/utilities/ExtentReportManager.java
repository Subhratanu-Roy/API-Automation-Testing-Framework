package API.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	public static ExtentReports getReport() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "//resources//Globaldata.properties"));
		Properties prop = new Properties();
		prop.load(fis);
		String timestamp = sdf.format(new Date());
		String reportname = "Test-Report-" + timestamp + ".html";
		String path = System.getProperty("user.dir") + "//reports//" + reportname;
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(path));
		reporter.config().setDocumentTitle("API Automation");
		reporter.config().setReportName("API Automation Report");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application", prop.getProperty("Application"));
		reports.setSystemInfo("Tester", prop.getProperty("Tester"));
		reports.setSystemInfo("Environment", prop.getProperty("Environment"));
		reports.setSystemInfo("URL", prop.getProperty("URL"));
		return reports;
	}

}
