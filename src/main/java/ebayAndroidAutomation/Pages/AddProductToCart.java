package ebayAndroidAutomation.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class AddProductToCart {
    AppiumDriver driver;
    Logger logger = Logger.getLogger(WelcomePage.class);

    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignIn;

}
