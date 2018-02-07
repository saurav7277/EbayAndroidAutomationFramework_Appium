package ebayAndroidAutomation.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPageObjects {
    @CacheLookup
    @AndroidFindBy(id = "org.wordpress.android:id/nux_username")
    @FindBy(id = "user_login")  public MobileElement username;

}
