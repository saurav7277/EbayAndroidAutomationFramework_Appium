package ebayAndroidAutomation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import ebayAndroidAutomation.config.DriverManager;
import ebayAndroidAutomation.reportManager.ExtentManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseClass {
    public AppiumDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public static Properties prop = new Properties();
    static InputStream input = null;

    @BeforeSuite
    public void setup() throws IOException {
        ExtentManager.initExtentReport();
        try {
            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print("Unhandled Exception"+e.getMessage());
        }
    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
        ExtentManager.getInstance().flush();
    }


}
