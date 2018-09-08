package sosTest.run;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverFactory {
	
	
	//final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";
	
	final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/src/test/java/resources/geckodriver";
	
	final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/src/test/java/resources/chromedriver";
	
	final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "/src/test/java/Koton/resources/IEDriverServer";
	
	public static WebDriver driver;
	//public static ContactUs_Page contactUsPage;
	//public static Products_Page productsPage;

	public WebDriver getDriver() {
		try {
			
			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/sosTest/config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");

			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", IE_DRIVER_DIRECTORY);
					//capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			//contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
			//productsPage = PageFactory.initElements(driver, Products_Page.class);
		}
		return driver;
	}
}
