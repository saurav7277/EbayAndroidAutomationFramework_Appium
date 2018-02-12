package ebayAndroidAutomation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;


public class BaseClass {
    public AppiumDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    @BeforeClass
    public void setup(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Mac Sierra");
        extent.setSystemInfo("Host Name", "Suraj");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Suraj Salunkhe");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        try {
            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print("Unhandled Exception"+e.getMessage());
        }
    }
    @AfterClass
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
    public void tearDown()
    {
        driver.quit();
        extent.flush();
    }


}
