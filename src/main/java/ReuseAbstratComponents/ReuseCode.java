package ReuseAbstratComponents;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;






public class ReuseCode {

	WebDriver driver;


	public ReuseCode(WebDriver driver)
	{
		this.driver=driver;
	}


	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait W=new WebDriverWait(driver,Duration.ofSeconds(120));

		W.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	


	public void waitForElementTodisAppear(By findBy)
	{
		WebDriverWait W=new WebDriverWait(driver,Duration.ofSeconds(120));
		W.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	
	}


	public void softassertnotes()
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-450);");
	}



	public void pageScrollDown()
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400);");
	}
	
	public void pageScrollUp()
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400);");
	}



	public void scrollVisibilityOfEle(WebElement ele)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",ele);
	}



	public boolean isDisplayedElement(WebElement Obj)
	{
		boolean obj1=Obj.isDisplayed();
		String displayText=Obj.getText();
		System.out.println(obj1);
		if(obj1==true)
		{

			System.out.println(displayText + ":" + "Element is displayed");

		}
		else
		{
			System.out.println(displayText + ":" + "Element is not dispalyed");
		}
		return true;
	}



	public boolean isSelectedElement(WebElement Obj)
	{
		boolean obj1=Obj.isSelected();
		System.out.println(obj1);
		if(obj1==false)
		{
			Obj.click();

		}

		return true;
	}




	public boolean isShwoingValue(WebElement element)
	{
		boolean eleDis=element.isDisplayed();
		System.out.println(eleDis);
		if(eleDis==true)
		{
			String elementText=element.getText();

			System.out.println(elementText);			
		}
		return true;
	}




	public void textBox(WebElement Ele,String text)
	{
		Ele.click();
		Ele.clear();
		Ele.sendKeys(text);
	}

	public void moveToElement(WebElement element)
	{
		Actions action = new Actions(driver); 
		action.moveToElement(element).perform();
	}

	public void doubleClickEle(WebElement element)
	{
		Actions action = new Actions(driver); 

		action.doubleClick(element).perform();
	}


	public void copyValue(WebElement EleOne)
	{
		EleOne.sendKeys(Keys.chord(Keys.CONTROL,"c"));

	}

	public void pasteValue(WebElement EleTwo)
	{
		EleTwo.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public void textEnter(WebElement EleTwo,String text)
	{
		EleTwo.sendKeys(text);
	}


	public void click(WebElement Ele)
	{
		Ele.click();
	}

	public String getText(WebElement Ele)
	{
		return Ele.getText();

	}

	public void isEnabled(WebElement Ele)
	{

		boolean buttonEna=Ele.isEnabled();
		System.out.println(buttonEna);
		if(buttonEna==true)
		{
			Ele.click();		
		}
		
	}
	
	public boolean ButtonCheck(WebElement Ele)
	{

		boolean buttonEna=Ele.isEnabled();
		System.out.println(buttonEna);
		return buttonEna;
		
		
	}

	

	public void dropDownSelect(WebElement EleOne,WebElement EleTwo) throws InterruptedException
	{
		EleOne.click();
		EleTwo.click();
		System.out.println(EleTwo.getText());
	}

	public boolean isNotEnabled(WebElement EleTwo,String text,WebElement EleThree,String textone,WebElement EleFour,String texttwo,WebElement EleFive,WebElement value,WebElement EleSix,String textthree,WebElement EleSeven,String testfour,WebElement Ele)
	{

		EleTwo.click();
		EleTwo.clear();
		EleTwo.sendKeys(text);
		EleThree.click();
		EleThree.clear();
		EleThree.sendKeys(textone);
		EleFour.click();
		EleFour.clear();
		EleFour.sendKeys(texttwo);
		EleFive.click();
		value.click();
		EleSix.click();
		EleSix.clear();
		EleSix.sendKeys(textthree);
		EleSeven.click();
		EleSeven.clear();
		EleSeven.sendKeys(testfour);
		boolean buttonEnable=Ele.isEnabled();
		if(buttonEnable==true)
		{

			Ele.click();
		}

		return true;
	}


	public void docUpload(WebElement Ele,String filepath,WebElement EleTwo) throws AWTException, InterruptedException
	{
		Ele.click();
		Thread.sleep(3000);
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		EleTwo.click();

	}


	public boolean isDisabled(WebElement Ele,WebElement EleTwo,WebElement EleThree,WebElement EleFour,String Text)
	{
		boolean buttonEna=Ele.isEnabled();
		System.out.println(buttonEna);
		if(buttonEna==false)
		{
			Actions action = new Actions(driver); 

			action.moveToElement(EleTwo).perform();

			EleTwo.click();
			action.moveToElement(EleThree).perform();
			EleThree.click();
			EleFour.click();
			EleFour.sendKeys(Text);
					
		}
		return true;

	}

	public void polDetExcel(String sheetname,int row,int col,String TextOne,int colTwo,String TextTwo) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\PolicyDetailsWidgetData.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		//String sheetname="excelsheetname";
		XSSFSheet sheet1 = wkb.getSheet(sheetname);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\PolicyDetailsWidgetData.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();


		/*
	 FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 

		XSSFWorkbook wkb = new XSSFWorkbook();      
		XSSFSheet sheet1 = wkb.createSheet("DataStorage");  	
		sheet1.createRow(0);
		sheet1.getRow(0).createCell(0).setCellValue("Hi");
		sheet1.getRow(0).createCell(1).setCellValue("hello");
		sheet1.createRow(1);
		sheet1.getRow(1).createCell(0).setCellValue("buddy");
		sheet1.getRow(1).createCell(1).setCellValue("bujji");
		wkb.write(fos1);
		wkb.close();


		 */

	}
	public void polBillExcel(int row,int col,String TextOne,int colTwo,String TextTwo) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\TestOne.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		String billing="BillingDetails";
		XSSFSheet sheet1 = wkb.getSheet(billing);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\TestOne.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();


	}
	public void windowAlertAccept()
	{
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	}

	public static List<String> WebelementToString(List<WebElement>elementList){
		List<String> stringList =new ArrayList<String>();
		for(WebElement element : elementList)
		{
			stringList.add(element.getText().toString());
			System.out.println(element.getText());
		}

		return stringList;

	}

	public void relPolicyRoles(int row,int col,String TextOne,int colTwo,String TextTwo) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\TestOne.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		String billing="PolicyRoles";
		XSSFSheet sheet1 = wkb.getSheet(billing);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\TestOne.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();


	}


	public void FinHistory(String sheetname,int row,int col,String TextOne,int colTwo,String TextTwo,int colThree,String TextThree,int colFour,String TextFour,int colFive,String TextFive) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\FinancialHistory.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		//String sheetname="excelsheetname";
		XSSFSheet sheet1 = wkb.getSheet(sheetname);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		sheet1.getRow(row).createCell(colThree).setCellValue(TextThree);
		sheet1.getRow(row).createCell(colFour).setCellValue(TextFour);
		sheet1.getRow(row).createCell(colFive).setCellValue(TextFive);


		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\FinancialHistory.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();
	}

	//Customer Identity
	public void CustomerIdentityExcel(String sheetname,int row,int col,String TextOne,int colTwo,String TextTwo) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\CustomerIdentity.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		//String sheetname="excelsheetname";
		XSSFSheet sheet1 = wkb.getSheet(sheetname);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\CustomerIdentity.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();





	}


	//workreq

	public void workReqExcel(String sheetname,int row,int col,String TextOne,int colTwo,String TextTwo) throws IOException
	{

		String excelpath="C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\workrequests.xlsx";
		//FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Downloads\\TestOne.xlsx"); 
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wkb = new XSSFWorkbook(fis);  
		//String sheetname="excelsheetname";
		XSSFSheet sheet1 = wkb.getSheet(sheetname);
		sheet1.createRow(row);  
		sheet1.getRow(row).createCell(col).setCellValue(TextOne);
		sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);

		//sheet1.getRow(row).createCell(colTwo).setCellValue(TextTwo);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sreddy353\\Selenium-Automation-Testing\\CsrPanoFunctionality\\Excel-Data-Output\\workrequests.xlsx");
		fos1.flush();     
		wkb.write(fos1);     
		fos1.close();
		wkb.close();





	}

	public boolean workCmpltSta(WebElement ele,WebElement eleTwo)
	{

		String workReqName= eleTwo.getText();
		boolean workCmpltStaChk=ele.isEnabled();
		System.out.println(workCmpltStaChk);
		if(workCmpltStaChk==false)
		{
			System.out.println("Work Completed button should be disabled"+ workReqName);
		}
		return false;
	}

	public boolean worknotCmpltSta(WebElement ele,WebElement eleTwo)
	{

		String workReqName= eleTwo.getText();
		boolean workCmpltStaChk=ele.isEnabled();
		System.out.println(workCmpltStaChk);
		if(workCmpltStaChk==true)
		{
			ele.click();
			System.out.println("Work not Completed button should be enabled"+ workReqName);
		}
		return false;
	}
	
	
		

}

