package viridiantooth34.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethods.CommonMethods_;

public class PaymentPage extends CommonMethods_ {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(how = How.XPATH, using = "//a[text()='Place Order ']")
	WebElement placeOrderBtn;

	By countryXpath = By.xpath("//span[text()=' India']");

	public void selectCountry() {
		country.sendKeys("India");

		waitForElementToAppear(countryXpath);
		driver.findElement(countryXpath).click();
	}

	public void ClickplaceOrderbtn() {

		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	}

}
