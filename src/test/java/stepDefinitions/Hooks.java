package stepDefinitions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	WebDriver driver;
	Properties prop;
	Logger logger;
	
	@Before
	public void setup() throws IOException, URISyntaxException {
		driver = BaseClass.initializeDriver();
		prop = BaseClass.getProperties();
		logger = BaseClass.getLogger();
		driver.get(prop.getProperty("applicationURL"));
		logger.info("Launching the application....");
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			logger.info("Closing the browser....");
			driver.quit();
		}
	}
	
	@AfterStep
	public void takeScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			logger.info("Taking screenshot for failed step....");
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}

}
