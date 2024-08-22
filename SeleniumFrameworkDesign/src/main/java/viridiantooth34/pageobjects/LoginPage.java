package viridiantooth34.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import viridiantooth34.CommonMethods.CommonMethods_;

public class LoginPage extends CommonMethods_{

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	// WebElements of Login Page
	@FindBy(how = How.ID, using = "userEmail")
	WebElement emailId;

	@FindBy(how = How.ID, using = "userPassword")
	WebElement password;

	@FindBy(how = How.ID, using = "login")
	WebElement loginBtn;
	
	@FindBy(how=How.CLASS_NAME, using = "ng-star-inserted")
	WebElement errorMsgText;
	
	By errorMsgTextClass = By.className("ng-star-inserted");

	By loginBtnID = By.id("login");
	
	public void enterCredentials(String email, String pass) {
		emailId.sendKeys(email);
		password.sendKeys(pass);
	}

	public void goTo(String url) {

		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickLoginBtn() {
		waitForElementToAppear(loginBtnID);
		loginBtn.click();
		System.out.println("Logged in");
	}
	
	public String errorMsg() {
		
		waitForElementToAppear(errorMsgTextClass);
		return errorMsgText.getText().trim();
		
	}

}
