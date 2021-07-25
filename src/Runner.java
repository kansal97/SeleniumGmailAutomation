import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import pages.GmailLoginPage;
import utils.ReadPropertiesFile;

public class Runner {
	static WebDriver driver;
	private final static String urlToChromeDriver = System.getProperty("user.dir") + "/chromedriver";
	static ReadPropertiesFile props;

	public static void main(String[] args) {
		// Set driver property
		System.setProperty("webdriver.chrome.driver", urlToChromeDriver);
		System.out.println("Driver set to: " + urlToChromeDriver);

		driver = new ChromeDriver();
		props = new ReadPropertiesFile();

		driver.navigate().to(props.getURL());

		GmailLoginPage loginTest = new GmailLoginPage(driver);
		loginTest.loginToGmail(props.getUsername(), props.getPassword());

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		if (driver != null) { 
			// Close browser 
			driver.close(); 
			// Kill driver
			driver.quit();
		}

	}
}
