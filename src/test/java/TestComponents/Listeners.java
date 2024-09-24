package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import globalResources.ExtentReporterNG;
import pageObjects.TestResultData;

public class Listeners extends BaseTest implements ITestListener {
	  ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getExtentReportObject();
   ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); 
	
	public void onTestStart(ITestResult result) {

		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Working as expected");
		
		if(result.getStatus()==1)
		{
		TestResultData.testResultData.put(result.getMethod().getMethodName()+"","Pass");

	} 
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.FAIL, "Pano Policy Details Sub Widget failed");
	extentTest.get().fail(result.getThrowable());

		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String filePath=null;
	
			try {
				filePath=getScreenshot(result.getMethod().getMethodName()+generateTimeStamp(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName()+generateTimeStamp());
			
			if(result.getStatus()==2)
			{
			TestResultData.testResultData.put(result.getMethod().getMethodName()+"","Fail");

		} 

		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stu
			extentTest.get().log(Status.SKIP, "Either Search API or Contract API failed.So,test Cases are skipped");

			if(result.getStatus()==3)
			{
			TestResultData.testResultData.put(result.getMethod().getMethodName()+"","Either Search API or Contract API failed.So,test Cases are skipped");

		} 
			

		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub

		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub

		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub

		}
		
        
		public void onFinish(ITestContext result) {
			// TODO Auto-generated method stub
			
			extent.flush();
			System.out.println("After class method executed");
			
			sendOutlookEmail();
		}


	}
