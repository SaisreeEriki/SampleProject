package orangeHRMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteReconAutomation {
	WebDriver driver;
	
	public static @FindBy (xpath = "//*[@id='root']/div/div/div[1]/div/div/section/div/div/div/div[2]/label[2]/div/svg/path")
	WebElement rectangle;
	
	 public SiteReconAutomation(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 public void selectTool(WebElement referenceElement) {
			referenceElement.click();
		}

}
