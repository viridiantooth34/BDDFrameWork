package viridiantooth34;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("rick.bakshi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Fortminor1!");
		driver.findElement(By.id("login")).click();
		// Storing the product names in an List:
		String xPathBlock = "//div[@class='card']";
		List<WebElement> products = driver.findElements(By.xpath(xPathBlock));

		System.out.println("Count of Products=" + products.size());

		Thread.sleep(500);
		int indexOfxPath = 0;
		int flag = 0;
		// ProductName
		String productName = "ZARA COAT 3";

		for (int i = 0; i < products.size(); i++) {

//			System.out
//					.println(driver.findElement(By.xpath("(" + xPathBlock + "//b)[" + (i + 1) + "]")).getText().trim());
			if (driver.findElement(By.xpath("(" + xPathBlock + "//b)[" + (i + 1) + "]")).getText().trim()
					.equalsIgnoreCase(productName)) {

				indexOfxPath = i;
				flag++;
				break;
			}
		}

		// Getting the index of Zara Coat:

		Thread.sleep(500);
		// System.out.println(driver.findElement(By.xpath("(//div[@class='card']//b)[1]")).getText());
		

		if (flag == 0) {
			System.out.println(productName + " is not Present\nClosing Windows....");
			driver.quit();
		} else {
			driver.findElement(By.xpath("(" + xPathBlock + "//button[text()=' Add To Cart'])[" + (indexOfxPath + 1) + "]"))
					.click();
			Thread.sleep(2000);
			System.out.println("Clicked on: "+productName); 
			driver.quit();
			
			
			
		}

	}
}
