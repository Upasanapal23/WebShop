package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {
        BaseClass.initialization();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Format timestamp
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            // Make scenario name filename-safe
            String safeScenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_");

            // Capture screenshot
            ScreenshotUtil.takeScreenshot(BaseClass.getDriver(), safeScenarioName + "_" + timestamp);
        }

        BaseClass.quitDriver();
    }
}
