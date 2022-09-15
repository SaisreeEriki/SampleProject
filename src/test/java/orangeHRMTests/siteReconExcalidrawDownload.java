package orangeHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import orangeHRMPages.OrangeHRMLoginPage;
import orangeHRMProcesses.OrangeHRMLoginProcess;

public class siteReconExcalidrawDownload {

	WebDriver driver;
	
	OrangeHRMLoginProcess orangeHRMLoginProcess = new OrangeHRMLoginProcess(driver);
	
	@BeforeTest
	public void brwsrLaunch() {
		System.setProperty("webdriver.chrome.driver", "E:\\java-2022-03\\WebDriversZipFiles\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://excalidraw.com/");
	}
	
	@Test(priority = 0)
	public void loginWithValidCredentials() throws Exception {
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(OrangeHRMLoginPage.rectangle).click().build().perform();
		Thread.sleep(3000);
		WebElement canvasElement = OrangeHRMLoginPage.canvas;
		actions.moveToElement(canvasElement, 10, 10).clickAndHold().moveByOffset(300, 80).release().build().perform();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void exportTheImage() throws Exception {
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(OrangeHRMLoginPage.exportButton).click().build().perform();
		Thread.sleep(3000);
		actions.moveToElement(OrangeHRMLoginPage.saveFile).click().build().perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\hp\\OneDrive\\Desktop\\FileDownload.exe");
		Thread.sleep(5000);
		
	}
	
	
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
