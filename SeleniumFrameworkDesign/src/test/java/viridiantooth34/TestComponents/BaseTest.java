package viridiantooth34.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import viridiantooth34.pageobjects.LoginPage;

public class BaseTest {

	// private static final String LoginPage = null;

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");

		// LoginPage loginpage = new LoginPage(driver);
		// loginpage.goTo(url);

	}

	@AfterTest
	public void tearDown() {
		

		driver.quit();

	}

}
