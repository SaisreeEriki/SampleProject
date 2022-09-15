package objects;

import java.security.PublicKey;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripLoginPage {

	WebDriver driver;
	
	public static @FindBy (xpath = "//li[@data-cy='account']")
	WebElement makemyTripLogin;
	
	public static @FindBy (id = "username")
	WebElement userNameTextBox;
	
	public static @FindBy (xpath = "//button[@data-cy='continueBtn']/span")
	WebElement continueButton;
	
	public static @FindBy (xpath = "//input[@data-cy='enterOtp']")
	WebElement enterOTP;
	
	public static @FindBy (xpath = "//button[@data-cy='verifyAndCreate']")
	WebElement verifyAndCreate;
	
	 public MakeMyTripLoginPage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	
	public void setTextValue(WebElement referenmceElement, String textString) {
		referenmceElement.sendKeys(textString);
	}
	
	public String getTextBoxValue(WebElement referenceElement) {
		String text = referenceElement.getText();
		return text;
	}
	
	public void loginAccount(WebElement referenceElement) {
		referenceElement.click();
	}
	
	public void clickButton(WebElement referenceElement) {
		referenceElement.click();
	}
	public void setScreen () {
		Actions actions = new Actions(driver);
		actions.click();
	}
	public void hoverAndClick(WebElement referenceElement) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}
	
}
