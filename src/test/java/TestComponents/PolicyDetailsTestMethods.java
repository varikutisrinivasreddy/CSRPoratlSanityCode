package TestComponents;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameters;


import pageObjects.LoginDetails;
import pageObjects.PolDetWidget;


public class  PolicyDetailsTestMethods extends BaseTest {
	
	
	@Test(priority = 2,dataProviderClass=BaseTest.class,dataProvider="PolicyData")

	public void SearchFunctionality(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	
	{
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.Search(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
		
	}
	
	
	@Test(priority = 3,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"SearchFunctionality"})
	public void PolicyContractDetails(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	
	{
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.policyContractDetailsValidation(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);



	}
	
	
	@Test(priority = 4,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})

	public void PolicyDetailsTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		//Calling extent reports here
		//ExtentTest test=extent.createTest("Policy Details Sub Widget Validation");
	PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
	panopoldetsubwidget.policyDetailsValidation(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
	
		
	}


	
	@Test(priority = 5,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	public void PolicyBillingTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.policyBillingValidation(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);

	}



	
	@Test(priority = 6,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})

	public void PolicyValuesTabTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.policyWholeLifeValuesTabValidation(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);


	}

	//****************************Policy Details- Loans Tab**********************************
	
	@Test(priority = 7,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	
	public void PolicyLoansTabTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception

	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.wholeLifeLoansTab(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
	}


	@Test(priority = 8,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	public void PolicyRidersTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.wholeLifePolicyRidersTab(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
	}

	
	
	
	@Test(priority = 9,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	public void PolicyFundsTabTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		
		panopoldetsubwidget.wholeLifePolicyFundsTab(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);

	}
	
	

	@Test(priority = 10,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	
	public void PolicySuspenseTabTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.wholeLifePolicySuspenseTab(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
		
		
				
	}

	
	
	@Test(priority = 11,dataProviderClass=BaseTest.class,dataProvider="PolicyData",dependsOnMethods = {"PolicyContractDetails"})
	public void PolicyNOtesTabTest(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.wholeLifeNotesTab(URL,UserNames,Passwords,Policy,ExpectedURL,ExpectedStatusCode);
		
				
		
		
	}
	
	@Test(priority = 1,dataProviderClass=BaseTest.class,dataProvider="PolicyData")
	public void MyCallHistoryValidation(String URL,String UserNames,String Passwords,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);

		panopoldetsubwidget.myCallHistoryWidget(URL,UserNames,Passwords,ExpectedURL,ExpectedStatusCode);
		
				
		
		
	}
	
	
	@Test(priority = 0,dataProviderClass=BaseTest.class,dataProvider="PolicyData")
	public void MyAssignedWorkValidation(String URL,String UserNames,String Passwords,String ExpectedURL) throws Exception
	{
		
		
		PolDetWidget panopoldetsubwidget=new PolDetWidget(driver);
		panopoldetsubwidget.myAssignedWorkWidget(URL,UserNames,Passwords,ExpectedURL);
		
				
		
		
	}
	
	

	
	
	}
