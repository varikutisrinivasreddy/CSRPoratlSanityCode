package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.apache.logging.log4j.LogManager;





import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReuseAbstratComponents.ReuseCode;





public class PolDetWidget extends ReuseCode{
	WebDriver driver;
	public static org.apache.logging.log4j.Logger log;
	




	public PolDetWidget(WebDriver driver)
	{
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	//Policy Details widget web elements
	@FindBy(id="policy-details-policy-status-desc-action-checkbox")
	WebElement PolDetStatus;
	@FindBy(id="policy-details-paid-to-date-action-checkbox")
	WebElement PolDetPaidToDate;
	@FindBy(id="policy-details-grace-period-end-date-action-checkbox")
	WebElement PolDetGracePeriod;
	@FindBy(id="policy-details-suspend-code-desc-action-checkbox")
	WebElement PolDetSusCode;
	@FindBy(id="policy-details-company-code-action-checkbox")
	WebElement PolDetComCode;
	@FindBy(id="policy-details-restriction-code-desc-action-checkbox_label")
	WebElement PolRestCode;
	@FindBy(id="policy-details-policy-number-action-checkbox")
	WebElement PolNum;
	@FindBy(id="policy-details-plan-code-action-checkbox")
	WebElement PolDetPlanCode;
	By SpinnerTest=By.xpath("lds-spinner");
	@FindBy(id="save-close-close-call-button") WebElement CloseCall;
	@FindBy(id="selected-roles-reason-select") WebElement CallDispositionDropDownClick;
	@FindBy(xpath="//div[contains(text(),'Reinstatement')]") WebElement CallDispositionChkInqSel;
	@FindBy(id="close-call-phone-number-text") WebElement CloseCallPhn;




	@FindBy(id="policy-details-product-name-action-checkbox")
	WebElement PolDetProdName;
	@FindBy(id="policy-details-product-type-desc-action-checkbox")
	WebElement PolDetProType;
	@FindBy(id="policy-details-premium-class-code-action-checkbox")
	WebElement PolDetRateClass;
	@FindBy(id="policy-details-issue-date-action-checkbox")
	WebElement PolDetIssueDate;
	@FindBy(id="policy-details-mec-date-action-checkbox")
	WebElement PolDetMectDate;
	@FindBy(id="policy-details-maturity-date-action-checkbox")
	WebElement PolDetMatDate;
	@FindBy(id="policy-details-originating-system-action-checkbox")
	WebElement PolDetOrgSys;
	@FindBy(id="policy-details-issue-state-desc-action-checkbox")
	WebElement PolDetIssueState;
	@FindBy(id="authorize-undefined-button")
	WebElement AuthorizeButton;
	//Policy Details Billing widget Web Elements
	@FindBy(xpath="//span[text()='Billing']")
	WebElement Billing;
	@FindBy(id="billing-info-paid-to-date-action-checkbox_label")
	WebElement BillPtd;
	@FindBy(id="billing-info-bill-option-desc-action-checkbox_label")
	WebElement BillMethod;
	@FindBy(id="billing-info-bill-client-number-action-checkbox_label")
	WebElement ListBill;
	@FindBy(id="billing-info-billing-frequency-desc-action-checkbox_label")
	WebElement BillFrq;
	@FindBy(id="billing-info-modal-premium-action-checkbox_label")
	WebElement BillAmt;
	@FindBy(id="policy-details-total-premium-paid-action-checkbox_label")
	WebElement BillTpd;
	@FindBy(id="billing-info-total-monthly-mode-premium-action-checkbox_label")
	WebElement BillMonPre;

	@FindBy(id="billing-info-total-quarterly-mode-premium-action-checkbox_label")
	WebElement BillQatPrem;
	@FindBy(id="billing-info-total-semi-annual-mode-premium-action-checkbox_label")
	WebElement BillSemPre;
	@FindBy(id="billing-info-total-annual-mode-premium-action-checkbox_label")
	WebElement BillAnnPrem;
	@FindBy(id="billing-info-accelerated-payment-action-checkbox_label")
	WebElement BillAccPrem;

	//Whole Life base Values tab
	@FindBy(xpath="//span[text()='Values']")
	WebElement ValuesTabClick;
	@FindBy(id="quote-values-undefined-button")
	WebElement VauesQuoteTabWmaDate;
	@FindBy(id="policy-values-messeage-action-checkbox_label")
	WebElement ValuesTabMessageCheckbox;
	@FindBy(id="policy-values-face-amount-action-checkbox_label")
	WebElement ValuesTabFaceAmtCheckbox;
	@FindBy(id="policy-values-accumulated-cash-value-action-checkbox_label")
	WebElement ValuesTabAccCashValCheckbox;
	@FindBy(id="policy-values-cash-surrender-value-action-checkbox_label")
	WebElement ValuesTabCashSurValueCheckbox;
	@FindBy(id="policy-values-net-death-benefit-amount-action-checkbox_label")
	WebElement ValuesTabDeathBenAmtCheckbox;
	@FindBy(id="policy-values-primary-div-opt-action-checkbox_label")
	WebElement ValuesTabprimaryDivOptCheckbox;
	@FindBy(id="policy-values-secondary-div-opt-action-checkbox_label")
	WebElement ValuesTabSecondaryDivOptCheckbox;
	@FindBy(id="policy-values-max-withdrawal-amt-nogain-action-checkbox_label")
	WebElement ValuesTabMaxWdlWoCaGainCheckbox;
	@FindBy(id="policy-values-max-withdrawal-amt-action-checkbox_label")
	WebElement ValuesTabMaxWdlAmountCheckbox;
	@FindBy(id="policy-values-total-div-acc-amt-action-checkbox_label")
	WebElement TotDivAccAmount;
	@FindBy(id="policy-values-last-year-of-dividend-credit-action-checkbox_label")
	WebElement ValuesTabLastYearDivCredit;
	@FindBy(id="policy-values-cost-basis-action-checkbox_label")
	WebElement ValuesTabCostBasisCheckBox;
	@FindBy(id="policy-values-transaction-gain-action-checkbox_label")
	WebElement ValuesTabTrxGain;

	//Whole Life Loans tab
	@FindBy(xpath="//span[text()='Loan']")
	WebElement WholeLifeLoansTabClick;
	@FindBy(id="loan-values-messeage-action-checkbox_label")
	WebElement WholeLifeLoansMessage;
	@FindBy(id="loan-values-max-loanable-value-action-checkbox_label")
	WebElement WholeLifeLoansMaxLoanAmt;
	@FindBy(id="loan-values-loan-payoff-amount-action-checkbox_label")
	WebElement WholeLifeLoansPayoffVal;

	//WholeLife Riders
	@FindBy(xpath="//span[text()='Riders']")
	WebElement WholeLifeRidersTabClick;
	@FindBy(id="selected-coverage-coverage-plan-code-action-checkbox_label")
	WebElement WholeLifeRiderName;
	@FindBy(id="selected-coverage-current-coverage-amount-action-checkbox_label")
	WebElement WholeLifeRideramount;
	@FindBy(id="selected-coverage-coverage-name-action-checkbox_label")
	WebElement WholeLifeRiderCovType;
	@FindBy(id="selected-coverage-coverage-party-name-action-checkbox_label")
	WebElement WholeLifeRiderCovName;
	@FindBy(id="selected-coverage-coverage-status-desc-action-checkbox_label")
	WebElement WholeLifeRiderStatus;
	@FindBy(id="selected-coverage-coverage-effective-date-action-checkbox_label")
	WebElement WholeLifeRiderEffDate;
	@FindBy(id="selected-coverage-coverage-termination-date-action-checkbox_label")
	WebElement WholeLifeRiderTermDate;
	@FindBy(id="selected-coverage-rider-premium-action-checkbox_label")
	WebElement WholeLifeRiderModal;
	@FindBy(id="selected-coverage-death-benefit-amount-indicator-action-checkbox_label")
	WebElement WholeLifeRiderDeathBenInd;
	@FindBy(xpath="//span[text()='Riders']//following::span[12]")
	WebElement RidersMsg;
	@FindBy(id="rider-123-rider-messeage-checkbox_label")
	WebElement RiderMsgChkBox;


	//WholeLife BAse Funds
	@FindBy(xpath="//span[text()='Funds']")
	WebElement WholeLifeFundsTabClick;
	@FindBy(xpath="//span[text()='Funds']//following::span[contains(text(),'applicable for this product')]")
	WebElement WholeLifeFundsTabMsg;
	By WholeLifeFundsTabMsgVisible=By.xpath("//span[text()='Funds']//following::span[contains(text(),'applicable for this product')]");
	//sUSPENSE
	@FindBy(xpath="//span[text()='Suspense']")
	WebElement WholeLifeSuspenseTabClick;
	@FindBy(id="policy-suspensFunds are not applicable for this product. e-no-records-suspence-label_label")
	WebElement SusMesg;
	@FindBy(id="checkboxInTable_policySuspense_0_0")
	WebElement WholeLifeSusEffDate;
	@FindBy(xpath="//span[text()='Suspense']//following::mat-card-content[@class='mat-card-content ng-star-inserted'][2]")
	WebElement WholeLifeSuspense;

	//Nfo Info
	@FindBy(xpath="//span[text()='NFO Information']")
	WebElement NfoInfoTabClick;
	@FindBy(id="policy-details-non-forfeit-override-indicator-desc-action-checkbox")
	WebElement NfoInfo;
	@FindBy(id="policy-details-nfo-eti-coverage-amt-action-checkbox")
	WebElement NfoCvgAmt;

	//nOTES TAB
	@FindBy(xpath="//span[text()='Notes']")
	WebElement NoteTabClick;
	@FindBy(xpath="//span[text()='Notes']//following::mat-card-content[@class='mat-card-content ng-star-inserted'][2]")
	WebElement NoteTabRecords;
	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Message')][1]")
	WebElement NoteMsgCheck;
	By NoteMsgCheckAppear = By.xpath("//span[text()='Notes']//following::span[contains(text(),'Message')][1]");

	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Operator ID')][1]")
	WebElement NoteOprId;
	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Note Type')][1]")			
	WebElement NoteType;
	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Type Number')][1]")			
	WebElement NoteTypeNum;

	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Date')][1]")
	WebElement NoteDate;

	@FindBy(id="authorize-undefined-button")
	WebElement AuthorizedButtonCli;




	//*********************************************Policy Details*******************************************************************


	By StatusCheck = By.id("policy-details-policy-status-desc-action-checkbox");
	By polDtailsAppear=By.xpath("//span[text()='Details']");
	@FindBy(xpath="//span[text()='Details']") WebElement polDetClick;
	By PolicyDetailsWidgt=By.xpath("//span[mat-panel-title=' Policy Details ']");
	@FindBy(xpath="//span[mat-panel-title=' Policy Details ']") WebElement PolicyDetailsWidgtClick;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[1]")
	WebElement reqDetPolSta;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[2]")
	WebElement reqDetPolGra;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[3]")
	WebElement reqDetPolResCode;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[4]")
	WebElement reqDetPolSusCode;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[5]")
	WebElement reqDetPolComCode;
	@FindBy(xpath="//span[text()='DETAILS']//following::dd[6]")
	WebElement reqDetPolNum;
	@FindBy(xpath="//label[@id='policy-details-policy-status-desc-label']") WebElement PolDetStaVal;
	@FindBy(xpath="//label[@id='policy-details-paid-to-date-label']") WebElement polDetPtdVal;
	@FindBy(xpath="//label[@id='policy-details-grace-period-end-date-label']") WebElement polDetgraPerVal;
	@FindBy(xpath="//label[@id='policy-details-restriction-code-desc-label']") WebElement polDetrestCodeVal;
	@FindBy(xpath="//label[@id='policy-details-suspend-code-desc-label']") WebElement polDetsusCodeVal;
	@FindBy(xpath="//label[@id='policy-details-company-code-label']") WebElement polDetComCodeVal;
	@FindBy(xpath="//label[@id='policy-details-policy-number-label']") WebElement polDetPolNumVal;


	@FindBy(css="mat-icon[class='mat-icon notranslate flaticon-search searchInHeader csr-search-bar-icon material-icons mat-icon-no-color']")
	WebElement clickButton;





	//***************************************Search Functionality


	@FindBy(xpath="lds-spinner")
	WebElement Spinner;
	@FindBy(id="contracts-collection-search-text")
	WebElement Search;

	By SearchText=By.id("contracts-collection-search-text");

	public void Search(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{


		SoftAssert softassertsearch=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());





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

			System.out.println("Status of the URL"+response.getStatus());

			System.out.println("res of the URL"+response.getUrl());





			if(response.getUrl().equals(ExpectedURL)) {

				System.out.println("Response after specific url"+response.getUrl());

				System.out.println("status after specific url"+response.getStatus());


				String ActualStatuscode=response.getStatus().toString();
				System.out.println("After code"+ActualStatuscode);
				System.out.println(ExpectedStatusCode);

				softassertsearch.assertEquals(ActualStatuscode,ExpectedStatusCode);

			}








		}


				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);







		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)||ProdRegion.equals(URL)||BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{

			pld.panoUrl(URL);


			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);




			try {
				waitForElementToAppear(SearchText);
				Thread.sleep(2000);
			}

			catch(Exception nee ){
				nee.printStackTrace();
				System.out.println("Message is" + nee.getMessage());
				System.out.println("Search Text edit is not found for policy search ");
				log.error("Exception Occured",new Exception("Exception Occured while click on text edit in the search for policy search" ));
				throw nee;
			}

			try {
				click(Search);
				Thread.sleep(1000);
			}

			catch(Exception SearchClick ){
				SearchClick.printStackTrace();
				System.out.println("Message is" + SearchClick.getMessage());
				System.out.println("Search Text edit is not clikced/disabled for entering the policy in the search ");
				log.error("Exception occured",new Exception("Search Text edit is not clikced/disabled for entering the policy in the search"));
				throw SearchClick;
			}

			Search.sendKeys(Policy);
			try {
				click(clickButton);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(5000);
			}
			catch(Exception SearchButtonClick ){
				SearchButtonClick.printStackTrace();
				System.out.println("Message is" + SearchButtonClick.getMessage());
				System.out.println("Search button is not clikced after entering the policy in the search ");
				log.error("Exception occured",new Exception("Search button is not clikced after entering the policy in the search "));
				throw SearchButtonClick;
			}



		}


		softassertsearch.assertAll();
	}




	//***************** Search Functionality Completed***




	// Contract API Validation

	public void policyContractDetailsValidation(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception

	{

		SoftAssert softassertcontractdetails=new SoftAssert();

		log=LogManager.getLogger(PolDetWidget.class.getName());



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

			System.out.println("Status of the URL"+response.getStatus());

			System.out.println("res of the URL"+response.getUrl());



			if(response.getUrl().equals(ExpectedURL)) {

				System.out.println("Response after specific url"+response.getUrl());

				System.out.println("status after specific url"+response.getStatus());


				String ActualStatuscode=response.getStatus().toString();
				System.out.println("After code"+ActualStatuscode);
				System.out.println(ExpectedStatusCode);



				softassertcontractdetails.assertEquals(ActualStatuscode,ExpectedStatusCode);

			}
		}

				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);







		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)||BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);


			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);

			Thread.sleep(1000);



			policysearchpage.Authorized();
			softassertcontractdetails.assertEquals((ButtonCheck(AuthorizedButtonCli)), false,"Authorized button is not clicked");





		}



		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);


			policysearchpage.SearchButton();



			policysearchpage.searchPolNum(Policy);


		}
		softassertcontractdetails.assertAll();
	}

	// Contract API is completed***********************************************************************



	//***************************Policy Details- Details*******************************



	public void policyDetailsValidation(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception

	{

		SoftAssert softassertdetails=new SoftAssert();

		log=LogManager.getLogger(PolDetWidget.class.getName());



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

			System.out.println("Status of the URL"+response.getStatus());

			System.out.println("res of the URL"+response.getUrl());



			if(response.getUrl().equals(ExpectedURL)) {

				System.out.println("Response after specific url"+response.getUrl());

				System.out.println("status after specific url"+response.getStatus());


				String ActualStatuscode=response.getStatus().toString();
				System.out.println("After code"+ActualStatuscode);
				System.out.println(ExpectedStatusCode);


				softassertdetails.assertEquals(ActualStatuscode,ExpectedStatusCode);

			}
		}

				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);







		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);


			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);


			policysearchpage.Authorized();

			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
				
			}
			catch(Exception PolicyDetailsWidget)
			{
				PolicyDetailsWidget.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidget.getMessage());
				System.out.println("Policy Details Widget is not showing upon clicking on the Authorized button ");
				log.error("Exception occured",new Exception("Policy Details Widget is not showing upon clicking on the Authorized button"));
				throw PolicyDetailsWidget;
			}


			waitForElementToAppear(polDtailsAppear);
			moveToElement(polDetClick);

			try {
				click(polDetClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
				System.out.println("Policy details clicked");
			}
			catch(Exception PolicyDetailsTabClick)
			{
				PolicyDetailsTabClick.printStackTrace();
				System.out.println("Message is" + PolicyDetailsTabClick.getMessage());
				System.out.println("Policy Details tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Policy Details tab is not clicked while trying to click after Authorized the call"));
				throw PolicyDetailsTabClick;
			}
			waitForElementToAppear(StatusCheck);
			moveToElement(PolDetStatus);



			Thread.sleep(2000);

			try {

				softassertdetails.assertEquals(isSelectedElement(PolDetStatus),true,"Details-Policy Status is not clicked");
				String PolDetStatusText= PolDetStatus.getText();
				String PolDetStaValText= PolDetStaVal.getText();


				softassertdetails.assertEquals(isSelectedElement(PolDetGracePeriod),true,"Details-Grace Period is not clicked");
				String PolDetGracePeriodText= PolDetGracePeriod.getText();
				String polDetgraPerValText= polDetgraPerVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolRestCode),true,"Details-Restrict Code is not clicked");
				String PolRestCodeText= PolRestCode.getText();
				String polDetrestCodeValText= polDetrestCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolDetSusCode),true,"Details-Suspende Code is not clicked");
				String PolDetSusCodeText= PolDetSusCode.getText();
				String polDetsusCodeValText= polDetsusCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolDetComCode),true,"Details-Comany Code is not selected");
				String PolDetComCodeText= PolDetComCode.getText();
				String polDetComCodeValText= polDetComCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolNum),true,"Details-Policy Number is not selected");
				String PolNumText= PolNum.getText();
				String polDetPolNumValText= polDetPolNumVal.getText();
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsCheckoxes)
			{
				PolicyDetailsCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsCheckoxes.getMessage());
				System.out.println("Policy Details - Checboxes are not selected in policy details tab");
				log.error("Exception occured",new Exception("Policy Details - Checboxes are not selected in policy details tab"));
				throw PolicyDetailsCheckoxes;
			}



			//******************** Policy Details-Details Request Validation*****************************

			try{
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsRequsted)
			{
				PolicyDetailsRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRequsted.getMessage());
				System.out.println("Policy Details - Not navigated to Requested Details ");
				log.error("Exception occured",new Exception("Policy Details- Not navigated to Requested Details"));
				throw PolicyDetailsRequsted;
			}

			try {
				isShwoingValue(reqDetails);
				isShwoingValue(reqDetPolSta);
				getText(reqDetPolSta);
				getText(PolDetStaVal);
				softassertdetails.assertEquals(getText(reqDetPolSta).contains(getText(PolDetStaVal)),true,"Details-Policy Status is not matched in Requested Details");


				isShwoingValue(reqDetPolGra);
				getText(reqDetPolGra);
				getText(polDetgraPerVal);
				softassertdetails.assertEquals(getText(reqDetPolGra).contains(getText(polDetgraPerVal)),true,"Details-Grace Period is not matched in Requested Details");

				isShwoingValue(reqDetPolResCode);
				getText(reqDetPolResCode);
				getText(polDetrestCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolResCode).contains(getText(polDetrestCodeVal)),true,"Details-Restrict Code Value is not matched in Requested Details");

				isShwoingValue(reqDetPolSusCode);
				getText(reqDetPolSusCode);
				getText(polDetsusCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolSusCode).contains(getText(polDetsusCodeVal)),true,"Details-Suspend Code is not not matched in Requested Details");

				isShwoingValue(reqDetPolComCode);
				getText(reqDetPolComCode);
				getText(polDetComCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolComCode).contains(getText(polDetComCodeVal)),true,"Details-Company Code is not matched in Requested Details");

				isShwoingValue(reqDetPolNum);
				getText(reqDetPolNum);
				getText(polDetPolNumVal);
				softassertdetails.assertEquals(getText(reqDetPolNum).contains(getText(polDetPolNumVal)),true,"Details-Policy Number is not matched in Requested Details");

			}
			catch(Exception PolicyDetailsRequestedDetailsInfo)
			{
				PolicyDetailsRequestedDetailsInfo.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRequestedDetailsInfo.getMessage());
				System.out.println("Policy Details-Selected checkboxes and corresponding data is not matching with requested details ");
				log.error("Exception occured",new Exception("Policy Details-Selected checkboxes and corresponding data is not matching with requested details"));
				throw PolicyDetailsRequestedDetailsInfo;
			}

			//********************************** Call Disposition*******************************
			try
			{
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
			}
			catch(Exception CloseCallDetails)
			{
				CloseCallDetails.printStackTrace();
				System.out.println("Message is" + CloseCallDetails.getMessage());
				System.out.println("Policy Details-Save and Close Call is disabled due to non mandatory details ");
				log.error("Exception occured",new Exception("Policy Details-Save and Close Call is disabled due to non mandatory details"));
				throw CloseCallDetails;
			}

		}

		//Prod regions-Details tab
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);


			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);			
			policysearchpage.SearchButton();
			policysearchpage.searchPolNum(Policy);


			pageScrollUp();
			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsWidget)
			{
				PolicyDetailsWidget.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidget.getMessage());
				System.out.println("Policy Details-PolicyDetailsWidget is not showing upon successful policy search in Prod");
				log.error("Exception occured",new Exception("PolicyDetailsWidget is not showing upon successful policy search in Prod"));
				throw PolicyDetailsWidget;
			}
			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsWidgetClick)
			{
				PolicyDetailsWidgetClick.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidgetClick.getMessage());
				System.out.println("Policy Details-Policy Details Widget is not expanded in Prod upon clicking on the PolicyDetailsWidget in Prod");
				log.error("Exception occured",new Exception("Policy Details-Policy Details Widget is not expanded in Prod upon clicking on the PolicyDetailsWidget in Prod"));
				throw PolicyDetailsWidgetClick;
			}


			try {
				waitForElementToAppear(polDtailsAppear);
				moveToElement(polDetClick);
				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsTab)
			{
				PolicyDetailsTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsTab.getMessage());
				System.out.println("Policy Details-Policy Details tab is not showing in Prod upon clicking on the PolicyDetailsWidget ");
				log.error("Exception occured",new Exception("Policy Details-Policy Details tab is not showing in Prod upon clicking on the PolicyDetailsWidget"));
				throw PolicyDetailsTab;
			}

			try {
				click(polDetClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsTabClick)
			{
				PolicyDetailsTabClick.printStackTrace();
				System.out.println("Message is" + PolicyDetailsTabClick.getMessage());
				System.out.println("Policy Details-Policy Details tab is not clicked in Prod upon clicking on the PolicyDetails ");
				log.error("Exception occured",new Exception("Policy Details-Policy Details tab is not clicked in Prod upon clicking on the PolicyDetails "));
				throw PolicyDetailsTabClick;
			}



			waitForElementToAppear(StatusCheck);

			moveToElement(PolDetStatus);
			try {
				softassertdetails.assertEquals(isSelectedElement(PolDetStatus),true,"Details-Policy Status is not clicked");
				String PolDetStatusText= PolDetStatus.getText();
				String PolDetStaValText= PolDetStaVal.getText();


				softassertdetails.assertEquals(isSelectedElement(PolDetGracePeriod),true,"Details-Grace Period is not clicked");
				String PolDetGracePeriodText= PolDetGracePeriod.getText();
				String polDetgraPerValText= polDetgraPerVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolRestCode),true,"Details-Restrict Code is not clicked");
				String PolRestCodeText= PolRestCode.getText();
				String polDetrestCodeValText= polDetrestCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolDetSusCode),true,"Details-Suspende Code is not clicked");
				String PolDetSusCodeText= PolDetSusCode.getText();
				String polDetsusCodeValText= polDetsusCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolDetComCode),true,"Details-Comany Code is not selected");
				String PolDetComCodeText= PolDetComCode.getText();
				String polDetComCodeValText= polDetComCodeVal.getText();

				softassertdetails.assertEquals(isSelectedElement(PolNum),true,"Details-Policy Number is not selected");
				String PolNumText= PolNum.getText();
				String polDetPolNumValText= polDetPolNumVal.getText();
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsCheckoxesProd)
			{
				PolicyDetailsCheckoxesProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsCheckoxesProd.getMessage());
				System.out.println("Policy Details - Checboxes are not selected in policy details tab in Prod");
				log.error("Exception occured",new Exception("Policy Details - Checboxes are not selected in policy details tab in Prod"));
				throw PolicyDetailsCheckoxesProd;
			}


			//******************** Policy Details-Details Request Validation*****************************

			try{
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsRequsted)
			{
				PolicyDetailsRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRequsted.getMessage());
				System.out.println("Policy Details- Not navigated to Requested Details in Prod ");
				log.error("Exception occured",new Exception("Policy Details- Not navigated to Requested Details in Prod"));
				throw PolicyDetailsRequsted;
			}
			try {
				isShwoingValue(reqDetails);
				isShwoingValue(reqDetPolSta);
				getText(reqDetPolSta);
				getText(PolDetStaVal);
				softassertdetails.assertEquals(getText(reqDetPolSta).contains(getText(PolDetStaVal)),true,"Details-Policy Status is not matched in Requested Details");


				isShwoingValue(reqDetPolGra);
				getText(reqDetPolGra);
				getText(polDetgraPerVal);
				softassertdetails.assertEquals(getText(reqDetPolGra).contains(getText(polDetgraPerVal)),true,"Details-Grace Period is not matched in Requested Details");

				isShwoingValue(reqDetPolResCode);
				getText(reqDetPolResCode);
				getText(polDetrestCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolResCode).contains(getText(polDetrestCodeVal)),true,"Details-Restrict Code Value is not matched in Requested Details");

				isShwoingValue(reqDetPolSusCode);
				getText(reqDetPolSusCode);
				getText(polDetsusCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolSusCode).contains(getText(polDetsusCodeVal)),true,"Details-Suspend Code is not not matched in Requested Details");

				isShwoingValue(reqDetPolComCode);
				getText(reqDetPolComCode);
				getText(polDetComCodeVal);
				softassertdetails.assertEquals(getText(reqDetPolComCode).contains(getText(polDetComCodeVal)),true,"Details-Company Code is not matched in Requested Details");

				isShwoingValue(reqDetPolNum);
				getText(reqDetPolNum);
				getText(polDetPolNumVal);
				softassertdetails.assertEquals(getText(reqDetPolNum).contains(getText(polDetPolNumVal)),true,"Details-Policy Number is not matched in Requested Details");

			}
			catch(Exception PolicyDetailsRequestedDetailsInfoProd)
			{
				PolicyDetailsRequestedDetailsInfoProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRequestedDetailsInfoProd.getMessage());
				System.out.println("Policy Details-Selected checkboxes and corresponding data is not matching with requested details in prod");
				log.error("Exception occured",new Exception("Policy Details-Selected checkboxes and corresponding data is not matching with requested details in prod"));
				throw PolicyDetailsRequestedDetailsInfoProd;
			}

			//********************************** Call Disposition*******************************
			try
			{
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
			}
			catch(Exception CloseCallDetails)
			{
				CloseCallDetails.printStackTrace();
				System.out.println("Message is" + CloseCallDetails.getMessage());
				System.out.println("Policy Details-Save and Close Call is disabled due to non mandatory details in prod");
				log.error("Exception occured",new Exception("Policy Details-Save and Close Call is disabled due to non mandatory details in Prod"));
				throw CloseCallDetails;
			}

		}






		softassertdetails.assertAll();

	}













	//********************************************Policy-Billing Details***********************************************************


	By BillingTabClick=By.xpath("//span[text()='Billing']");
	By BillingPaidToDate=By.id("billing-info-paid-to-date-action-checkbox_label");
	@FindBy(xpath="//span[text()='BILLING']//following::dd[1]")
	WebElement reqDetBillPtd;
	@FindBy(xpath="//span[text()='BILLING']//following::dd[2]")
	WebElement reqDetBillMethod;
	@FindBy(xpath="//span[text()='BILLING']//following::dd[3]")
	WebElement reqDetBillFrq;
	@FindBy(xpath="//label[@id='billing-info-paid-to-date-label']") WebElement billPtdVal;
	@FindBy(xpath="//label[@id='billing-info-bill-option-desc-label']") WebElement billMethodVal;
	@FindBy(xpath="//label[@id='billing-info-billing-frequency-desc-label']") WebElement billFreqVal;
	@FindBy(id="close-call-requested-details-label_label") WebElement reqDetails;


	public void policyBillingValidation(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{

		SoftAssert softassertbilling=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());


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


				softassertbilling.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);
		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))

		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);



			policysearchpage.Authorized();
			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorizeBilling)
			{
				ScrollupAfterAuthorizeBilling.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorizeBilling.getMessage());
				System.out.println("Billing Tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Billing Tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorizeBilling;
			}


			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsWidgetBilling)
			{
				PolicyDetailsWidgetBilling.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidgetBilling.getMessage());
				System.out.println("Billing-Policy Details Widget is not showing upon clicking on the Authorized button ");
				log.error("Exception occured",new Exception("Billing-Policy Details Widget is not showing upon clicking on the Authorized button"));
				throw PolicyDetailsWidgetBilling;
			}


			waitForElementToAppear(BillingTabClick);

			moveToElement(Billing);
			try {
				click(Billing);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyBillingTab)
			{
				PolicyBillingTab.printStackTrace();
				System.out.println("Message is" + PolicyBillingTab.getMessage());
				System.out.println("Policy Billing tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Policy Billing tab is not clicked while trying to click after Authorized the call"));
				throw PolicyBillingTab;
			}


			waitForElementToAppear(BillingPaidToDate);
			moveToElement(BillPtd);

			Thread.sleep(1000);
			try {

				softassertbilling.assertEquals(isSelectedElement(BillPtd),true,"Policy Details-Billing tab-Paid To Date is not clicked");
				String BillPtdText=BillPtd.getText();
				String billPtdValText=billPtdVal.getText();

				softassertbilling.assertEquals(isSelectedElement(BillMethod),true,"Policy Details-Billing tab-Billing-Bill Method is not clicked");
				String BillMethodText=BillMethod.getText();
				String billMethodValText=billMethodVal.getText();

				softassertbilling.assertEquals(isSelectedElement(BillFrq),true,"Policy Details-Billing tab-Billing-Bill Freq is not clicked");
				String BillFrqText=BillFrq.getText();
				String billFreqValText=billFreqVal.getText();
				Thread.sleep(1000);
				

			}
			catch(Exception PolicyDetailsBillingCheckoxes)
			{
				PolicyDetailsBillingCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsBillingCheckoxes.getMessage());
				System.out.println("Policy Billing Tab - Checboxes are not selected in policy Billing tab");
				log.error("Exception occured",new Exception("Policy Billing Tab - Checboxes are not selected in policy Billing tab"));
				throw PolicyDetailsBillingCheckoxes;
			}

			try {

				//*******************Requested Billing Tab***************
				moveToElement(reqDetails);
				Thread.sleep(1000);
			}

			catch(Exception PolicyBillingDetailsRequsted)
			{
				PolicyBillingDetailsRequsted.printStackTrace();
				System.out.println("Message is" + PolicyBillingDetailsRequsted.getMessage());
				System.out.println("Policy Billing Details- Not navigated to Requested Details ");
				log.error("Exception occured",new Exception("Policy Billing Details- Not navigated to Requested Details"));
				throw PolicyBillingDetailsRequsted;
			}
			try {

				isShwoingValue(reqDetails);
				isShwoingValue(reqDetBillPtd);
				getText(reqDetBillPtd);
				getText(billPtdVal);
				softassertbilling.assertEquals(getText(reqDetBillPtd).contains(getText(billPtdVal)),true,"Policy Details-Billing-Paid to Date not matched in Req details");

				isShwoingValue(reqDetBillMethod);
				getText(reqDetBillMethod);
				getText(billMethodVal);
				softassertbilling.assertEquals(getText(reqDetBillMethod).contains(getText(billMethodVal)),true,"Policy Details-Billing-Billing Method not matched in Req Details");

				isShwoingValue(reqDetBillFrq);
				getText(reqDetBillFrq);
				getText(billFreqVal);
				softassertbilling.assertEquals(getText(reqDetBillFrq).contains(getText(billFreqVal)),true,"Policy Details-Billing-Billing Frequency not matched in Req Details");

			}
			catch(Exception PolicyBillingRequestedDetailsInfo)
			{
				PolicyBillingRequestedDetailsInfo.printStackTrace();
				System.out.println("Message is" + PolicyBillingRequestedDetailsInfo.getMessage());
				System.out.println("Policy Billing tab-Selected checkboxes and corresponding data is not matching with requested details ");
				log.error("Exception occured",new Exception("Policy Billing tab-Selected checkboxes and corresponding data is not matching with requested details "));
				throw PolicyBillingRequestedDetailsInfo;
			}


			try{
				//********************************** Billing Call Disposition*******************************
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");

				waitForElementTodisAppear(SpinnerTest);
			}

			catch(Exception BillingCloseCallDetails)
			{
				BillingCloseCallDetails.printStackTrace();
				System.out.println("Message is" + BillingCloseCallDetails.getMessage());
				System.out.println("Billing tab-Save and Close Call is disabled due to non mandatory details ");
				log.error("Exception occured",new Exception("Billing tab-Save and Close Call is disabled due to non mandatory details"));
				throw BillingCloseCallDetails;

			}

			Thread.sleep(1000);
		}
		//Billing-Prod
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);





			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsWidgetBilling)
			{
				PolicyDetailsWidgetBilling.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidgetBilling.getMessage());
				System.out.println("Billing tab-PolicyDetailsWidget is not showing upon successful policy search in Prod");
				log.error("Exception occured",new Exception("Billing tab-PolicyDetailsWidget is not showing upon successful policy search in Prod"));
				throw PolicyDetailsWidgetBilling;
			}

			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);

			}
			catch(Exception BillingPolicyDetailsWidgetClick)
			{
				BillingPolicyDetailsWidgetClick.printStackTrace();
				System.out.println("Message is" + BillingPolicyDetailsWidgetClick.getMessage());
				System.out.println("Billing-Policy Details Widget is not expanded in Prod upon clicking on the PolicyDetailsWidget ");
				log.error("Exception occured",new Exception("Billing-Policy Details Widget is not expanded in Prod upon clicking on the PolicyDetailsWidget"));
				throw BillingPolicyDetailsWidgetClick;
			}



			waitForElementToAppear(BillingTabClick);
			moveToElement(Billing);
			try {
				click(Billing);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsWidgetBillingClick)
			{
				PolicyDetailsWidgetBillingClick.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidgetBillingClick.getMessage());
				System.out.println("Billing tab-Policy Details Billing is not working in Prod upon clicking on the PolicyDetailsWidget ");
				log.error("Exception occured",new Exception("Billing tab-Policy Details Billing is not working in Prod upon clicking on the PolicyDetailsWidget"));
				throw PolicyDetailsWidgetBillingClick;
			}


			waitForElementToAppear(BillingPaidToDate);
			moveToElement(BillPtd);

			Thread.sleep(1000);
			try {
				softassertbilling.assertEquals(isSelectedElement(BillPtd),true,"Policy Details-Billing tab-Paid To Date is not clicked");
				String BillPtdText=BillPtd.getText();
				String billPtdValText=billPtdVal.getText();

				softassertbilling.assertEquals(isSelectedElement(BillMethod),true,"Policy Details-Billing tab-Billing-Bill Method is not clicked");
				String BillMethodText=BillMethod.getText();
				String billMethodValText=billMethodVal.getText();

				softassertbilling.assertEquals(isSelectedElement(BillFrq),true,"Policy Details-Billing tab-Billing-Bill Freq is not clicked");
				String BillFrqText=BillFrq.getText();
				String billFreqValText=billFreqVal.getText();
				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsBillingCheckoxes)
			{
				PolicyDetailsBillingCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsBillingCheckoxes.getMessage());
				System.out.println("Policy Billin tab - Checboxes are not selected in policy Billing tab in prod");
				log.error("Exception occured",new Exception("Policy Billin tab - Checboxes are not selected in policy Billing tab in prod"));
				throw PolicyDetailsBillingCheckoxes;
			}


			try {

				//*******************Requested Billing Tab***************
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsBillingRequsted)
			{
				PolicyDetailsBillingRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsBillingRequsted.getMessage());
				System.out.println("Billing tab-Policy Details Billing- Not navigated to Requested Details in Prod ");
				log.error("Exception occured",new Exception("Billing tab-- Not navigated to Requested Details in Prod"));
				throw PolicyDetailsBillingRequsted;
			}
			try {

				isShwoingValue(reqDetails);
				isShwoingValue(reqDetBillPtd);
				getText(reqDetBillPtd);
				getText(billPtdVal);
				softassertbilling.assertEquals(getText(reqDetBillPtd).contains(getText(billPtdVal)),true,"Policy Details-Billing-Paid to Date not matched in Req details");

				isShwoingValue(reqDetBillMethod);
				getText(reqDetBillMethod);
				getText(billMethodVal);
				softassertbilling.assertEquals(getText(reqDetBillMethod).contains(getText(billMethodVal)),true,"Policy Details-Billing-Billing Method not matched in Req Details");

				isShwoingValue(reqDetBillFrq);
				getText(reqDetBillFrq);
				getText(billFreqVal);
				softassertbilling.assertEquals(getText(reqDetBillFrq).contains(getText(billFreqVal)),true,"Policy Details-Billing-Billing Frequency not matched in Req Details");
			}
			catch(Exception PolicyBillingDetailsRequstedInfo)
			{
				PolicyBillingDetailsRequstedInfo.printStackTrace();
				System.out.println("Message is" + PolicyBillingDetailsRequstedInfo.getMessage());
				System.out.println("Policy Billing Details-Selected checkboxes and corresponding data is not matching with requested details in prod");
				log.error("Exception occured",new Exception("Policy Billing Details-Selected checkboxes and corresponding data is not matching with requested details in prod"));
				throw PolicyBillingDetailsRequstedInfo;
			}



			try{
				//********************************** Billing Call Disposition*******************************
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
			}
			catch(Exception BillingCloseCallDetails)
			{
				BillingCloseCallDetails.printStackTrace();
				System.out.println("Message is" + BillingCloseCallDetails.getMessage());
				System.out.println("Billing tab-Save and Close Call is disabled due to non mandatory details in prod");
				log.error("Exception occured",new Exception("Billing tab-Save and Close Call is disabled due to non mandatory details in prod"));
				throw BillingCloseCallDetails;

			}





		}



		softassertbilling.assertAll();


	}

	//********************Billing code completed************************************


	//**********************************Values Tab************************************

	By ValuesTabClickk=By.xpath("//span[text()='Values']");

	@FindBy(xpath="//input[@id='policy-values-quote-effective-date-date_input']") WebElement valEffDate;
	By AARTDate=By.xpath("//input[@id='policy-values-quote-effective-date-date_input']");
	By valuesMsgAppear=By.id("policy-values-messeage-action-checkbox_label");
	@FindBy(xpath="//span[text()='POLICY VALUES']//following::dd[1]") WebElement reqDetEffDateVal;
	@FindBy(xpath="//span[text()='POLICY VALUES']//following::dd[2]")
	WebElement reqDetValMsg;
	@FindBy(xpath="//span[text()='POLICY VALUES']//following::dd[3]")
	WebElement reqDetValFaceAmt;
	@FindBy(xpath="//span[text()='POLICY VALUES']//following::dd[4]")
	WebElement reqDetAccCash;
	@FindBy(xpath="//label[@id='policy-values-face-amount-label']") WebElement valFaceAmtVal;
	@FindBy(xpath="//label[@id='policy-values-accumulated-cash-value-label']") WebElement valAccCashVal;


	public void policyWholeLifeValuesTabValidation(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{

		SoftAssert softassertvalues=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());

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

				softassertvalues.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);

			policysearchpage.Authorized();

			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Values tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Values tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}



			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
			}
			catch(Exception ValuesPolicyDetailsWidget)
			{
				ValuesPolicyDetailsWidget.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsWidget.getMessage());
				System.out.println("Values-Policy Details Widget is not showing upon clicking on the Authorized button ");
				log.error("Exception occured",new Exception("Values-Policy Details Widget is not showing upon clicking on the Authorized button"));
				throw ValuesPolicyDetailsWidget;
			}


			waitForElementToAppear(ValuesTabClickk);
			moveToElement(ValuesTabClick);
			try {
				click(ValuesTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception ValuesPolicyDetailsTab)
			{
				ValuesPolicyDetailsTab.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsTab.getMessage());
				System.out.println("Values tab-Policy Details Values tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Values tab-Policy Details Values tab is not clicked while trying to click after Authorized the call "));
				throw ValuesPolicyDetailsTab;
			}



			waitForElementToAppear(AARTDate);
			waitForElementToAppear(valuesMsgAppear);
			moveToElement(ValuesTabMessageCheckbox);
			Thread.sleep(1000);
			try {
				softassertvalues.assertEquals(isDisplayedElement(valEffDate),true,"Policy Details-Values tab Effective Date is not showing in Values Tab");
				softassertvalues.assertEquals(isSelectedElement(ValuesTabMessageCheckbox),true,"Policy Details-Values-MsgCheckBox is not clicked");

				softassertvalues.assertEquals(isSelectedElement(ValuesTabFaceAmtCheckbox),true,"Policy Details-Values-Face Amount is not clicked");
				String ValuesTabFaceAmtCheckboxText=ValuesTabFaceAmtCheckbox.getText();
				String valFaceAmtValText=valFaceAmtVal.getText();

				Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsValuesCheckoxes)
			{
				PolicyDetailsValuesCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsValuesCheckoxes.getMessage());
				System.out.println("Policy Details Values - Checboxes are not selected in policy details Values tab");
				log.error("Exception occured",new Exception("Policy Details Values - Checboxes are not selected in policy details Values tab"));
				throw PolicyDetailsValuesCheckoxes;
			}
			//************************ Values Tab Requested Details*****************************************
			try {
				moveToElement(reqDetails);
			}
			catch(Exception ValuesPolicyDetailsRequsted)
			{
				ValuesPolicyDetailsRequsted.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsRequsted.getMessage());
				System.out.println("Values-Policy Details- Not navigated to Requested Details ");
				log.error("Exception occured",new Exception("Values-Policy Details- Not navigated to Requested Details"));
				throw ValuesPolicyDetailsRequsted;
			}
			try {
				isShwoingValue(reqDetails);
				isShwoingValue(reqDetEffDateVal);
				getText(reqDetEffDateVal);
				getText(valEffDate);
				softassertvalues.assertEquals(getText(reqDetEffDateVal).contains(getText(valEffDate)),true,"Values-Effective Date not matched with Values Tab in Requested Details");



				isShwoingValue(reqDetValMsg);

				isShwoingValue(reqDetValFaceAmt);
				getText(reqDetValFaceAmt);
				getText(valFaceAmtVal);
				softassertvalues.assertEquals(getText(reqDetValFaceAmt).contains(getText(valFaceAmtVal)),true,"Values-Face Amount not matched with Values Tab in Requested Details");

				Thread.sleep(2000);

			}
			catch(Exception PolicyValuesTabRequestedDetailsInfo)
			{
				PolicyValuesTabRequestedDetailsInfo.printStackTrace();
				System.out.println("Message is" + PolicyValuesTabRequestedDetailsInfo.getMessage());
				System.out.println("Policy Values tab-Selected checkboxes and corresponding data is not matching with requested details ");
				log.error("Exception occured",new Exception("Policy Values tab-Selected checkboxes and corresponding data is not matching with requested details"));
				throw PolicyValuesTabRequestedDetailsInfo;
			}





			//**************************Values call disPosition*********************

			try {
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception ValuesCloseCallDetails)
			{
				ValuesCloseCallDetails.printStackTrace();
				System.out.println("Message is" + ValuesCloseCallDetails.getMessage());
				System.out.println("Values tab-Save and Close Call is disabled due to non mandatory details ");
				log.error("Exception occured",new Exception("Values tab-Save and Close Call is disabled due to non mandatory details"));
				throw ValuesCloseCallDetails;


			}
		}
		//values tab-Prod
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);





			pageScrollUp();
			try {
				waitForElementToAppear(PolicyDetailsWidgt);
				Thread.sleep(1000);
			}
			catch(Exception ValuesPolicyDetailsWidget)
			{
				ValuesPolicyDetailsWidget.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsWidget.getMessage());
				System.out.println("Values-PolicyDetailsWidget is not showing upon successful policy search in Prod");
				log.error("Exception occured",new Exception("Values-PolicyDetailsWidget is not showing upon successful policy search in Prod"));
				throw ValuesPolicyDetailsWidget;
			}

			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception ValuesPolicyDetailsWidgetClick)
			{
				ValuesPolicyDetailsWidgetClick.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsWidgetClick.getMessage());
				System.out.println("Values tab-Policy Details Widget is not working in Prod upon clicking on the PolicyDetailsWidget ");
				log.error("Exception occured",new Exception("Values tab-Policy Details Widget is not working in Prod upon clicking on the PolicyDetailsWidget"));
				throw ValuesPolicyDetailsWidgetClick;
			}


			waitForElementToAppear(ValuesTabClickk);
			moveToElement(ValuesTabClick);
			try {
				click(ValuesTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);

			}
			catch(Exception ValuesPolicyDetailsTabClick)
			{
				ValuesPolicyDetailsTabClick.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsTabClick.getMessage());
				System.out.println("Values tab-Policy Details Values  is not clicked in Prod upon clicking on the PolicyDetails in Prod");
				log.error("Exception occured",new Exception("Values tab-Policy Details Values  is not clicked in Prod upon clicking on the PolicyDetails in Prod "));
				throw ValuesPolicyDetailsTabClick;
			}




			waitForElementToAppear(AARTDate);
			waitForElementToAppear(valuesMsgAppear);
			moveToElement(ValuesTabMessageCheckbox);
			Thread.sleep(1000);
			try {
			softassertvalues.assertEquals(isDisplayedElement(valEffDate),true,"Policy Details-Values tab Effective Date is not showing in Values Tab");
			softassertvalues.assertEquals(isSelectedElement(ValuesTabMessageCheckbox),true,"Policy Details-Values-MsgCheckBox is not clicked");

			softassertvalues.assertEquals(isSelectedElement(ValuesTabFaceAmtCheckbox),true,"Policy Details-Values-Face Amount is not clicked");
			String ValuesTabFaceAmtCheckboxText=ValuesTabFaceAmtCheckbox.getText();
			String valFaceAmtValText=valFaceAmtVal.getText();

			Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsValuesCheckoxes)
			{
				PolicyDetailsValuesCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsValuesCheckoxes.getMessage());
				System.out.println("Policy Details Values- Checboxes are not selected in policy details Values tab in prod");
				log.error("Exception occured",new Exception("Policy Details Values- Checboxes are not selected in policy details Values tab in prod"));
				throw PolicyDetailsValuesCheckoxes;
			}

			//************************ Values Tab Requested Details*****************************************
			try {
				moveToElement(reqDetails);
			}
			catch(Exception ValuesPolicyDetailsRequsted)
			{
				ValuesPolicyDetailsRequsted.printStackTrace();
				System.out.println("Message is" + ValuesPolicyDetailsRequsted.getMessage());
				System.out.println("Values tab-Policy Details- Not navigated to Requested Details in Prod ");
				log.error("Exception occured",new Exception("Values tab-Policy Details- Not navigated to Requested Details in Prod"));
				throw ValuesPolicyDetailsRequsted;
			}
			try {

			isShwoingValue(reqDetails);
			isShwoingValue(reqDetEffDateVal);
			getText(reqDetEffDateVal);
			getText(valEffDate);
			softassertvalues.assertEquals(getText(reqDetEffDateVal).contains(getText(valEffDate)),true,"Values-Effective Date not matched with Values Tab in Requested Details");



			isShwoingValue(reqDetValMsg);

			isShwoingValue(reqDetValFaceAmt);
			getText(reqDetValFaceAmt);
			getText(valFaceAmtVal);
			softassertvalues.assertEquals(getText(reqDetValFaceAmt).contains(getText(valFaceAmtVal)),true,"Values-Face Amount not matched with Values Tab in Requested Details");

			Thread.sleep(2000);

			}
			catch(Exception PolicyDetailsValuesRequestedDetailsInfo)
            {
				PolicyDetailsValuesRequestedDetailsInfo.printStackTrace();
				System.out.println("Message is" + PolicyDetailsValuesRequestedDetailsInfo.getMessage());
				System.out.println("Policy Details Values tab-Selected checkboxes and corresponding data is not matching with requested details in prod ");
				log.error("Exception occured",new Exception("Policy Details Values tab-Selected checkboxes and corresponding data is not matching with requested details in prod"));
				throw PolicyDetailsValuesRequestedDetailsInfo;
            }





			//**************************Values call disPosition*********************

			try {
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception ValuesCloseCallDetails)
			{
				ValuesCloseCallDetails.printStackTrace();
				System.out.println("Message is" + ValuesCloseCallDetails.getMessage());
				System.out.println("Values tab-Save and Close Call is disabled due to non mandatory details in prod");
				log.error("Exception occured",new Exception("Values tab-Save and Close Call is disabled due to non mandatory details in Prod"));
				throw ValuesCloseCallDetails;
			}

		}





		softassertvalues.assertAll();



	}




	//*************************Policy Values completed***************************************

	By WholeLifeLoansTabClickTest=By.xpath("//span[text()='Loan']");
	By WholeLifeLoansMessageAppear=By.id("loan-transaction-history-messeage-checkbox_label");
	@FindBy(xpath="//div[@class='ui-growl-message']") WebElement ActualMessage;
	@FindBy(xpath="//span[normalize-space()='MAIL QUOTE']") WebElement mailQuoteLoan;
	By mailQuoteLoanAppear =By.xpath("//span[normalize-space()='MAIL QUOTE']");
	@FindBy(id="selected-roles-reason-select") WebElement cli;

	@FindBy(xpath="//div[text()='Loan Inq']") WebElement CallDispositionLaonInqSelection;

	@FindBy(xpath="//div[text()='Billing Inq']") WebElement CallDispositionBillInqSel;
	@FindBy(xpath="//div[text()='Coverage Inq']") WebElement CallDispositionCvgInqSel;

	//@FindBy(id="save-close-close-call-button") WebElement CloseCall;
	@FindBy(id="call-history-policy-camelcase") WebElement MyCallHistPolValidation;
	@FindBy(id="call-history-reason") WebElement MyCallHistReason;
	@FindBy(id="call-history-date-time") WebElement MyCallHistDate;
	//@FindBy(id="call-history-policy-camelcase") WebElement MyCallHistPolValidation;
	@FindBy(id="contracts-collection-search-text") WebElement SearchClosedPol;

	//By SpinnerTest=By.xpath("lds-spinner");
	@FindBy(xpath="//mat-panel-title[text()=' Call History ']") WebElement callHistory;
	@FindBy(id="selected-roles-full-name-label") WebElement ownerName;
	@FindBy(id="policy-call-history-caller-name") WebElement callerName;
	@FindBy(xpath="//mat-panel-title[text()=' Call History ']//following::tr[2]") WebElement callHisCli;
	@FindBy(id="selected-call-history-caller-name-label") WebElement callDetCallerName;
	@FindBy(id="selected-call-history-caller-role-label") WebElement callDetRole;
	@FindBy(id="selected-call-history-reason-label") WebElement callDetReason;
	@FindBy(id="selected-call-history-csr-name-label") WebElement callDetCsrName;
	@FindBy(xpath="//label[text()='Transactions']//following::label[1]") WebElement callDetTrx;
	@FindBy(xpath="//label[text()='Phone Number']//following::label[1]") WebElement callDetphnNum;
	@FindBy(xpath="//label[@class='oc-label-1 call-note callHisLabel callHisLabelBold']//following::label[1]") WebElement callDetCallNote;
	@FindBy(xpath="//span[text()=' Status : ']") WebElement callDetSta;
	@FindBy(xpath="//span[text()=' Paid To Date : ']") WebElement callDetPtd;
	@FindBy(xpath="//span[text()=' Grace Period Ending : ']") WebElement callDetGraPer;
	@FindBy(xpath="//span[text()='Loan']//following::span[contains(text(),'not applicable')]") WebElement loanCheck;
	@FindBy(xpath="//span[text()='Loan']//following::span[contains(text(),'not applicable')]") WebElement loanMsgVal;



	By callHistoryWidget=By.xpath("//mat-panel-title[text()=' Call History ']");
	By loanMsg=By.xpath("//span[text()='Loan']//following::span[contains(text(),'not applicable')]");

	@FindBy(xpath="//span[text()='LOAN']//following::span[contains(text(),'not applicable')][1]") WebElement loansCheckBox;

	//*********************************Loans Tab************************************
	public void wholeLifeLoansTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{

		SoftAssert softassertloans=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());


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

				softassertloans.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);


		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);


			policysearchpage.Authorized();

			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Policy Loans tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Policy Loans tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
			waitForElementToAppear(PolicyDetailsWidgt);

			waitForElementToAppear(WholeLifeLoansTabClickTest);
			moveToElement(WholeLifeLoansTabClick);
			try {
				click(WholeLifeLoansTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception LoansPolicyDetailsTab)
			{
				LoansPolicyDetailsTab.printStackTrace();
				System.out.println("Message is" + LoansPolicyDetailsTab.getMessage());
				System.out.println("Policy Loans tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Policy Loans tab is not clicked while trying to click after Authorized the call "));
				throw LoansPolicyDetailsTab;
			}


			waitForElementToAppear(loanMsg);
			Thread.sleep(1000);
			String LoanText=loanCheck.getText();
			try {
			softassertloans.assertEquals(isSelectedElement(loanCheck),true,"Policy Details-Loans-Policy Loans is not clicked");
			Thread.sleep(1000);
			}
			catch(Exception PolicyDetailsLoansCheckoxes)
			{
				PolicyDetailsLoansCheckoxes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansCheckoxes.getMessage());
				System.out.println("Policy Details Loans - Checboxes are not selected in policy details tab");
				log.error("Exception occured",new Exception("Policy Details Loans - Checboxes are not selected in policy details tab"));
				throw PolicyDetailsLoansCheckoxes;
				
			}









			//************************ LOANS Tab Requested Details*****************************************
			try {
				moveToElement(reqDetails);
			}
			catch(Exception LoansPolicyDetailsRequsted)
			{
				LoansPolicyDetailsRequsted.printStackTrace();
				System.out.println("Message is" + LoansPolicyDetailsRequsted.getMessage());
				System.out.println("Policy Details Loans- Not navigated to Requested Details ");
				log.error("Exception occured",new Exception("Policy Details Loans- Not navigated to Requested Details"));
				throw LoansPolicyDetailsRequsted;
			}
			try
			{
			isShwoingValue(reqDetails);
			isShwoingValue(loansCheckBox);
			getText(loansCheckBox);
			getText(loanCheck);
			softassertloans.assertEquals(getText(loansCheckBox).contains(getText(loanCheck)),true,"Loans-Check box is not displayed in req details");
			Thread.sleep(1000);

		}
		catch(Exception PolicyDetailsLoansRequestedDetailsInfo)
        {
			PolicyDetailsLoansRequestedDetailsInfo.printStackTrace();
			System.out.println("Message is" + PolicyDetailsLoansRequestedDetailsInfo.getMessage());
			System.out.println("Policy Details Loans tab-Selected checkboxes and corresponding data is not matching with requested details ");
			log.error("Exception occured",new Exception("Policy Details Loans tab-Selected checkboxes and corresponding data is not matching with requested details"));
			throw PolicyDetailsLoansRequestedDetailsInfo;
        }
		}

		//Prod-Loan tab	
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);




			pageScrollUp();
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
			waitForElementToAppear(PolicyDetailsWidgt);
			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsLoansTab)
			{
				PolicyDetailsLoansTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansTab.getMessage());
				System.out.println("Policy Details loans tab is not clicked while trying to click in prod ");
				log.error("Exception occured",new Exception("Policy Details loans tab is not clicked while trying to click in prod "));
				throw PolicyDetailsLoansTab;
			}


			waitForElementToAppear(WholeLifeLoansTabClickTest);
			moveToElement(WholeLifeLoansTabClick);
			try {
				click(WholeLifeLoansTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsLoansTabClick)
			{
				PolicyDetailsLoansTabClick.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansTabClick.getMessage());
				System.out.println("Policy Details loans tab is not clicked in Prod upon clicking on the PolicyDetails ");
				log.error("Exception occured",new Exception("Policy Details loans tab is not clicked in Prod upon clicking on the PolicyDetails "));
				throw PolicyDetailsLoansTabClick;
			}



			waitForElementToAppear(loanMsg);
			String LoanText=loanCheck.getText();
			try {
			softassertloans.assertEquals(isSelectedElement(loanCheck),true,"Policy Details-Loans-Policy Loans is not clicked");
			Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsLoansCheckoxesProd)
			{
				PolicyDetailsLoansCheckoxesProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansCheckoxesProd.getMessage());
				System.out.println("Policy Details Loans tab - Checboxes are not selected in policy details Loans tab in prod");
				log.error("Exception occured",new Exception("Policy Details Loans tab - Checboxes are not selected in policy details Loans tab in prod"));
				throw PolicyDetailsLoansCheckoxesProd;
			}









			//************************ LOANS Tab Requested Details*****************************************
			try {
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsLoansRequsted)
			{
				PolicyDetailsLoansRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansRequsted.getMessage());
				System.out.println("Policy Details Loans- Not navigated to Requested Details in Prod ");
				log.error("Exception occured",new Exception("Policy Details Loans- Not navigated to Requested Details in Prod"));
				throw PolicyDetailsLoansRequsted;
			}
			try {

			isShwoingValue(reqDetails);
			isShwoingValue(loansCheckBox);
			getText(loansCheckBox);
			getText(loanCheck);
			softassertloans.assertEquals(getText(loansCheckBox).contains(getText(loanCheck)),true,"Loans-Check box is not displayed in req details");
			}
			catch(Exception PolicyDetailsLoansRequestedDetailsInfoProd)
            {
				PolicyDetailsLoansRequestedDetailsInfoProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsLoansRequestedDetailsInfoProd.getMessage());
				System.out.println("Policy Details Loans-Selected checkboxes and corresponding data is not matching with requested details in prod ");
				log.error("Exception occured",new Exception("Policy Details Loans-Selected checkboxes and corresponding data is not matching with requested details in prod"));
				throw PolicyDetailsLoansRequestedDetailsInfoProd;
            }
		}




		softassertloans.assertAll();

	}
	//********************** lOANS tAB COMPLETED*************************


	@FindBy(xpath="//span[text()='Riders']//following::div[@class='ng-star-inserted']//mat-checkbox") WebElement RidersTab;
	By WholeLifeRidersTabClickTest= By.xpath("//span[text()='Riders']");
	@FindBy(xpath="//span[text()='This Policy does not have any riders. ']") WebElement RidersTextMsg;
	By WholeLifeRiderNameAppear=By.id("selected-coverage-coverage-plan-code-action-checkbox_label");
	@FindBy(xpath="//div[@class='policyCoverage-0 ng-star-inserted']//span[@id='selected-coverage-coverage-name-action-checkbox_label']") WebElement RidersChkBox;
	By RiderCvgType=By.xpath("//div[@class='policyCoverage-0 ng-star-inserted']//span[@id='selected-coverage-coverage-name-action-checkbox_label']");
	@FindBy(xpath="//SPAN[text()='RIDERS']//following::dd[1]") WebElement IFRiderNotAppl;
	@FindBy(xpath="//SPAN[text()='RIDERS']//following::dd[1]") WebElement elseRiderNotAppl;
	@FindBy(xpath="//span[text()='Riders']//following::label[@id='selected-coverage-coverage-name-label'][1]") WebElement RiderCheckBoxVal;
	@FindBy(xpath="//SPAN[text()='RIDERS']//following::dd[contains(text(),'does not have any riders')]") WebElement ReqRiderMsg;
	By RidersDetailsVisible=By.xpath("//span[text()='Riders']//following::div[@class='ng-star-inserted']//mat-checkbox"); 


	public void wholeLifePolicyRidersTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		SoftAssert softassertriders=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());


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

				softassertriders.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);
		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);




		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);



			policysearchpage.Authorized();
			
			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Rider tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Rider tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
			waitForElementToAppear(PolicyDetailsWidgt);
			waitForElementToAppear(WholeLifeRidersTabClickTest);
			getText(PolicyDetailsWidgtClick);
			moveToElement(WholeLifeRidersTabClick);
			try {
				click(WholeLifeRidersTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsRidersTab)
			{
				PolicyDetailsRidersTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRidersTab.getMessage());
				System.out.println("Policy Details Riders tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Policy Details Riders tab is not clicked while trying to click after Authorized the call "));
				throw PolicyDetailsRidersTab;
			}


			waitForElementToAppear(RidersDetailsVisible);
			Thread.sleep(2000);
			String RidersTabMsg=RidersTab.getText();
			System.out.println(RidersTabMsg);

			if(RidersTabMsg.contains("This Policy does not have any riders."))
			{

				getText(RidersTextMsg);

				softassertriders.assertEquals(isSelectedElement(RidersTextMsg),true,"Policy Details-Riders-Check box is not selected");
				Thread.sleep(1000);
				moveToElement(reqDetails);
				moveToElement(IFRiderNotAppl);
				isShwoingValue(IFRiderNotAppl);
				getText(IFRiderNotAppl);
				System.out.println("text is"+ IFRiderNotAppl.getText());
				Thread.sleep(1000);
			}
			else
			{ 
				waitForElementToAppear(RiderCvgType);

				getText(RidersChkBox);

				softassertriders.assertEquals(isSelectedElement(RidersChkBox),true,"Policy Details-Riders Check box value is not selected");
				isShwoingValue(RiderCheckBoxVal);
				getText(RiderCheckBoxVal);
				Thread.sleep(1000);
				moveToElement(reqDetails);
				moveToElement(elseRiderNotAppl);
				isShwoingValue(elseRiderNotAppl);
				getText(elseRiderNotAppl);


				Thread.sleep(1000);


			}	

		}
		//Prod-Riders tab
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);



			pageScrollUp();
			waitForElementTodisAppear(SpinnerTest);
			waitForElementToAppear(PolicyDetailsWidgt);
			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsRidersTabProd)
			{
				PolicyDetailsRidersTabProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRidersTabProd.getMessage());
				System.out.println("Policy Details widget is not expanded while trying to click in prod ");
				log.error("Exception occured",new Exception("Policy Details widget is not expanded while trying to click in prod"));
				throw PolicyDetailsRidersTabProd;
			}

			waitForElementToAppear(WholeLifeRidersTabClickTest);
			getText(PolicyDetailsWidgtClick);
			moveToElement(WholeLifeRidersTabClick);
			try {
				click(WholeLifeRidersTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsRidersTabDetailsProd)
			{
				PolicyDetailsRidersTabDetailsProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsRidersTabDetailsProd.getMessage());
				System.out.println("Policy Details Riders tab is not clicked while trying to click in prod ");
				log.error("Exception occured",new Exception("Policy Details Riders tab is not clicked while trying to click in prod"));
				throw PolicyDetailsRidersTabDetailsProd;
			}

			String RidersTabMsg=RidersTab.getText();
			System.out.println(RidersTabMsg);

			if(RidersTabMsg.contains("This Policy does not have any riders."))
			{
				getText(RidersTextMsg);

				softassertriders.assertEquals(isSelectedElement(RidersTextMsg),true,"Policy Details-Riders-Check box is not selected");
				Thread.sleep(1000);
				moveToElement(reqDetails);
				moveToElement(IFRiderNotAppl);
				isShwoingValue(IFRiderNotAppl);
				getText(IFRiderNotAppl);
				System.out.println("text is"+ IFRiderNotAppl.getText());
				Thread.sleep(1000);
			}
			else
			{ 
				waitForElementToAppear(RiderCvgType);

				getText(RidersChkBox);

				softassertriders.assertEquals(isSelectedElement(RidersChkBox),true,"Policy Details-Riders Check box value is not selected");
				isShwoingValue(RiderCheckBoxVal);
				getText(RiderCheckBoxVal);
				Thread.sleep(1000);
				moveToElement(reqDetails);
				moveToElement(elseRiderNotAppl);
				isShwoingValue(elseRiderNotAppl);
				getText(elseRiderNotAppl);


				Thread.sleep(1000);


			}	

		}



		softassertriders.assertAll();
	}

	//*******************Funds Tab***********************

	//By wholeLifePolicyFundsMsg=By.xpath("//span[text()='Funds']//following::span[text()='Funds are not applicable for this product. '])");
	By fundsTabAppear=By.xpath("//span[text()='Funds']");
	@FindBy(xpath="//span[text()='FUNDS']//following::dd[1]") WebElement reqDetFunds;
	@FindBy(xpath="//div[text()='Fund Management']") WebElement cllDisPostFundSel;
	public void wholeLifePolicyFundsTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		SoftAssert softassertfunds=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());

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
				softassertfunds.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);
		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);



			policysearchpage.Authorized();
			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Funds Tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Funds Tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);

			waitForElementToAppear(PolicyDetailsWidgt);
			waitForElementToAppear(fundsTabAppear);
			moveToElement(WholeLifeFundsTabClick);
			try {
				click(WholeLifeFundsTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsFundsTab)
			{
				PolicyDetailsFundsTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsTab.getMessage());
				System.out.println("Policy Details Funds tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Policy Details Funds tab is not clicked while trying to click after Authorized the call "));
				throw PolicyDetailsFundsTab;
			}

			waitForElementToAppear(WholeLifeFundsTabMsgVisible);

