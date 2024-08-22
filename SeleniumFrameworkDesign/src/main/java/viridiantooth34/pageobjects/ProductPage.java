package viridiantooth34.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import viridiantooth34.CommonMethods.CommonMethods_;

public class ProductPage extends CommonMethods_ {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// Storing the product names in a List:
	String xPathBlock = "//div[@class='card']";

	@FindBy(how = How.XPATH, using = "//div[@class='card']")
	WebElement productBlock;

	@FindBy(how = How.ID, using = "toast-container")
	WebElement dynamicPopUp;



	public String selectProduct(String productName) {
		int indexOfxPath = 0;
		List<WebElement> products = driver.findElements(By.xpath(xPathBlock));
		// ProductName
		waitForElementToAppear((By.xpath(xPathBlock)));
		System.out.println(products.size());
		//// Adding Product To cart////////////////
		for (int i = 0; i < products.size(); i++) {

			waitForElementToAppear((By.xpath("(" + xPathBlock + "//b)[" + (i + 1) + "]")));
			if (driver.findElement(By.xpath("(" + xPathBlock + "//b)[" + (i + 1) + "]")).getText().trim()
					.equalsIgnoreCase(productName)) {

				indexOfxPath = i;

				break;
			}
		}

		// Getting the index of the Product:

		
		waitForElementToAppear(
				By.xpath("(" + xPathBlock + "//button[text()=' Add To Cart'])[" + (indexOfxPath + 1) + "]"));
		driver.findElement(By.xpath("(" + xPathBlock + "//button[text()=' Add To Cart'])[" + (indexOfxPath + 1) + "]"))
				.click();

		waitForElementToAppear(By.id("toast-container"));

		// Explicit Wait to capture the verification msg after adding the product to the
		// cart

		
		dynamicPopUp.getText();

		

		// =========================================

		return productName;
	}


}
