package sosTest.run;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import freemarker.template.utility.NullArgumentException;

public class DriverFactory {

	// final static String CONFIG_PROPERTIES_DIRECTORY =
	// "properties\\config.properties";

	final String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/mac/geckodriver";

	final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/mac/chromedriver";

	final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/resources/windows/IEDriverServer";

	public static WebDriver driver;
	// public static ContactUs_Page contactUsPage;
	// public static Products_Page productsPage;

	public WebDriver getDriver() {
		try {

			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/sosTest/config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");
			String osName = p.getProperty("OS");

			String gecko_driver_directory="";
			String chrome_driver_directory="";
			String ie_driver_directory="";
			
			switch (osName) {
				case "Windows":
					gecko_driver_directory = System.getProperty("user.dir") + "/resources/windows/geckodriver.exe";
					chrome_driver_directory = System.getProperty("user.dir") + "/resources/windows/chromedriver.exe";
					ie_driver_directory = System.getProperty("user.dir") + "/resources/windows/IEDriverServer.exe";
					System.out.println("Windowsturrrr");
				break;
				case "Mac":
					gecko_driver_directory = System.getProperty("user.dir") + "/resources/mac/geckodriver";
					chrome_driver_directory = System.getProperty("user.dir") + "/resources/mac/chromedriver";
					ie_driver_directory = System.getProperty("user.dir") + "/resources/mac/IEDriverServer";
					System.out.println(chrome_driver_directory);
				break;
			}

			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", gecko_driver_directory);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", chrome_driver_directory);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					// DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", ie_driver_directory);
					// capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		return driver;
	}
}
