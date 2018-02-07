package ebayAndroidAutomation.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePageObjects {
    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public MobileElement LOGGED_IN_USER;
}
