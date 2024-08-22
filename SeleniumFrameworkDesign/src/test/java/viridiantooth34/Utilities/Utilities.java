package viridiantooth34.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Utilities {

	public static Properties prop;
	public static FileInputStream fis;

	public String getValue(String key) throws IOException {

		prop = new Properties();
		fis = new FileInputStream("src\\main\\java\\viridiantooth34\\resources\\globalData.properties");
		prop.load(fis);

		return prop.getProperty(key);

	}

	@SuppressWarnings("deprecation")
	public void takeFullScreenShot(WebDriver driver) {

		// System.out.println(Double.toString(System.currentTimeMillis()));
		String screenshot_name = Double.toString(System.currentTimeMillis());
		Shutterbug.shootPage(driver, Capture.FULL, true).withName(screenshot_name).save("Screenshots\\");
	}
}
