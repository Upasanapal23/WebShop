package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = System.getProperty("user.dir") + "/screenshots/" + name + "_" + timestamp + ".png";
            Files.copy(src, new File(filePath));
            return Files.toByteArray(src);  // Attach to Allure
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
