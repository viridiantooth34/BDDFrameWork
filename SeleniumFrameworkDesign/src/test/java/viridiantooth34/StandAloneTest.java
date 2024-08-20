package viridiantooth34;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		// Commenting WebdriverManager for Chrome Version Mismatch
		// WebDriverManager.chromedriver().setup();

		// Adding WebDriver Path:
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("rick.bakshi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Fortminor1!");
		driver.findElement(By.id("login")).click();
		// Storing the product names in an List:
		String xPathBlock = "//div[@class='card']";
		List<WebElement> products = driver.findElements(By.xpath(xPathBlock));

		System.out.println("Count of Products=" + products.size());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card']//b)[1]")));
		int indexOfxPath = 0;
		int flag = 0;
		// ProductName
		String productName = "ZARA COAT 3";
		//// Adding Product To cart////////////////
		for (int i = 0; i < products.size(); i++) {

//			
			if (driver.findElement(By.xpath("(" + xPathBlock + "//b)[" + (i + 1) + "]")).getText().trim()
					.equalsIgnoreCase(productName)) {
				
				indexOfxPath = i;
				flag++;
				break;
			}
		}

		// Getting the index of Zara Coat:

		Thread.sleep(500);

		driver.findElement(By.xpath("(" + xPathBlock + "//button[text()=' Add To Cart'])[" + (indexOfxPath + 1) + "]"))
				.click();
		Thread.sleep(2000);

		// Explicit Wait to capture the verification msg after adding the product to the
		// cart

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(By.id("toast-container")).getText();
		
		
		// =========================================

		//// Clicking on Cart Button////////////////
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My Cart']")));
		
		//div[@class='cartSection']//h3
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']//h3")));
		System.out.println(driver.findElement(By.xpath("//div[@class='cartSection']//h3")).getText());
		List<WebElement> cartProductList = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		System.out.println(cartProductList.get(0).getText());
		boolean isProductPresentInCart = cartProductList.stream().anyMatch(cartProduct-> cartProduct.getText().trim().equalsIgnoreCase(productName));
		
		Assert.assertTrue(isProductPresentInCart, productName+" is not present in the Cart");
		
		//driver.quit();
		
		
		//driver.quit();
	}
}
