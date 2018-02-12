package ebayAndroidAutomation.flows;

import ebayAndroidAutomation.config.CommonAppiumTest;
import ebayAndroidAutomation.config.DeviceInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ebayAndroidAutomation.Pages.LoginPage;
import ebayAndroidAutomation.Pages.WelcomePage;
import java.io.IOException;

public class AndroidFlow extends CommonAppiumTest {


    public AndroidFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


}
