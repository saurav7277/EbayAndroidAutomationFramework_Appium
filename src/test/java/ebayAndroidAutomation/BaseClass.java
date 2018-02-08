package ebayAndroidAutomation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.log4j.Logger;


public class BaseClass {
    public AppiumDriver driver;
    public ExtentReports reports;
    public ExtentTest elog;
    Logger logger = Logger.getLogger(BaseClass.class);

    @BeforeClass
    public void setup(){
        try {
            logger.info("In Before class Starting execution");
            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print("Unhandled Exception"+e.getMessage());
        }
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
