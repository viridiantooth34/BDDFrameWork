package viridiantooth34;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

	public static void main(String[] args) {
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

//		for (int i = 0; i < products.size(); i++) {
//
//			System.out.println(driver.findElement(By.xpath(xPathBlock + "//b")).getText().trim());
//		}
//		try {
//			
//		
//		WebElement prod = products.stream().filter(product->product.findElement(By.xpath("//b")).getText().trim().equals("ZARA COAT 3")).findFirst().orElse(null);
//		}
//		catch(Exception e) {
//			
//		}
		// prod.findElement(By.xpath("//*[text()=' Add To Cart']")).click();
		System.out.println(driver.findElement(By.xpath("(//div[@class='card']//b)[1]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("(//div[@class='card']//b)[1]")).getText());
		driver.quit();
	}

}
