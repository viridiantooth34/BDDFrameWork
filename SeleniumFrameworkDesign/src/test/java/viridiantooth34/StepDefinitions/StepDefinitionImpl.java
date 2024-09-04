package viridiantooth34.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import viridiantooth34.CommonMethods.CommonMethods_;
import viridiantooth34.TestComponents.BaseTest;
import viridiantooth34.Utilities.Utilities;
import viridiantooth34.pageobjects.CartPage;
import viridiantooth34.pageobjects.ConfirmationPage;
import viridiantooth34.pageobjects.LoginPage;
import viridiantooth34.pageobjects.PaymentPage;
import viridiantooth34.pageobjects.ProductPage;

public class StepDefinitionImpl extends BaseTest {

//	WebDriver driver;
	public Utilities utility;
	public LoginPage loginPage;
	public ProductPage productPage;
	public CartPage cartPage;
	public PaymentPage paymentPage;
	public ConfirmationPage confirmationPage;
	public CommonMethods_ commonMethods;

	@Given("I landed on Eccommerce Page")
	public void I_landed_on_Eccommerce_Page() throws IOException {

		setUp();
		// code
	}

	@Given("^Given Logged in with username (.+) and password (.+)$")
	public void Given_Logged_in_with_username_and_password(String name, String pass) throws IOException {
		CommonMethods_ commonMethods = PageFactory.initElements(driver, CommonMethods_.class);
		Utilities utility = new Utilities();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
		PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);

		loginPage.enterCredentials(name, pass);
		loginPage.clickLoginBtn();
	}

	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) {
		productPage.selectProduct(productName);

		commonMethods.goToCartPage();
		Assert.assertTrue(cartPage.isProductExistsInCart(productName), productName + " is not present in the Cart");

	}

	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) {
		cartPage.clickCheckoutBtn();

		paymentPage.selectCountry("India");
		paymentPage.ClickplaceOrderbtn();
	}

	@Then("{string} message is displayed on ConfirmtionPage")
	public void message_is_displayed_on_ConfirmtionPage(String string) {
		Assert.assertEquals(confirmationPage.getConfirmation(), "THANKYOU FOR THE ORDER._", "Order was not placed!");

	}

}
