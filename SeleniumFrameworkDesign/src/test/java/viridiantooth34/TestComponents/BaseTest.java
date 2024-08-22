package viridiantooth34.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import viridiantooth34.Utilities.Utilities;
import viridiantooth34.pageobjects.LoginPage;

public class BaseTest {

	// private static final String LoginPage = null;

	public static WebDriver driver;

	@BeforeTest(alwaysRun=true)
	public void setUp() throws IOException {

		Utilities utility = new Utilities();
		if(utility.getValue("browser").equalsIgnoreCase("")) {
			System.out.println("Invalid Browser");
			driver.quit();
			
		}
		else if (utility.getValue("browser").equalsIgnoreCase("chrome")) {

//			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (utility.getValue("browser").equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		} 

		driver.manage().window().maximize();

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.get(utility.getValue("url"));

		// LoginPage loginpage = new LoginPage(driver);
		//loginpage.goTo(url);

	}

	@AfterTest(alwaysRun=true)
	public void tearDown() {

		driver.quit();

	}

}
