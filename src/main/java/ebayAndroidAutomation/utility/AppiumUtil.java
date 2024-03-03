package ebayAndroidAutomation.utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class AppiumUtil {
    public static AppiumDriver driver;
    static Logger logger = Logger.getLogger(AppiumUtil.class);

    public AppiumUtil(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitForPageToLoad(WebElement id) {
        logger.info("Waiting For element to load=" + id);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(id));
    }

    public static void ScrollToElement(AndroidDriver driver, String str)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().textContains(\""+str+"\"));"));

    }

    public static WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public static void scrollPageDownWithNoOfScroll(AndroidDriver driver, int noOfScroll) {
        for(int i=0; i<=noOfScroll; ++i){
            Dimension dimensions = driver.manage().window().getSize();
            double screenHeightStart = (double)dimensions.getHeight() * 0.6;
            int scrollStart = (int)screenHeightStart;
            double screenHeightEnd = (double)dimensions.getHeight() * 0.4;
            int scrollEnd = (int)screenHeightEnd;
            Point startPoint = new Point(200, scrollStart);
            Point endPoint = new Point(200, scrollEnd);
            doSwipe(driver, startPoint, endPoint, 500);
        }
    }

    public static void doSwipe(AppiumDriver driver, Point startPoint, Point endPoint, int duration) {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = (new Sequence(FINGER, 1)).addAction(FINGER.createPointerMove(Duration.ofMillis(0L), PointerInput.Origin.viewport(), startPoint.getX(), startPoint.getY())).addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(FINGER.createPointerMove(Duration.ofMillis((long)duration), PointerInput.Origin.viewport(), endPoint.getX(), endPoint.getY())).addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public static void scrollPageUpWithNoOfScroll(AndroidDriver driver, int noOfScroll) {
        for(int i=0; i<=noOfScroll; ++i){
            Dimension dimensions = driver.manage().window().getSize();
            double screenHeightStart = (double)dimensions.getHeight() * 0.6;
            int scrollStart = (int)screenHeightStart;
            double screenHeightEnd = (double)dimensions.getHeight() * 0.4;
            int scrollEnd = (int)screenHeightEnd;
            Point startPoint = new Point(200, scrollEnd);
            Point endPoint = new Point(200, scrollStart);
            doSwipe(driver, startPoint, endPoint, 500);
        }
    }
}
