package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WelcomePage {
    AppiumDriver driver;
    Logger logger = Logger.getLogger(WelcomePage.class);

    @AndroidFindBy(id = "com.ebay.mobile:id/logo")
    public  MobileElement Logo;
    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public MobileElement SignIn;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public MobileElement SearchBox;

    @AndroidFindBy(id = "com.ebay.mobile:id/suggestionList")
    public MobileElement SuggestionList;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_deals")
    public  MobileElement FeaturedDeals;
    @AndroidFindBy(id="com.ebay.mobile:id/card_item_1")
    public MobileElement ItemToPurchase;

    public WelcomePage(AppiumDriver ldriver)
    {
        this.driver=ldriver;
    }

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
    public void SearchBox()
    {
        logger.info("Click button or tap on screen");
        try {
            //new TouchAction(driver).perform().tap(SearchBox);
            new TouchAction(driver).perform().press(SearchBox);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Search button clicked");
    }
    public void ClickOnSignIn()
    {

    }
    public void selectItem()
    {

    }


}
