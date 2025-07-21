package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        try {
            // Sanitize filename (remove special characters, make cross-platform safe)
            String safeName = scenarioName.replaceAll("[^a-zA-Z0-9_-]", "_");

            // Timestamp for uniqueness
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Screenshot folder
            File screenshotsDir = new File("screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdir();
            }

            // Full path with timestamp
            String fullFileName = safeName + "_" + timestamp + ".png";
            File destFile = new File(screenshotsDir, fullFileName);

            // Capture and save
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, destFile);

            // Attach to Allure
            Allure.addAttachment("Screenshot - " + safeName,
                    new FileInputStream(destFile));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}
