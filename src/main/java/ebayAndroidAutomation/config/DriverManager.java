package ebayAndroidAutomation.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    public static AndroidDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;
    static Logger logger = Logger.getLogger(DriverManager.class);


    public static AndroidDriver getDriver() throws IOException {
//        input = new FileInputStream("src/main/resources/config.properties");
//        prop.load(input);
//        if (prop.getProperty("platformName").equalsIgnoreCase("Android")) {
//            logger.info("Device property found for Android ");
//            AdbManager adbdriver=new AdbManager(prop.getProperty("DeviceID"));
//            boolean result=adbdriver.isAppAlradyInstalled(prop.getProperty("Package"));
//            if(result==true){
//                logger.info("App is alredy installed clearing content");
//                adbdriver.clearAppsData(prop.getProperty("Package"));
//            }
//            else{
//                adbdriver.installApp(prop.getProperty("AppPath"),prop.getProperty("Package"));
//                try {
//                    Thread.sleep(15000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                logger.info("App Installed Succesfully");
//            }
//            androidSetup();
//
//        }
        androidSetup();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver androidSetup() throws MalformedURLException {
        logger.info("Setting Android Driver");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("appium:deviceName", prop.getProperty("deviceName"));
//        caps.setCapability("platformName", prop.getProperty("platformName"));
//        caps.setCapability("appium:platformVersion", prop.getProperty("platformVersion"));
//        caps.setCapability("appium:app", prop.getProperty("AppPath"));
//        caps.setCapability("avd", prop.getProperty("avd"));
//        caps.setCapability("appPackage", prop.getProperty("Package"));
//        caps.setCapability("appActivity", prop.getProperty("Activity"));
//        caps.setCapability("appium:automationName", prop.getProperty("automationName"));
//        caps.setCapability("newCommandTimeout", 10000);
//        caps.setCapability("udid" , prop.getProperty("DeviceID"));
//        MutableCapabilities capabilities = new UiAutomator2Options();
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        String userName = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
        String app = System.getenv("BROWSERSTACK_APP_ID");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", app);
        caps.setCapability("device", "Samsung Galaxy S8");
        caps.setCapability("build", buildName);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        logger.info("Android Driver set succesfully");
        return driver;
    }

    public static AndroidDriver getDriverInstance(){
        return driver;
    }

}
