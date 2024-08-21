package viridiantooth34.pageobjects;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethods.CommonMethods_;

public class CartPage extends CommonMethods_ {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	By productBlockXpath = By.xpath("//div[@class='cartSection']//h3");
	
	@FindBy(how = How.XPATH, using = "//div[@class='cartSection']//h3")
	WebElement productBlock;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Checkout']")
	WebElement checkoutBtn;
	
	
	public boolean isProductExistsInCart(String productName) {
		
		waitForElementToAppear(productBlockXpath);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']//h3")));

		System.out.println(driver.findElement(By.xpath("//div[@class='cartSection']//h3")).getText());
		List<WebElement> cartProductList = driver.findElements(productBlockXpath);
		
		boolean isProductPresentInCart = cartProductList.stream()
				.anyMatch(cartProduct -> cartProduct.getText().trim().equalsIgnoreCase(productName));

		
		return isProductPresentInCart;
	}
	
	public void clickCheckoutBtn() {
//////////Click on Checkout btn:

		checkoutBtn.click();
	}

}
