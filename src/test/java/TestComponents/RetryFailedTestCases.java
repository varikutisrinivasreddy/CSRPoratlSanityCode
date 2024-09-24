package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
	int count=0;
	int maxTry=1;

	//as long as this method returns true, your test test will keep on retry again and again
	public boolean retry(ITestResult result) {
		
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}
 