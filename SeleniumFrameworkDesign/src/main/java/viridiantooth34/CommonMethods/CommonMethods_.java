package viridiantooth34.CommonMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods_  {

	WebDriver driver;

	public CommonMethods_(WebDriver driver) {

		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void waitForElementToAppear(By findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));

	}

	@FindBy(how = How.XPATH, using = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;

	By cartBtnXpath = By.xpath("//button[@routerlink='/dashboard/cart']");

	public void goToCartPage() {
		waitForElementToAppear(cartBtnXpath);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cartBtn.click();
	}
}
