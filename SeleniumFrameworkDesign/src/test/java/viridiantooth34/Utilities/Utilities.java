package viridiantooth34.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public static Properties prop;
	public static FileInputStream fis;

	public String getValue(String key) throws IOException {

		prop = new Properties();
		fis = new FileInputStream(
				"src\\main\\java\\viridiantooth34\\resources\\globalData.properties");
		prop.load(fis);

		return prop.getProperty(key);

	}
}
