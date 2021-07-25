package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertiesFile {
	private Properties props;
	private final static String propertiesFileUrl = System.getProperty("user.dir") + "/src/config.properties";

	public ReadPropertiesFile() {
		props = new Properties();
		try {
			FileInputStream fip = new FileInputStream(propertiesFileUrl);
			props.load(fip);
		} catch (FileNotFoundException e) {
			System.err.println("Properties File not found, please check the file path");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Other exception: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public String getURL() {
		return props.getProperty("url");
	}

	public String getUsername() {
		return props.getProperty("username");
	}

	public String getPassword() {
		return props.getProperty("password");
	}
}
