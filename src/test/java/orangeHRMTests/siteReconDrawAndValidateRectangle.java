package orangeHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import orangeHRMPages.OrangeHRMLoginPage;
import orangeHRMProcesses.OrangeHRMLoginProcess;

public class siteReconDrawAndValidateRectangle {

	WebDriver driver;
	
	OrangeHRMLoginProcess orangeHRMLoginProcess = new OrangeHRMLoginProcess(driver);
	
	@BeforeTest
	public void brwsrLaunch() {
		System.setProperty("webdriver.chrome.driver", "E:\\java-2022-03\\WebDriversZipFiles\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://excalidraw.com/");
	}
	
	@Test(priority = 0)
	public void loginWithValidCredentials() throws Exception {
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
		Actions actions = new Actions(driver);
		orangeHRMLoginPage.clickOnElement(OrangeHRMLoginPage.rectangle);
		WebElement canvasElement = OrangeHRMLoginPage.canvas;
		actions.moveToElement(canvasElement, 10, 10).clickAndHold().moveByOffset(300, 80).release().build().perform();
	}
	
	@Test(priority = 1)	
	public void verifyTheResctangleDrawn() throws Exception {
		OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
		Actions actions = new Actions(driver);
		WebElement canvasElement = OrangeHRMLoginPage.canvas;
		orangeHRMLoginPage.clickOnElement(OrangeHRMLoginPage.selectedToolActive);
		orangeHRMLoginPage.clickOnElement(OrangeHRMLoginPage.selectionButton);
		actions.moveToElement(canvasElement, 10, 10).click().build().perform();
		Boolean verifyRectangle = (OrangeHRMLoginPage.sharpButton).isDisplayed();
		if(verifyRectangle) {
			Assert.assertTrue(true, "Rectangle is displayed");
			System.out.println("The Drawn rectangle is displayed in the white board of \"Canvas\". ");
		}
		else {
			Assert.assertTrue(false, "Rectangle is not displayed");
			System.out.println("The Drawn rectangle is not displayed in the white board of \"Canvas\". ");
		}
	}
	
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
