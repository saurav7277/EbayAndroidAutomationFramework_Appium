package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    AppiumDriver driver;
    CommonAppiumTest commonAppiumTest;

    @AndroidFindBy(id = "com.ebay.mobile:id/logo")
    public  MobileElement Logo;
    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public MobileElement SignIn;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public MobileElement SearchBox;

    @AndroidFindBy(id = "com.ebay.mobile:id/suggestionList")
    public MobileElement SuggestionList;

    @AndroidFindBy(xpath = ".//*[@text='Original Terabyte Ultra Slim Wireless Mouse']")
    public MobileElement ItemToPurchase;

    public WelcomePage(AppiumDriver ldriver)
    {
        this.driver=ldriver;
    }

    public void WaitForLoadLogo()
    {
        commonAppiumTest.waitForElement(SignIn);
    }
    public void ClickOnSignIn()
    {
        commonAppiumTest.clickButton(SignIn);
    }
    public void selectItem()
    {
        commonAppiumTest.swipeDown();
    }


}
