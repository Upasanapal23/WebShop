package listeners;

import base.BaseClass;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (BaseClass.getDriver() == null) {
            System.out.println("WebDriver is null. Cannot capture screenshot.");
            return;
        }



        String testName = result.getMethod().getMethodName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        try {
            File srcFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + testName + "_" + timestamp + ".png");
            FileUtils.copyFile(srcFile, destFile);

            // Allure attachment
            ByteArrayInputStream stream = new ByteArrayInputStream(
                    ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES)
            );
            Allure.addAttachment("Failure Screenshot: " + testName, stream);

        } catch (Exception e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }
    }
}