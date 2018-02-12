package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.ScrollElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    AndroidDriver driver;
    ScrollElement scrollElement;
    Logger logger = Logger.getLogger(WelcomePage.class);
    public WelcomePage(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignInWelcomePage;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_deals")
    public  WebElement FeaturedDeals;


    public void waitForAppToLoadLogo()
    {
            logger.info("Waiting for App to load");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(FeaturedDeals));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("App to loaded successfully");

    }

    public LoginPage ClickOnSignIn()
    {
        logger.info("Click on Sign in button");
        try {
            SignInWelcomePage.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Clicked on Sign in button");
        return new LoginPage(driver);
    }


}
