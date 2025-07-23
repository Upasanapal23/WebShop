package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	public static void loadProperties(String fileName) {
		try {
			FileInputStream fis = new FileInputStream("src/test/java/resources/" + fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}
