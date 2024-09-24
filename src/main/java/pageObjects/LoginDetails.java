package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import ReuseAbstratComponents.ReuseCode;

public class LoginDetails extends ReuseCode{
	WebDriver driver;
	public static org.apache.logging.log4j.Logger log;

	
	public LoginDetails(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="authUsername")
	WebElement UserName;
	@FindBy(id="authPassword")
	WebElement Password;
	@FindBy(id="loginBtn")
	WebElement Login;
	By SpinnerTest=By.xpath("lds-spinner");
	
	
	public void panoUrl(String URL) throws Exception
	{
		try {
		driver.get(URL);
		Thread.sleep(1000);
		
		}
		catch(Exception URLCheck)
		{
			URLCheck.printStackTrace();
			System.out.println("Message is" + URLCheck.getMessage());
			System.out.println("URL is not accessed");
			log.error("Exception occured",new Exception("URL is not accessed  "));
			throw URLCheck;
		}
		
		 
	}


	public void panoLogin(String UserNames,String Passwords) throws Exception
	{
		log=LogManager.getLogger(LoginDetails.class.getName());
		try {
		UserName.sendKeys(UserNames);
		Password.sendKeys(Passwords);
		

		
		Login.click();
		waitForElementTodisAppear(SpinnerTest);
		Thread.sleep(2000);
	
		}
		catch(Exception LoginClick)
		{
			LoginClick.printStackTrace();
			System.out.println("Message is" + LoginClick.getMessage());
			System.out.println("Pano Login is not working as expected ");
			log.error("Exception occured",new Exception("Pano Login is not working as expected  "));
			throw LoginClick;
		}
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
