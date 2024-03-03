package ebayAndroidAutomation.reportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ebayAndroidAutomation.utility.CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExtentManager {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public ExtentTest test;
    public static Properties prop = new Properties();
    static InputStream input = null;

    public static ExtentReports initExtentReport() throws IOException {
        input = new FileInputStream("src/main/resources/config.properties");
        prop.load(input);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/"+ CommonUtil.getCurrentDateAndTime() +".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", prop.getProperty("OS"));
        extent.setSystemInfo("Host Name", prop.getProperty("hostName"));
        extent.setSystemInfo("Environment", prop.getProperty("Environment"));
        extent.setSystemInfo("User Name", prop.getProperty("userName"));
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        return extent;
    }

    public static ExtentReports getInstance(){
        return extent;
    }
}