try {
			softassertfunds.assertEquals(isSelectedElement(WholeLifeFundsTabMsg),true,"Policy Details-Funds-Funds Message is not checked");
			Thread.sleep(1000);
}
catch(Exception PolicyDetailsFundsCheckoxes)
{
	PolicyDetailsFundsCheckoxes.printStackTrace();
	System.out.println("Message is" + PolicyDetailsFundsCheckoxes.getMessage());
	System.out.println("Policy Details Funds tab - Checboxes are not selected in policy details tab");
	log.error("Exception occured",new Exception("Policy Details Funds Tab - Checboxes are not selected in policy details tab"));
	throw PolicyDetailsFundsCheckoxes;
}

			//*******Funds Requested Details*************************
			try{
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsFundsRequsted)
			{
				PolicyDetailsFundsRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsRequsted.getMessage());
				System.out.println("Policy Details Funds- Not navigated to Requested Details ");
				log.error("Exception occured",new Exception("Policy Details Funds- Not navigated to Requested Details "));
				throw PolicyDetailsFundsRequsted;
			}
			try {

			isShwoingValue(reqDetails);
			isShwoingValue(reqDetFunds);
			getText(WholeLifeFundsTabMsg);
			getText(reqDetFunds);
			softassertfunds.assertEquals(getText(reqDetFunds).contains(getText(WholeLifeFundsTabMsg)),true,"Funds Msg is not showing in the requested details");

			}
			catch(Exception PolicyFundsRequestedDetailsInfo)
            {
				PolicyFundsRequestedDetailsInfo.printStackTrace();
				System.out.println("Message is" + PolicyFundsRequestedDetailsInfo.getMessage());
				System.out.println("Policy Details Funds Tab-Selected checkboxes and corresponding data is not matching with requested details ");
				log.error("Exception occured",new Exception("Policy Details Funds Tab-Selected checkboxes and corresponding data is not matching with requested details"));
				throw PolicyFundsRequestedDetailsInfo;
            }
			//*******************Funds Call Disposition***********************



		}
		//Prod-Funds Tab
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);



			pageScrollUp();
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);

			waitForElementToAppear(PolicyDetailsWidgt);
			try
			{
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsFundsTab)
			{
				PolicyDetailsFundsTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsTab.getMessage());
				System.out.println("Funds-Policy Details tab is not clicked while trying to click in prod ");
				log.error("Exception occured",new Exception("Funds-Policy Details tab is not clicked while trying to click in prod"));
				throw PolicyDetailsFundsTab;
			}



			waitForElementToAppear(fundsTabAppear);
			moveToElement(WholeLifeFundsTabClick);
			try {
				click(WholeLifeFundsTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsFundsTabProd)
			{
				PolicyDetailsFundsTabProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsTabProd.getMessage());
				System.out.println("Funds-Policy Details Funds tab is not clicked while trying to click in prod ");
				log.error("Exception occured",new Exception("Funds-Policy Details Funds tab is not clicked while trying to click in prod "));
				throw PolicyDetailsFundsTabProd;
			}

