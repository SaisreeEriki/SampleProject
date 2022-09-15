package orangeHRMProcesses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRMPages.OrangeHRMLoginPage;

public class OrangeHRMLoginProcess {
	WebDriver driver;
	
	 public OrangeHRMLoginProcess(WebDriver driver){

	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 
	 OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
	 public void clickOnElement(WebElement referenceElement) {
			Actions actions = new Actions(driver);
			actions.moveToElement(referenceElement).click().build().perform();
		}
	
	 public void setTextValue(WebElement referenmceElement, String textString) {
			referenmceElement.sendKeys(textString);
		}

}
