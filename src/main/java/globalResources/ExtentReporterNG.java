package globalResources;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    
	public static ExtentReports getExtentReportObject()
	{
		
		String path=System.getProperty("user.dir")+"\\reports\\index1.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("PolicyDetails Results");
		reporter.config().setDocumentTitle("Test results");

		ExtentReports extent=new ExtentReports();
		//attaching the report 
		extent.attachReporter(reporter);
		//tester name
		extent.setSystemInfo("Tester", "Srinu");
		return extent;


	}
	
	
}