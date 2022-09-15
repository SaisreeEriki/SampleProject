package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By googleSeachBox = By.xpath("//input[@name='q']");
	
	
	public void searchGoogle (String text) {
		driver.findElement(googleSeachBox).sendKeys(text);
	}
	public void clearText() {
		driver.findElement(googleSeachBox).clear();
	}
}
