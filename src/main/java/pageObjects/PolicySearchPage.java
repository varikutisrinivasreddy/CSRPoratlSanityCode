package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReuseAbstratComponents.ReuseCode;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PolicySearchPage extends ReuseCode {

	WebDriver driver;
	public static org.apache.logging.log4j.Logger log;

	public PolicySearchPage(WebDriver driver)
	{

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="lds-spinner")
	WebElement Spinner;
	@FindBy(id="contracts-collection-search-text")
	WebElement Search;
	@FindBy(css="mat-icon[class='mat-icon notranslate flaticon-search searchInHeader csr-search-bar-icon material-icons mat-icon-no-color']")
	WebElement clickButton;
	@FindBy(id="authorize-undefined-button")
	WebElement AuthorizedButtonCli;

	By SearchText=By.id("contracts-collection-search-text");
	public void SearchButton() throws InterruptedException
	{
		log=LogManager.getLogger(PolicySearchPage.class.getName());

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
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(1000);
		}
		catch(Exception SearchClick ){
			SearchClick.printStackTrace();
			System.out.println("Message is" + SearchClick.getMessage());
			System.out.println("Search Text edit is not clikced for entering the policy in the search ");
			log.error("Exception occured",new Exception("Search Text edit is not clikced for entering the policy in the search "));
			throw SearchClick;
		}
	}



	public void searchPolNum(String Policy) throws InterruptedException
	{
		log=LogManager.getLogger(PolicySearchPage.class.getName());

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

	By SpinnerTest=By.xpath("lds-spinner");
	public void SpinnerCheck()
	{
		waitForElementTodisAppear(SpinnerTest);

	}

	By AuthorizedButton=By.id("authorize-undefined-button");
	@FindBy(id="policy-details-policy-status-desc-action-checkbox")
	WebElement PolDetStatus;
	@FindBy(xpath="//span[normalize-space()='Details']") WebElement polDetailsMove;
	By PolDetStatusAppear=By.id("policy-details-policy-status-desc-action-checkbox");

	public void Authorized() throws InterruptedException
	{
		log=LogManager.getLogger(PolicySearchPage.class.getName());

		waitForElementTodisAppear(SpinnerTest);
		moveToElement(AuthorizedButtonCli);
		waitForElementToAppear(AuthorizedButton);
		waitForElementTodisAppear(SpinnerTest);
		try {
			doubleClickEle(AuthorizedButtonCli);
			waitForElementTodisAppear(SpinnerTest);
			Thread.sleep(3000);
		}
		catch(Exception AuthorizeButtonClick)
		{
			AuthorizeButtonClick.printStackTrace();
			System.out.println("Message is" + AuthorizeButtonClick.getMessage());
			System.out.println("AuthorizeButton is not clikced ");
			log.error("Exception occured",new Exception("AuthorizeButton is not clicked"));
			throw AuthorizeButtonClick;
		}	




	}


}
