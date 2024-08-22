package viridiantooth34.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import viridiantooth34.CommonMethods.CommonMethods_;
import viridiantooth34.TestComponents.BaseTest;
import viridiantooth34.Utilities.Utilities;
import viridiantooth34.pageobjects.CartPage;
import viridiantooth34.pageobjects.ConfirmationPage;
import viridiantooth34.pageobjects.LoginPage;
import viridiantooth34.pageobjects.PaymentPage;
import viridiantooth34.pageobjects.ProductPage;

public class ErrorValidationTest extends BaseTest{
	@Test
	public void NegativeTest() throws IOException, InterruptedException {
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

		loginPage.goTo(utility.getValue("url"));
		loginPage.enterCredentials(utility.getValue("userid"), "sahdjghjg");
		loginPage.clickLoginBtn();
		// String classname="ng-tns-c4-6 toast-message ng-star-inserted";
		System.out.println(loginPage.errorMsg());

		Assert.assertEquals(loginPage.errorMsg().trim(), "Incorrect email or password.", "ErrorMsg is Incorrect");

	}
}
