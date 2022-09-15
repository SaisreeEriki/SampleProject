package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.GoogleSearchPage;

public class testMethodsGoogleSearch {
WebDriver driver;

	@BeforeTest
	public void befortest() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "E:\\java-2022-03\\WebDriversZipFiles\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	 @Test(dataProvider="text")
	public void searchOperation(String text) throws Exception {
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchGoogle(text);
		Thread.sleep(2000);
		page.clearText();
		
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@DataProvider(name="text")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "FaceBook"},
            { "Instagram"},
            { "Twitter"}
        };

    }
}
