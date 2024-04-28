package kamlanadh.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	

	
	public static ExtentReports getreportObject()
	{
		String path=System.getProperty("user.dir")+"/report/index.html";
		//String path="/Users/kamalnadh/eclipse-workspace/ExtentReport/reports/index.html";
		ExtentSparkReporter report =new ExtentSparkReporter(path);
		report.config().setReportName("Automation Report");
		report.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Kamal");
		return extent;
		
	}
}
