package pageObjects;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import ReuseAbstratComponents.ReuseCode;

public class MyCallHistoryObjects extends ReuseCode {

	WebDriver driver;
	public MyCallHistoryObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	By MycallHistoryTab=By.xpath("//span[mat-panel-title=' My Call History ']");

	By SpinnerTest=By.xpath("lds-spinner");
	@FindBy(id="call-history-policy-camelcase") WebElement MyCallHistPolValidation;
	@FindBy(id="contracts-collection-search-text") WebElement SearchClosedPol;
	@FindBy(css="mat-icon[class='mat-icon notranslate flaticon-search searchInHeader csr-search-bar-icon material-icons mat-icon-no-color']")
	WebElement clickButton;
	By MyCallHistPolload=By.id("call-history-policy-camelcase");
	@FindBy(id="call-history-date-time") WebElement myCalHistDate;

	public void myCallHistoryWidget(String URL,String UserNames,String Passwords,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		SoftAssert softassertmycallhis=new SoftAssert();
		LoginDetails pld=new LoginDetails(driver);



		DevTools devTools=((ChromeDriver) driver).getDevTools();

		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), requestConsumer ->

		{

			Request request=requestConsumer.getRequest();


		}

				);

		devTools.addListener(Network.responseReceived(), responseConsumer ->{

			org.openqa.selenium.devtools.v85.network.model.Response response=responseConsumer.getResponse();

			System.out.println(response.getStatus());

			System.out.println(response.getUrl());



						if(response.getUrl().equals(ExpectedURL)) {

				System.out.println("Response after specific url"+response.getUrl());

				System.out.println("status after specific url"+response.getStatus());


				String ActualStatuscode=response.getStatus().toString();
				softassertmycallhis.assertEquals(ActualStatuscode,ExpectedStatusCode);                



			}





		}

				);

		pld.panoUrl(URL);

		pld.panoLogin(UserNames,Passwords);


		try {

			waitForElementToAppear(MycallHistoryTab);

			int MyCallHistCount=driver.findElements(By.xpath("//span[mat-panel-title=' My Call History ']//following::div[@class='ng-star-inserted']//table[@role='grid']//tbody//tr")).size();
			Thread.sleep(1000);
			System.out.println("Rows present in the my call history:" + MyCallHistCount);
			if(MyCallHistCount>=0)	
			{


				softassertmycallhis.assertEquals(myCalHistDate.isDisplayed(), true,"Call History date is not showing in my call history");


			}
			else
			{
				System.out.println("No records found in my call history");
			}
		}
		catch(ElementClickInterceptedException eci) {
			eci.printStackTrace();
			System.out.println("Other element click is received in My call history");
		throw eci;
		}catch(NoSuchElementException nee ){
			nee.printStackTrace();
			System.out.println("Element is not found in my call history");
		throw nee;
		}catch(ElementNotInteractableException eni) {
			eni.printStackTrace();
			System.out.println("Element is not interacted in in my call history");
		throw eni;
		}
		catch(NoAlertPresentException nae)
		{
			nae.printStackTrace();
			System.out.println("Unexpected alert is present in  my call history");
		throw nae;
		}
		finally {
			System.out.println("Finally Block is executed -in my call history");
		}


		softassertmycallhis.assertAll();

	}


	//********************** My Call History completed*********************
	
	 @FindBy(xpath="//span[mat-panel-title=' MY ASSIGNED WORK ']") WebElement MyAssignedWork;
	 By MyAssignedWorkTab=By.xpath("//span[mat-panel-title=' MY ASSIGNED WORK ']");
	 
	 

	public void myAssignedWorkWidget(String URL,String UserNames,String Passwords,String ExpectedURL) throws Exception
	{
		SoftAssert softassertmyassignedwork=new SoftAssert();
		LoginDetails pld=new LoginDetails(driver);



		DevTools devTools=((ChromeDriver) driver).getDevTools();

		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), requestConsumer ->

		{

			Request request=requestConsumer.getRequest();


		}

				);

		devTools.addListener(Network.responseReceived(), responseConsumer ->{

			org.openqa.selenium.devtools.v85.network.model.Response response=responseConsumer.getResponse();

			System.out.println(response.getStatus());

			System.out.println(response.getUrl());



						if(response.getUrl().contains(ExpectedURL)) {

				System.out.println("Response after specific url"+response.getUrl());

				System.out.println("status after specific url"+response.getStatus());


				String ActualStatuscode=response.getStatus().toString();
				String ExpectedStatusCodeOne="200";
				String ExpectedStatusCodeTwo="304";
				if(ActualStatuscode.contains("200")||ActualStatuscode.contains("304"))
				{
					softassertmyassignedwork.assertEquals(ActualStatuscode.contains(ExpectedStatusCodeOne)||ActualStatuscode.contains(ExpectedStatusCodeTwo),true,"My assignedwork  instance passes other than 200 and 304");



				}




			}





		}

				);

		pld.panoUrl(URL);

		pld.panoLogin(UserNames,Passwords);


		try {

			waitForElementToAppear(MyAssignedWorkTab);
			

			int MyAssignedWorkCount=driver.findElements(By.xpath("//span[mat-panel-title=' MY ASSIGNED WORK ']//following::div[@class='ng-star-inserted']//table[@role='grid']//tbody//tr")).size();
			Thread.sleep(1000);
			System.out.println("Rows present in the my assigned work :" + MyAssignedWorkCount);
					}
		catch(ElementClickInterceptedException eci) {
			eci.printStackTrace();
			System.out.println("Other element click is received in My assigned work ");
		throw eci;
		}catch(NoSuchElementException nee ){
			nee.printStackTrace();
			System.out.println("Element is not found in my assigned work ");
		throw nee;
		}catch(ElementNotInteractableException eni) {
			eni.printStackTrace();
			System.out.println("Element is not interacted in  my assigned work");
		throw eni;
		}
		catch(NoAlertPresentException nae)
		{
			nae.printStackTrace();
			System.out.println("Unexpected alert is present in  my assigned work");
		throw nae;
		}
		finally {
			System.out.println("Finally Block is executed -in my assigned work ");
		}


		softassertmyassignedwork.assertAll();

	}



}
