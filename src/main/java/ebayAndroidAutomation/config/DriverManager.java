package ebayAndroidAutomation.config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
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
import org.apache.log4j.Logger;

public class DriverManager {


    public static AndroidDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;
    static Logger logger = Logger.getLogger(DriverManager.class);


    public static AndroidDriver getDriver() throws IOException {
        input = new FileInputStream("property/android.properties");
        prop.load(input);
        if (prop.getProperty("platform").equalsIgnoreCase("android")) {
            logger.info("Device property found for Android ");
            ADB adbdriver=new ADB(prop.getProperty("DeviceID"));
            logger.info("Checking is App already installed");
            boolean result=adbdriver.isAppAlradyInstalled(prop.getProperty("Package"));
            if(result==true){
                logger.info("App is alredy installed clearing content");
                adbdriver.clearAppsData(prop.getProperty("Package"));
            }
            else{
                logger.info("App was not installed on device. Installing App");
                adbdriver.installApp(System.getProperty("user.dir")+ "build/com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk",prop.getProperty("Package"));
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("App Installed Succesfully");
            }
            androidSetup();

        } else {
            if (prop.getProperty("platform").equalsIgnoreCase("ios")) {
                logger.info("Device property found for iOS ");
                //iosSetup();
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver androidSetup() throws MalformedURLException {
        logger.info("Setting Android Driver");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", prop.getProperty("DeviceID"));
        caps.setCapability("app", System.getProperty("user.dir") + "/build/com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
        caps.setCapability("package", "com.ebay.mobile");
        caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,
                "com.ebay.mobile.activities.MainActivity");
        caps.setCapability("newCommandTimeout", 10000);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        logger.info("Android Driver set succesfully");
        return driver;
    }
    /*public static AppiumDriver iosSetup() throws MalformedURLException {
        logger.info("Setting iOS Driver");
        DesiredCapabilities caps = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "");
        caps.setCapability("platformVersion", "9.2");
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        logger.info("iOS Driver set succesfully");
        return driver;
    }*/


}
