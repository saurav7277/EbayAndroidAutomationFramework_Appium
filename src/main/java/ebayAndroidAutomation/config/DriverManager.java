package ebayAndroidAutomation.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    public static AppiumDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;

    public static AppiumDriver getDriver() throws IOException {
        input = new FileInputStream("property/android.properties");
        prop.load(input);
        if (prop.getProperty("platform").equalsIgnoreCase("android")) {
            androidSetup();
        } else {
            if (prop.getProperty("platform").equalsIgnoreCase("ios")) {
                iosSetup();
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static AppiumDriver androidSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ZY223B3P74");
        caps.setCapability("app", System.getProperty("user.dir") + "/build/com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
        caps.setCapability("package", "com.ebay.mobile");
        caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,
                "com.ebay.mobile.activities.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    public static AppiumDriver iosSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "");
        caps.setCapability("platformVersion", "9.2");
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }


}
