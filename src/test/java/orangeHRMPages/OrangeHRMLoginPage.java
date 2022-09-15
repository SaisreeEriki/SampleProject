package orangeHRMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
	WebDriver driver;
	
	public static @FindBy (id = "txtUsername")
	WebElement userNameField;
	
	public static @FindBy (id = "txtPassword")
	WebElement passwordField;
	
	public static @FindBy (id = "btnLogin")
	WebElement loginButton;
	
	public static @FindBy (xpath = "//label[@title='Rectangle — R or 2']")
	WebElement rectangle;
	
	public static @FindBy (xpath = "//canvas[@class='excalidraw__canvas']")
	WebElement canvas;
	
	public static @FindBy (xpath = "//button[@data-testid='clear-canvas-button']")
	WebElement deleteButton;
	
	public static @FindBy (xpath = "//button[@title='Confirm']")
	WebElement confirmButton;
	
	public static @FindBy (xpath = "//button[@title='Export']")
	WebElement exportButton;
	
	public static @FindBy (xpath = "//button[@title='Save to file']")
	WebElement saveFile;
	
	public static @FindBy (xpath = "//label[@title='Selection — V or 1']")
	WebElement selectionButton;
	
	public static @FindBy (xpath = "//label[@title='Keep selected tool active after drawing — Q']")
	WebElement selectedToolActive;
	
	public static @FindBy (xpath = "//label[@title='Sharp']")
	WebElement sharpButton;
	
	 public OrangeHRMLoginPage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 public void clickOnElement(WebElement referenceElement) throws Exception {
			Actions actions = new Actions(driver);
			actions.moveToElement(referenceElement).click().build().perform();
			Thread.sleep(3000);
		}

}
