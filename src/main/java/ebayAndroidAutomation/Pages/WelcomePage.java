package ebayAndroidAutomation.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static ebayAndroidAutomation.config.DriverManager.prop;

public class WelcomePage {
    AndroidDriver driver;
    Logger logger = Logger.getLogger(WelcomePage.class);


    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignIn;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement SearchBox;

    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    public WebElement SearchInText;


    @AndroidFindBy(id="com.ebay.mobile:id/textview_deals")
    public  WebElement FeaturedDeals;


    public WelcomePage(AndroidDriver ldriver)
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
            SearchBox.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Search button clicked");
    }
    public void ClickOnSignIn()
    {
        logger.info("Click on Sign in button");
        try {
            SignIn.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Click on Sign in button");
    }
    public void SearchItemFromSearchBox()
    {
        logger.info("In search bar searching the Item for purchase");
        SearchInText.sendKeys(prop.getProperty("SearchItemForPurchase"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }


}
