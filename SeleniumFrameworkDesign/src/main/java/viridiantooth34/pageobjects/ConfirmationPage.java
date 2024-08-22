package viridiantooth34.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethods.CommonMethods_;

public class ConfirmationPage extends CommonMethods_ {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	@FindBy(how=How.XPATH,using="//h1[text()=' Thankyou for the order. ']")
	WebElement confimrationMsg;
	
	By confirmationMsgXpath = By.xpath("//h1[text()=' Thankyou for the order. ']");
	
	public String getConfirmation() {
		
		waitForElementToAppear(confirmationMsgXpath);
		return confimrationMsg.getText().trim();
		
	}

}
