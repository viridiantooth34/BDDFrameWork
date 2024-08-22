package viridiantooth34.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import viridiantooth34.CommonMethods.CommonMethods_;
import viridiantooth34.TestComponents.BaseTest;
import viridiantooth34.Utilities.Utilities;
import viridiantooth34.pageobjects.*;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StandAloneTest extends BaseTest {

	@Test
	public void mainTest() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// Creating reference variables for Utilities class

		Utilities utility = new Utilities();
		// Creating reference variables for Page Objects
		CommonMethods_ commonMethods = PageFactory.initElements(driver, CommonMethods_.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
		PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);

		String productName = "ZARA COAT 3";

//		
		System.out.println(utility.getValue("url"));
		loginPage.enterCredentials(utility.getValue("userid"), utility.getValue("password"));
		loginPage.clickLoginBtn();
		
		

		productPage.selectProduct("ZARA COAT 3");

		commonMethods.goToCartPage();
		// Assertion if the product name is present in the cart
		Assert.assertTrue(cartPage.isProductExistsInCart(productName), productName + " is not present in the Cart");

		cartPage.clickCheckoutBtn();

		paymentPage.selectCountry("India");
		paymentPage.ClickplaceOrderbtn();

		Assert.assertEquals(confirmationPage.getConfirmation(), "THANKYOU FOR THE ORDER.", "Order was not placed!");

	}

	@Test(dataProvider = "getData")
	public void ocheckDataProvider(String productName) {
		System.out.println(productName);

	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "ZARA COAT 3" }, { "ADIDAS ORIGINAL" }, { "IPHONE 13 PRO" } };
	}

}
