package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.MakeMyTripLoginPage;

public class MakeMyTripLoginTest {

	WebDriver driver;
	
	@BeforeTest
	public void brwsrLaunch() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "E:\\java-2022-03\\WebDriversZipFiles\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test(priority = 0)
	public void loginWithValidCredentials() throws Exception {
		MakeMyTripLoginPage makeMyTripLoginPage = new MakeMyTripLoginPage(driver);
		makeMyTripLoginPage.loginAccount(MakeMyTripLoginPage.makemyTripLogin);
		Thread.sleep(2000);
		makeMyTripLoginPage.setScreen();
		makeMyTripLoginPage.loginAccount(MakeMyTripLoginPage.userNameTextBox);
		makeMyTripLoginPage.setTextValue(MakeMyTripLoginPage.userNameTextBox, "s@fdg.f");
		Thread.sleep(2000);
		boolean verifyExist = MakeMyTripLoginPage.continueButton.isEnabled();
		System.out.println(verifyExist);
		makeMyTripLoginPage.hoverAndClick(MakeMyTripLoginPage.continueButton);
		Thread.sleep(8000);
		System.out.println("done");
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
