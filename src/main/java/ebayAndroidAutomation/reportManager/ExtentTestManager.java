package ebayAndroidAutomation.reportManager;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    public static ExtentTest test;

    public static ExtentTest createExtentTest(String testName){
        test = ExtentManager.getInstance().createTest(testName);
        return test;
    }

    public static ExtentTest getTest(){
        return test;
    }
}
