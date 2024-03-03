package ebayAndroidAutomation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class ScreenShotUtil {
    public static String capscreen(WebDriver driver)
    {
        try {
            String base64Screenshot ="data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
            return base64Screenshot;
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot"+e.getMessage());
            return e.getMessage();
        }

    }
}

