package testRunner;

import static io.cucumber.junit.platform.engine.Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
	@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features/DataDrivenLogIn.feature"), // Feature file path
	//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features/Registration.feature," + "classpath:features/Login.feature"), // Multiple feature files
	//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features"), // All feature files in the features folder
	@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinitions"), // Your step definitions package
	@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:reports/cucumber-reports/MyReport.html," +  
																"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"),  // Reporting plugins
	@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false"), // Set to "false" to run tests, "true" to check mappings
	@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true"), // Disable ANSI colors in console output
	@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true"), // Enable publishing of reports
	//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression or @sanity"), // Tags to include/exclude
	//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@sanity")
	//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression")
	//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@sanity and @regression")
	//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@sanity and not @regression")
	@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@dataDriven")
})
public class TestRunner {

}
