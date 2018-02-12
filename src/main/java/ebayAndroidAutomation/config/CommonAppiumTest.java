package ebayAndroidAutomation.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class CommonAppiumTest {
    public  AppiumDriver driver;
    Logger logger = Logger.getLogger(CommonAppiumTest.class);

    public CommonAppiumTest(AppiumDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad(WebElement id) {
        logger.info("Waiting For element to load="+id);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }
    public void WaitAppToLoad()
    {
        try {
            driver.wait(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void GetCurrentRotation()
    {
        logger.info("Current rotation of screen is ="+driver.getOrientation());

    }
    public void SetRotationPortait()
    {
        logger.info("Current rotation set to PORTRAIT=");
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    public void SetRotationLandscape()
    {
        logger.info("Current rotation set to PORTRAIT=");
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void waitForElementToDisAppear(String id) {
        logger.info("Waiting For element to load="+id);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }
    public boolean isElementPresent(By by) {
        try {
            logger.info("Whether element is present or not ");
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        logger.info("Current context" + driver.getContext());
    }

    public void clickBackButton() {
        driver.navigate().back(); //Closes keyboard
        //driver.navigate().back(); //Comes out of edit mode
    }
    public boolean clickButton(MobileElement element){
        logger.info("Click button or tap on screen");
        new TouchAction(driver).tap(element);
        return true;
    }

    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;

        new TouchAction(driver).press(startx, starty)
                .waitAction(Duration.ofSeconds(2))
                .moveTo(endx,starty).release().perform();
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(startx, starty)
                .waitAction(Duration.ofSeconds(3000))
                .moveTo(endx,starty).release();
    }

    public boolean swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.7);
        int endx = (int) (size.width * 0.20);
        int starty = size.width / 2;
        new TouchAction(driver).press(startx, starty)
                .waitAction(Duration.ofSeconds(2))
                .moveTo(endx,starty).release().perform();
        return true;

    }

    public void ScrollDown()
    {



    }

    public boolean swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.7);
        int endx = (int) (size.width * 0.20);
        int starty = size.width / 2;
        new TouchAction(driver).press(startx, starty)
                .waitAction(Duration.ofSeconds(2))
                .moveTo(endx,starty).release().perform();
        return true;
    }


}
