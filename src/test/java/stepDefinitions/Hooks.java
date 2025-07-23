package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class Hooks {
	@Before
	public void setUp() {
		ConfigReader.loadProperties("config.properties");
		BaseClass.initialization();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ScreenshotUtil.captureScreenshot(BaseClass.getDriver(), scenario.getName());
		}
		BaseClass.quitDriver();
	}
}
