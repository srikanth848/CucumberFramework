package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public static WebDriver initializeDriver() throws IOException, URISyntaxException {
		
		prop = getProperties();
		String browserName = prop.getProperty("browser");
		String os = prop.getProperty("os");
		String executionEnvironment = prop.getProperty("executionEnvironment");
		
		if(executionEnvironment.equalsIgnoreCase("grid")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//OS selection	
			switch(os.toLowerCase()) {
			case "windows": capabilities.setPlatform(Platform.WINDOWS); break;
			case "mac": capabilities.setPlatform(Platform.MAC); break;
			case "linux": capabilities.setPlatform(Platform.LINUX); break;
			default: System.out.println("Invalid OS specified"); return null;
			}
			
			//Browser selection
			switch(browserName.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("Invalid browser specified"); return null;
			}
			
			driver = new RemoteWebDriver(new URI(prop.getProperty("hubURL")).toURL(), capabilities);
		}
		
		else if(executionEnvironment.equalsIgnoreCase("local")) {
			switch(browserName.toLowerCase()) {
			case "chrome": driver = new ChromeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			default: System.out.println("Invalid browser specified"); return null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
		return driver;
	}
	
	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
	
	public static Logger getLogger() {
		logger = LogManager.getLogger();
		return logger;
	}
	
	/*
	//Generate random alpha numeric string
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < length; i++) {
			int index = (int)(characters.length() * Math.random());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	*/
	
	public static String getRandomString(int length) {
	    String s = RandomStringUtils.secureStrong().nextAlphabetic(length);
	    return s;
	}
	
	public static String getRandomNumber(int length) {
	    String n = RandomStringUtils.secureStrong().nextNumeric(length);
	    return n;
	}
	
	public static String getRandomAlphaNumeric(int length) {
	    String an = RandomStringUtils.secureStrong().nextAlphanumeric(length);
	    return an;
	}

}