try {
			softassertfunds.assertEquals(isSelectedElement(WholeLifeFundsTabMsg),true,"Policy Details-Funds-Funds Message is not checked");
			Thread.sleep(1000);
}catch(Exception PolicyDetailsFundsCheckoxesProd)
{
	PolicyDetailsFundsCheckoxesProd.printStackTrace();
	System.out.println("Message is" + PolicyDetailsFundsCheckoxesProd.getMessage());
	System.out.println("Policy Details Funds Tab- Checboxes are not selected in policy details tab in Prod");
	log.error("Exception occured",new Exception("Policy Details  Funds Tab - Checboxes are not selected in policy details tab in prod"));
	throw PolicyDetailsFundsCheckoxesProd;
}

			//*******Funds Requested Details*************************
			try{
				moveToElement(reqDetails);
			}
			catch(Exception PolicyDetailsFundsRequsted)
			{
				PolicyDetailsFundsRequsted.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsRequsted.getMessage());
				System.out.println("Policy Details Funds- Not navigated to Requested Details in prod ");
				log.error("Exception occured",new Exception("Policy Details funds- Not navigated to Requested Details in prod"));
				throw PolicyDetailsFundsRequsted;
			}

			try {
			isShwoingValue(reqDetails);
			isShwoingValue(reqDetFunds);
			getText(WholeLifeFundsTabMsg);
			getText(reqDetFunds);
			softassertfunds.assertEquals(getText(reqDetFunds).contains(getText(WholeLifeFundsTabMsg)),true,"Funds Msg is not showing in the requested details");
			}catch(Exception PolicyDetailsFundsRequestedDetailsInfoProd)
            {
				PolicyDetailsFundsRequestedDetailsInfoProd.printStackTrace();
				System.out.println("Message is" + PolicyDetailsFundsRequestedDetailsInfoProd.getMessage());
				System.out.println("Policy Details Funds tab-Selected checkboxes and corresponding data is not matching with requested details in Prod ");
				log.error("Exception occured",new Exception("Policy Details Funds Tab-Selected checkboxes and corresponding data is not matching with requested details in Prod"));
				throw PolicyDetailsFundsRequestedDetailsInfoProd;
            }
			//*******************Funds Call Disposition***********************

			try {
				isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception FundsCloseCallDetails)
			{
				FundsCloseCallDetails.printStackTrace();
				System.out.println("Message is" + FundsCloseCallDetails.getMessage());
				System.out.println("Funds-Save and Close Call is disabled due to non mandatory details in Prod");
				log.error("Exception occured",new Exception("Funds-Save and Close Call is disabled due to non mandatory details in Prod"));
				throw FundsCloseCallDetails;
			}

		}

		softassertfunds.assertAll();


	}


	//**********************Suspense*************

	By WholeLifeSuspenseTabAppear=By.xpath("//span[text()='Suspense']");
	@FindBy(xpath="//span[text()='SUSPENSE']//following::dd[1]") WebElement reqDetSus;
	@FindBy(xpath="//span[text()='Suspense']//following::button[text()=' Effective Date '][1]") WebElement susEffDate;
	By susEffDateAppear=By.xpath("//span[text()='Suspense']//following::button[text()=' Effective Date '][1]");
	@FindBy(id="policy-suspense-suspense-amount") WebElement susAmountValue;
	@FindBy(xpath="//span[text()='SUSPENSE']//following::dd[1]") WebElement reqSusAmtValue;
	@FindBy(xpath="//span[text()='SUSPENSE']//following::dd[2]") WebElement reqSusEffValue;
	@FindBy(id="policy-suspense-effective-date") WebElement susEffDateValue;
	@FindBy(id="//span[text()='Details']") WebElement polDetailsClick;
	@FindBy(xpath="//mat-panel-title[normalize-space()='Policy Details']") WebElement polDetHeader;
	By SusChk =By.id("checkboxInTable_policySuspense_0_0");


	@FindBy(xpath="//SPAN[text()='SUSPENSE']//following::dd[1]") WebElement elseSuspenseCheck;
	@FindBy(xpath="//SPAN[text()='SUSPENSE']//following::dd[2]") WebElement elseSuspenseEffectiveDate;




	public void wholeLifePolicySuspenseTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{

		SoftAssert softassertsuspensetab=new SoftAssert();

		log=LogManager.getLogger(PolDetWidget.class.getName());



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

				softassertsuspensetab.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);




			;
			policysearchpage.Authorized();

			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Funds Tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Funds Tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(2000);
			waitForElementToAppear(PolicyDetailsWidgt);
			waitForElementToAppear(WholeLifeSuspenseTabAppear);
			moveToElement(WholeLifeSuspenseTabClick);
			Thread.sleep(2000);
			try {
				click(WholeLifeSuspenseTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsSuspenseTab)
			{
				PolicyDetailsSuspenseTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsSuspenseTab.getMessage());
				System.out.println("Suspense-Policy Details Suspense tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Suspense-Policy Details Suspense tab is not clicked while trying to click after Authorized the call "));
				throw PolicyDetailsSuspenseTab;
			}

			String SusMessage=WholeLifeSuspense.getText();
			System.out.println(SusMessage);


			if (SusMessage.equals("No records found."))
			{
				System.out.println("This policy does not have any suspense records");
			}
			else
			{
				waitForElementToAppear(susEffDateAppear);
				isShwoingValue(susEffDate);
				isShwoingValue(susEffDateValue);
				isShwoingValue(susAmountValue);
				softassertsuspensetab.assertEquals(susEffDate.isDisplayed(),true,"Effective Date label is not showing in Suspense Tab");
				softassertsuspensetab.assertEquals(susEffDateValue.isDisplayed(),true,"Effective Date  is not showing in Suspense Tab");
				softassertsuspensetab.assertEquals(susAmountValue.isDisplayed(),true,"Amount is not showing in Suspense Tab");
				waitForElementToAppear(SusChk);
				try {
				softassertsuspensetab.assertEquals(isSelectedElement(WholeLifeSusEffDate),true,"Suspense check box is not checked");
				Thread.sleep(1000);
				}
				catch(Exception PolicyDetailsSuspenseCheckoxes)
				{
					PolicyDetailsSuspenseCheckoxes.printStackTrace();
					System.out.println("Message is" + PolicyDetailsSuspenseCheckoxes.getMessage());
					System.out.println("Policy Details Suspense tab - Checboxes are not selected in policy details Suspense tab");
					log.error("Exception occured",new Exception("Policy Details Suspense tab- Checboxes are not selected in policy details Suspense tab"));
					throw PolicyDetailsSuspenseCheckoxes;
				}
				moveToElement(reqDetails);
				moveToElement(elseSuspenseCheck);
				isShwoingValue(elseSuspenseCheck);
				getText(elseSuspenseCheck);
				getText(susEffDateValue);
				getText(susAmountValue);
				try {
				softassertsuspensetab.assertEquals(getText(elseSuspenseCheck).contains(getText(susAmountValue)),true,"supense Amount  is not showing in the requested details");
				softassertsuspensetab.assertEquals(getText(elseSuspenseEffectiveDate).contains(getText(susEffDateValue)),true,"supense Eff Date  is not showing in the requested details");

				}
				catch(Exception PolicyDetailsSuspenseRequestedDetailsInfo)
	            {
					PolicyDetailsSuspenseRequestedDetailsInfo.printStackTrace();
					System.out.println("Message is" + PolicyDetailsSuspenseRequestedDetailsInfo.getMessage());
					System.out.println("Policy Details Suspense tab-Selected checkboxes and corresponding data is not matching with requested details ");
					log.error("Exception occured",new Exception("Policy Details Suspense tab-Selected checkboxes and corresponding data is not matching with requested details"));
					throw PolicyDetailsSuspenseRequestedDetailsInfo;
	            }




			}

		}
		//Prod-Suspense tab
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);




			pageScrollUp();
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);

			waitForElementToAppear(PolicyDetailsWidgt);
			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);

			}
			catch(Exception PolicyDetailsSuspenseWidget)
			{
				PolicyDetailsSuspenseWidget.printStackTrace();
				System.out.println("Message is" + PolicyDetailsSuspenseWidget.getMessage());
				System.out.println("Suspense tab-Policy Details Widget is not showing upon clicking in prod ");
				log.error("Exception occured",new Exception("Suspense tab-Policy Details Widget is not showing upon clicking in prod"));
				throw PolicyDetailsSuspenseWidget;
			}

			waitForElementToAppear(WholeLifeSuspenseTabAppear);
			moveToElement(WholeLifeSuspenseTabClick);
			Thread.sleep(2000);
			try {
				click(WholeLifeSuspenseTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsSuspenseTab)
			{
				PolicyDetailsSuspenseTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsSuspenseTab.getMessage());
				System.out.println("Suspense-Policy Details Suspense tab is not clicked while trying to click in Prod ");
				log.error("Exception occured",new Exception("Suspense-Policy Details Suspense tab is not clicked while trying to click in Prod"));
				throw PolicyDetailsSuspenseTab;
			}

			String SusMessage=WholeLifeSuspense.getText();
			System.out.println(SusMessage);


			if (SusMessage.equals("No records found."))
			{
				System.out.println("This policy does not have any suspense records");
			}
			else
			{
				waitForElementToAppear(susEffDateAppear);
				isShwoingValue(susEffDate);
				isShwoingValue(susEffDateValue);
				isShwoingValue(susAmountValue);
				softassertsuspensetab.assertEquals(susEffDate.isDisplayed(),true,"Effective Date label is not showing in Suspense Tab");
				softassertsuspensetab.assertEquals(susEffDateValue.isDisplayed(),true,"Effective Date  is not showing in Suspense Tab");
				softassertsuspensetab.assertEquals(susAmountValue.isDisplayed(),true,"Amount is not showing in Suspense Tab");
				waitForElementToAppear(SusChk);
				try {
				softassertsuspensetab.assertEquals(isSelectedElement(WholeLifeSusEffDate),true,"Suspense check box is not checked");
				Thread.sleep(1000);
				}
				catch(Exception PolicyDetailsSuspenseCheckoxesProd)
				{
					PolicyDetailsSuspenseCheckoxesProd.printStackTrace();
					System.out.println("Message is" + PolicyDetailsSuspenseCheckoxesProd.getMessage());
					System.out.println("Policy Details Suspense tab- Checboxes are not selected in policy details Suspense tab in Prod");
					log.error("Exception occured",new Exception("Policy Details Suspense tab - Checboxes are not selected in policy details Suspense tab in Prod"));
					throw PolicyDetailsSuspenseCheckoxesProd;
				}
				moveToElement(reqDetails);
				moveToElement(elseSuspenseCheck);
				isShwoingValue(elseSuspenseCheck);
				getText(elseSuspenseCheck);
				getText(susEffDateValue);
				getText(susAmountValue);
				try {
				softassertsuspensetab.assertEquals(getText(elseSuspenseCheck).contains(getText(susAmountValue)),true,"supense Amount  is not showing in the requested details");
				softassertsuspensetab.assertEquals(getText(elseSuspenseEffectiveDate).contains(getText(susEffDateValue)),true,"supense Eff Date  is not showing in the requested details");

				}
				catch(Exception PolicyDetailsSuspenseRequestedDetailsInfoProd)
	            {
					PolicyDetailsSuspenseRequestedDetailsInfoProd.printStackTrace();
					System.out.println("Message is" + PolicyDetailsSuspenseRequestedDetailsInfoProd.getMessage());
					System.out.println("Policy Details Suspense tab-Selected checkboxes and corresponding data is not matching with requested details in prod ");
					log.error("Exception occured",new Exception("Policy Details Suspense tab-Selected checkboxes and corresponding data is not matching with requested details in prod "));
					throw PolicyDetailsSuspenseRequestedDetailsInfoProd;
	            }




			}
		}

		//**************************Suspense call disPosition*********************

		try {
			isDisabled(CloseCall,CallDispositionDropDownClick,CallDispositionChkInqSel,CloseCallPhn,"9090909090");
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
		}
		catch(Exception PolicySuspenseCloseCallDetails)
		{
			PolicySuspenseCloseCallDetails.printStackTrace();
			System.out.println("Message is" + PolicySuspenseCloseCallDetails.getMessage());
			System.out.println("Suspense-Save and Close Call is disabled due to non mandatory details in prod");
			log.error("Exception occured",new Exception("Suspense-Save and Close Call is disabled due to non mandatory details in prod"));
			throw PolicySuspenseCloseCallDetails;
		}









		softassertsuspensetab.assertAll();

	}




	//*****************************************Suspense tab is completed**************************************************


	//******************************Notes Tab**********************

	By NoteTabAppear=By.xpath("//span[text()='Notes']");
	@FindBy(xpath="//span[text()='Pending Transactions']//following::div[@class='mat-tab-header-pagination-chevron'][1]")
	WebElement rytArrowclick;
	@FindBy(xpath="//span[text()='NOTES']//following::dd[1]") WebElement reqDetNoteMsg;
	@FindBy(xpath="//span[text()='NOTES']//following::dd[2]") WebElement reqDetOpeIdMsg;
	@FindBy(xpath="//span[text()='NOTES']//following::dd[3]") WebElement reqDetNoteTyeMsg;
	@FindBy(xpath="//span[text()='NOTES']//following::dd[4]") WebElement reqDetNoteTyeNumMsg;
	@FindBy(xpath="//span[text()='NOTES']//following::dd[5]") WebElement reqDetNoteDateMsg;
	@FindBy(xpath="//span[text()='Notes']//following::span[contains(text(),'Message')]//following::label[1]") WebElement notesMsgVal;
	@FindBy(xpath="//span[text()=' Operator ID : ']//following::label[1]") WebElement noteOprIdVal;;
	@FindBy(xpath="//span[text()=' Note Type : ']//following::label[1]") WebElement NotTypeVal;
	@FindBy(xpath="//span[text()=' Type Number : ']//following::label[1]") WebElement NoteTypeNumVal;
	@FindBy(xpath="//span[text()=' Date : ']//following::label[1]") WebElement noteDateVal;
	By NotesChkBox=By.xpath("//span[text()=' Message : ']");
	By rytArrowclickVisible=By.xpath("//span[text()='Pending Transactions']//following::div[@class='mat-tab-header-pagination-chevron'][1]");


	public void wholeLifeNotesTab(String URL,String UserNames,String Passwords,String Policy,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		SoftAssert softassertnotes=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());


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
				softassertnotes.assertEquals(ActualStatuscode,ExpectedStatusCode);



			}





		}

				);

		LoginDetails pld=new LoginDetails(driver);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String DevRegion=prop.getProperty("DEV");
		System.out.println("Dev region is:" + DevRegion);
		String PilotRegion=prop.getProperty("PILOT");
		System.out.println("Pilot region is:" + PilotRegion);
		String ProdfixRegion=prop.getProperty("Prodfix");
		System.out.println("Prodfix region is:" + ProdfixRegion);
		String ProdRegion=prop.getProperty("Prod");
		System.out.println("Prod region is:" + ProdRegion);
		String BHFSITRegion=prop.getProperty("BHFSIT");
		System.out.println("BHFSITRegion region is:" + BHFSITRegion);
		String BHFPILOTRegion=prop.getProperty("BHFPILOT");
		System.out.println("BHFPILOTRegion region is:" + BHFPILOTRegion);
		String ANTILOPESITRegion=prop.getProperty("ANTILOPESIT");
		System.out.println("ANTILOPESITRegion region is:" + ANTILOPESITRegion);
		String ANTILOPEPILOTRegion=prop.getProperty("ANTILOPEPILOT");
		System.out.println("ANTILOPEPILOTRegion region is:" + ANTILOPEPILOTRegion);



		//Dev Region
		if(DevRegion.equals(URL)||PilotRegion.equals(URL)||ProdfixRegion.equals(URL)|| BHFSITRegion.equals(URL)|| BHFPILOTRegion.equals(URL)||ANTILOPESITRegion.equals(URL)||ANTILOPEPILOTRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);





			policysearchpage.Authorized();

			try {
				pageScrollUp();
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(1000);
			}
			catch(Exception ScrollupAfterAuthorize)
			{
				ScrollupAfterAuthorize.printStackTrace();
				System.out.println("Message is" + ScrollupAfterAuthorize.getMessage());
				System.out.println("Notes tab-Page is not scrollup after authorized the call ");
				log.error("Exception occured",new Exception("Notes tab-Page is not scrollup after authorized the call"));
				throw ScrollupAfterAuthorize;
			}
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
			waitForElementToAppear(PolicyDetailsWidgt);
			Thread.sleep(1000);
			//waitForElementToAppear(rytArrowclickVisible);
			//click(rytArrowclick);
			waitForElementTodisAppear(SpinnerTest);

			waitForElementToAppear(NoteTabAppear);
			moveToElement(NoteTabClick);
			try {
				click(NoteTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsNotesTab)
			{
				PolicyDetailsNotesTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsNotesTab.getMessage());
				System.out.println("Notes-Policy Details Notes tab is not clicked while trying to click after Authorized the call ");
				log.error("Exception occured",new Exception("Notes-Policy Details Notes tab is not clicked while trying to click after Authorized the call "));
				throw PolicyDetailsNotesTab;
			}

			String NoteWinMsg=NoteTabRecords.getText();
			System.out.println(NoteWinMsg);

			if(NoteWinMsg.equals("No records found."))
			{
				System.out.println("This policy does not have notes records");
			}
			else
			{ 
				waitForElementToAppear(NoteMsgCheckAppear);
				softassertnotes.assertEquals(NoteMsgCheck.isDisplayed(),true,"Message label is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteOprId.isDisplayed(),true,"Operator Id is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteType.isDisplayed(),true,"Note Type is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteTypeNum.isDisplayed(),true,"Type Number is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteDate.isDisplayed(),true,"Date is not showing in Notes Tab");
				waitForElementToAppear(NoteMsgCheckAppear);
				try {
				softassertnotes.assertEquals(isSelectedElement(NoteMsgCheck),true,"Message label is not clickable in Notes Tab");
				Thread.sleep(1000);
				}
				catch(Exception PolicyDetailsNotesCheckoxes)
				{
					PolicyDetailsNotesCheckoxes.printStackTrace();
					System.out.println("Message is" + PolicyDetailsNotesCheckoxes.getMessage());
					System.out.println("Policy Details Notes Tab- Checboxes are not selected in policy details Notes tab");
					log.error("Exception occured",new Exception("Policy Details Notes Tab - Checboxes are not selected in policy details Notes tab"));
					throw PolicyDetailsNotesCheckoxes;
				}
				moveToElement(reqDetails);
				moveToElement(reqDetNoteMsg);
				isShwoingValue(reqDetNoteMsg);
				getText(reqDetNoteMsg);
				getText(notesMsgVal);
try
{
				softassertnotes.assertEquals(getText(reqDetNoteMsg).contains(getText(notesMsgVal)),true,"Notes Mesaage   is not showing in the requested details");

}
catch(Exception PolicyDetailsNotesRequestedDetailsInfo)
{
	PolicyDetailsNotesRequestedDetailsInfo.printStackTrace();
	System.out.println("Message is" + PolicyDetailsNotesRequestedDetailsInfo.getMessage());
	System.out.println("Policy Details Notes tab-Selected checkboxes and corresponding data is not matching with requested details ");
	log.error("Exception occured",new Exception("Policy Details Notes tab-Selected checkboxes and corresponding data is not matching with requested details"));
	throw PolicyDetailsNotesRequestedDetailsInfo;
}

			}
		}	

		//prod-notes tab
		else if(ProdRegion.equals(URL))
		{
			pld.panoUrl(URL);

			pld.panoLogin(UserNames,Passwords);


			PolicySearchPage policysearchpage=new PolicySearchPage(driver);

			policysearchpage.SearchButton();

			policysearchpage.searchPolNum(Policy);





			pageScrollUp();
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
			waitForElementToAppear(PolicyDetailsWidgt);
			try {
				click(PolicyDetailsWidgtClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);
			}
			catch(Exception PolicyDetailsWidgetNotes)
			{
				PolicyDetailsWidgetNotes.printStackTrace();
				System.out.println("Message is" + PolicyDetailsWidgetNotes.getMessage());
				System.out.println("Notes-Policy Details Widget is not expanded upon clicking in prod ");
				log.error("Exception occured",new Exception("Notes-Policy Details Widget is not expanded upon clicking in prod "));
				throw PolicyDetailsWidgetNotes;
			}

			//click(rytArrowclick);


			waitForElementToAppear(NoteTabAppear);
			moveToElement(NoteTabClick);
			try {
				click(NoteTabClick);
				waitForElementTodisAppear(SpinnerTest);
				Thread.sleep(2000);

			}
			catch(Exception PolicyDetailsNotesTab)
			{
				PolicyDetailsNotesTab.printStackTrace();
				System.out.println("Message is" + PolicyDetailsNotesTab.getMessage());
				System.out.println("Notes-Policy Details Notes tab is not clicked while trying to click in Prod ");
				log.error("Exception occured",new Exception("Notes-Policy Details Notes tab is not clicked while trying to click in Prod"));
				throw PolicyDetailsNotesTab;
			}

			String NoteWinMsg=NoteTabRecords.getText();
			System.out.println(NoteWinMsg);

			if(NoteWinMsg.equals("No records found."))
			{
				System.out.println("This policy does not have notes records");
			}
			else
			{ 
				waitForElementToAppear(NoteMsgCheckAppear);
				softassertnotes.assertEquals(NoteMsgCheck.isDisplayed(),true,"Message label is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteOprId.isDisplayed(),true,"Operator Id is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteType.isDisplayed(),true,"Note Type is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteTypeNum.isDisplayed(),true,"Type Number is not showing in Notes Tab");
				softassertnotes.assertEquals(NoteDate.isDisplayed(),true,"Date is not showing in Notes Tab");
				waitForElementToAppear(NoteMsgCheckAppear);
				try {
				softassertnotes.assertEquals(isSelectedElement(NoteMsgCheck),true,"Message label is not clickable in Notes Tab");
				Thread.sleep(1000);
				}
				catch(Exception PolicyDetailsNotesCheckoxesProd)
				{
					PolicyDetailsNotesCheckoxesProd.printStackTrace();
					System.out.println("Message is" + PolicyDetailsNotesCheckoxesProd.getMessage());
					System.out.println("Policy Details Notes tab- Checboxes are not selected in policy details tab in Prod");
					log.error("Exception occured",new Exception("Policy Details Notes Tab- Checboxes are not selected in policy details tab in Prod"));
					throw PolicyDetailsNotesCheckoxesProd;
				}
				moveToElement(reqDetails);
				moveToElement(reqDetNoteMsg);
				isShwoingValue(reqDetNoteMsg);
				getText(reqDetNoteMsg);
				getText(notesMsgVal);
try {
				softassertnotes.assertEquals(getText(reqDetNoteMsg).contains(getText(notesMsgVal)),true,"Notes Mesaage   is not showing in the requested details");
}
catch(Exception PolicyDetailsNotesRequestedDetailsInfoProd)
{
	PolicyDetailsNotesRequestedDetailsInfoProd.printStackTrace();
	System.out.println("Message is" + PolicyDetailsNotesRequestedDetailsInfoProd.getMessage());
	System.out.println("Policy Details Notes tab-Selected checkboxes and corresponding data is not matching with requested details in Prod ");
	log.error("Exception occured",new Exception("Policy Details Notes-Selected checkboxes and corresponding data is not matching with requested details in Prod"));
	throw PolicyDetailsNotesRequestedDetailsInfoProd;
}


			}
		}




		softassertnotes.assertAll();

	}



	//My Call History Widget

	By MycallHistoryTab=By.xpath("//span[mat-panel-title=' My Call History ']");




	@FindBy(css="mat-icon[class='mat-icon notranslate flaticon-search searchInHeader csr-search-bar-icon material-icons mat-icon-no-color']")

	By MyCallHistPolload=By.id("call-history-policy-camelcase");
	@FindBy(id="call-history-date-time") WebElement myCalHistDate;

	public void myCallHistoryWidget(String URL,String UserNames,String Passwords,String ExpectedURL,String ExpectedStatusCode) throws Exception
	{
		SoftAssert softassertmycallhis=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());

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
			Thread.sleep(2000);
		}

		catch(Exception MyCallHistoryDetails)
		{
			MyCallHistoryDetails.printStackTrace();
			System.out.println("Message is" + MyCallHistoryDetails.getMessage());
			System.out.println("My call history API fail");
			log.error("Exception occured",new Exception("My call history API fail"));
			throw MyCallHistoryDetails;
		}


		softassertmycallhis.assertAll();

	}


	//********************** My Call History completed*********************

	@FindBy(xpath="//span[mat-panel-title=' MY ASSIGNED WORK ']") WebElement MyAssignedWork;
	By MyAssignedWorkTab=By.xpath("//span[mat-panel-title=' MY ASSIGNED WORK ']");



	public void myAssignedWorkWidget(String URL,String UserNames,String Passwords,String ExpectedURL) throws Exception 
	{
		SoftAssert softassertmyassignedwork=new SoftAssert();
		log=LogManager.getLogger(PolDetWidget.class.getName());

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
				String z1=response.getStatus().toString();

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

			Thread.sleep(2000);
			int MyAssignedWorkCount=driver.findElements(By.xpath("//span[mat-panel-title=' MY ASSIGNED WORK ']//following::div[@class='ng-star-inserted']//table[@role='grid']//tbody//tr")).size();
			
			System.out.println("Rows present in the my assigned work :" + MyAssignedWorkCount);
		}
		catch(Exception MyAssignedWorkDetails)
		{
			MyAssignedWorkDetails.printStackTrace();
			System.out.println("Message is" + MyAssignedWorkDetails.getMessage());
			System.out.println("My assigned work api fails ");
			log.error("Exception occured",new Exception("My assigned work api fails"));
			throw MyAssignedWorkDetails;
		}


		softassertmyassignedwork.assertAll();

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
