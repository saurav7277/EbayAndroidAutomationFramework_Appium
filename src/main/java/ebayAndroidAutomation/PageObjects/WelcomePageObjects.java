package ebayAndroidAutomation.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePageObjects {
    @AndroidFindBy(id = "org.wordpress.android:id/my_site_title_label")
    public MobileElement LOGGED_IN_USER;
}
