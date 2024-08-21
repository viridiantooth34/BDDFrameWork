package viridiantooth34;

import io.github.bonigarcia.wdm.WebDriverManager;
import viridiantooth34.pageobjects.CartPage;
import viridiantooth34.pageobjects.LoginPage;
import viridiantooth34.pageobjects.ProductPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommonMethods.CommonMethods_;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Commenting WebdriverManager for Chrome Version Mismatch
		// WebDriverManager.chromedriver().setup();

		// Adding WebDriver Path:
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String productName = "ZARA COAT 3";

		// Creating reference variables for Page Objects
		CommonMethods_ commonMethods = PageFactory.initElements(driver, CommonMethods_.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

		loginPage.goTo("https://rahulshettyacademy.com/client");
		loginPage.enterCredentials("rick.bakshi@gmail.com", "Fortminor1!");
		loginPage.clickLoginBtn();

		productPage.selectProduct("ZARA COAT 3");

		commonMethods.goToCartPage();
		// Assertion if the productname is present in the cart
		Assert.assertTrue(cartPage.isProductExistsInCart(productName), productName + " is not present in the Cart");

		////////// Click on Checkout btn:
		cartPage.clickCheckoutBtn();

		/////////////////////////////////////////////
		///////// Select Country:

		// driver.findElement(By.xpath("//input[@placeholder='Select
		// Country']")).sendKeys("india");

		// Action Class
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India");
		act.build().perform();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='
		// India']")));
		driver.findElement(By.xpath("//span[text()=' India']")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

		// driver.quit();

		Assert.assertEquals(driver.findElement(By.xpath(" //h1[text()=' Thankyou for the order. ']")).getText().trim(),
				"Thankyou for the order.", "Order was not placed!");

	}
}
