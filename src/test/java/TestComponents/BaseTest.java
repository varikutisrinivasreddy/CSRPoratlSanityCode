package TestComponents;

import java.io.File;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import javax.swing.plaf.DimensionUIResource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginDetails;
import pageObjects.PolicySearchPage;
import pageObjects.TestResultData;




public class BaseTest {

	public WebDriver driver;
	static String regname;
	static String body;


	public WebDriver initializeDriver() throws IOException 
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalResources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{

			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		/*
			options.addArguments("--headless=new");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			//options.addArguments("--window-size=1280,800");
			options.addArguments("--window-size=1920,1080");
*/

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);


		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{

		}
		else if(browserName.equalsIgnoreCase("edge"))
		{

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	@BeforeMethod
	public void PanoLaunchApplication() throws IOException, InterruptedException
	{

		driver=initializeDriver();

	}



	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;

		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir") + "//reports//" +testCaseName +generateTimeStamp()+ ".png");

		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName+generateTimeStamp()+".png";


	}


	public   String generateTimeStamp()
	{
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":","_");
	}


	public void pageScrollUP()
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-600);");

	}


	public boolean assertionsTrue()
	{
		SoftAssert softassert=new SoftAssert();
		softassert.assertTrue(true);
		return  true;
	}



	@BeforeClass
	@org.testng.annotations.Parameters("excelpath")
	public void regionName(String region) {
		//sai
		System.out.println("Before class method executed");
		
		if (TestResultData.testResultData != null && !TestResultData.testResultData.isEmpty()) {

			TestResultData.testResultData.clear();
			TestResultData.testResultData = new HashMap<String, String>();
		}
		
		//sai
		if (region.equalsIgnoreCase("PANODEV")) {
			regname = "PANODevPolicyInput.xlsx";
			body	= "PANODEV Automation Test Results";
		} else if (region.equalsIgnoreCase("PANOPILOT")) {
			regname = "PANOPilotPolicyInput.xlsx";
			body	= "PANOPILOT Automation Test Results";
		} 
		else if (region.equalsIgnoreCase("PANOPRODFIX")) {
			regname = "PANOProdFIXPolicyInput.xlsx";
			body	= "PANOPRODFIX Automation Test Results";
		} 
		else if (region.equalsIgnoreCase("PANOPROD")) {
			regname = "PANOProdPolicyInput.xlsx";
			body	= "PANOPROD Automation Test Results";
		} else if (region.equalsIgnoreCase("BHFSIT")) {
			regname = "BHFSITPolicyInput.xlsx";
			body	= "BHFSIT Automation Test Results";
		} else if (region.equalsIgnoreCase("BHFPILOT")) {
			regname = "BHFPILOTPolicyInput.xlsx";
			body	= "BHFPILOT Automation Test Results";
		}
		else if (region.equalsIgnoreCase("BHFPROD")) {
			regname = "BHFPRODPolicyInput.xlsx";
			body	= "BHFPROD Automation Test Results";
		}

	}


@DataProvider(name="PolicyData")
public String[][] getDataa(Method m) throws IOException
	
	{
		String sheetname=m.getName();
File excelfile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\InputData\\"+regname);
		
		FileInputStream fis=new FileInputStream(excelfile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1 =workbook.getSheet(sheetname);
		int noOfRows=sheet1.getPhysicalNumberOfRows();
		System.out.println("No of rows:" +noOfRows );
		int noOfCol=sheet1.getRow(0).getLastCellNum();

		System.out.println("No of Columns"+noOfCol);
		String[][] data=new String[noOfRows-1][noOfCol];
		for(int i=0;i<noOfRows-1;i++)
		{
			for (int j=0;j<noOfCol;j++)
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=	df.formatCellValue(sheet1.getRow(i+1).getCell(j));
				System.out.println("data present in the excel" + data[i][j]);

			}
			System.out.println();
		}

		workbook.close();
		fis.close();
		return data;
	}




	//sai
	public  void sendOutlookEmail()  {

		String toEmail = "srinivasa.reddy4@dxc.com";
		

	
		
		final String fromEmail = "csrportalsanitycheck@gmail.com";
		final String password="bvak ybdm cosk kbva";

				
		// Email server properties (for Outlook/Office 365)
		Properties props = new Properties();


		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Authenticate the sender's email account
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(fromEmail, password);
			}
		});

		try {
			// Create a MimeMessage object
			Message message = new MimeMessage(session);

			// Set the sender and recipient addresses
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			LocalDateTime LDT=LocalDateTime.now();

			String bodypart = body;
			// Set the email subject and body
			message.setSubject("Sanity check on CSRPortal");
			// String[] body=new String[3];
			StringBuilder body = new StringBuilder();

			body.append("<html><body>");
			body.append(bodypart);
			body.append("<table border='2'>");
			body.append("<tr><th>Application Name / API</th><th>Status </th></tr>");




			for (Map.Entry<String, String> entry : TestResultData.testResultData.entrySet()) {
				// Add the table HTML to the email content

				// Add table rows and cells

				body.append("<tr>");
				body.append("<td> " + (StringUtils.rightPad(entry.getKey(), 30) + "</td>" + "<td>"
						+ StringUtils.rightPad(entry.getValue(), 15) +" on "+LDT+ "\n") + "</td>");
				body.append("</tr>");

				System.out.println(body);
			}
			body.append("</table>");
			body.append("</body></html>");

			message.setContent(body.toString(), "text/html");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// MimeBodyPart textPart = new MimeBodyPart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body.toString(), "text/html");

			// Part two is the attachment
/*
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = System.getProperty("user.dir")+"\\reports\\index1.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

		*/

			// // Add the parts to the multipart

	//	multipart.addBodyPart(messageBodyPart2);
			
			multipart.addBodyPart(htmlPart);


			// Set the content of the message
			message.setContent(multipart);
			// message.setContent(body.toString(), "text/html");

			// Send the email
			Transport.send(message);

			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
			System.err.println("Failed to send email: " + e.getMessage());
		}

	}





	 


	@AfterMethod
	public void BrowserClose()
	{
		driver.close();
	}

















}	














