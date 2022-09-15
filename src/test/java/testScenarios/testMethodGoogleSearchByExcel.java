package testScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.GoogleSearchPage;

//import com.google.common.collect.Table.Cell;

public class testMethodGoogleSearchByExcel {

	WebDriver driver;
//    WebDriverWait wait;
//    XSSFWorkbook workbook;
//    XSSFSheet sheet;
//    XSSFCell cell;
	
	@BeforeTest
	public void befortest() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "E:\\java-2022-03\\WebDriversZipFiles\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void readExcelFile() throws IOException, Exception {
/**=========using switch case=================
		File src=new File("E:\\java-2022-03\\Excel_data_sheets\\readDataSheet.xlsx");
		FileInputStream finput = new FileInputStream(src);
		 workbook = new XSSFWorkbook(finput);
		 sheet= workbook.getSheetAt(0);
		 
		 int rows = sheet.getLastRowNum();
	     int cols= sheet.getRow(1).getLastCellNum();
		 for(int r=0; r<rows; r++) {
		 Row row =sheet.getRow(r);
		 for(int c=0; c< cols; c++) {
			 Cell cell =row.getCell(0);
			 switch(cell.getCellType())
             {
             case STRING: System.out.println(cell.getStringCellValue());
             				break;
             case NUMERIC: System.out.println(cell.getNumericCellValue()); 
             				break;
             case BOOLEAN: System.out.println(cell.getBooleanCellValue());
             				break;
			default: System.out.println("Done");
				break;
             }
		 }
	
		 }
		 ==============================================**/
		
		FileInputStream FRead;
		FileOutputStream FWrite;
		XSSFWorkbook wb;
		XSSFSheet sh;
		String d1;
		
		String searchTxt;
		int rowvall,rowcount;
		
		/*File*/ FRead = new FileInputStream("E:\\java-2022-03\\Excel_data_sheets\\readDataSheet.xlsx");
		/*XSSFWorkbook*/ wb = new XSSFWorkbook(FRead);
		/*XSSFSheet*/ sh = wb.getSheet("SheetNoOne");
		
		d1=sh.getRow(0).getCell(0).getStringCellValue();
		rowcount=sh.getPhysicalNumberOfRows();
		
		for(rowvall=1; rowvall<rowcount; rowvall++) {
		searchTxt=sh.getRow(rowvall).getCell(0).getStringCellValue();
		
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchGoogle(searchTxt);
		Thread.sleep(2000);
		page.clearText();
		
		}
		
		 }
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
	}
	

