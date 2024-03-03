package ebayAndroidAutomation.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import ebayAndroidAutomation.base.BaseClass;
import ebayAndroidAutomation.config.DriverManager;
import ebayAndroidAutomation.reportManager.ExtentTestManager;
import ebayAndroidAutomation.utility.ScreenShotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener extends BaseClass implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = ExtentTestManager.createExtentTest(iTestResult.getName());
        test.info(iTestResult.getName()+" -----> Test Started");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.pass(iTestResult.getName()+" -----> Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
       test.fail(iTestResult.getName()+" -----> Test Failed");

        try {
            test.addScreenCaptureFromPath(ScreenShotUtil.capscreen(DriverManager.getDriverInstance())).getModel().getScreenCaptureList().get(0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.skip(iTestResult.getName()+" -----> Test Skipped");
        try {
            test.addScreenCaptureFromPath(ScreenShotUtil.capscreen(DriverManager.getDriverInstance())).getModel().getScreenCaptureList().get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        test.fail(iTestResult.getName()+" -----> Test Failed");
        try {
            test.addScreenCaptureFromPath(ScreenShotUtil.capscreen(DriverManager.getDriverInstance())).getModel().getScreenCaptureList().get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
