package ebayAndroidAutomation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;


public class BaseClass {
    public AppiumDriver driver;
    public ExtentReports reports;
    public ExtentTest elog;


    @BeforeClass
    public void setup(){
        try {

            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print("Unhandled Exception"+e.getMessage());
        }
    }

}
