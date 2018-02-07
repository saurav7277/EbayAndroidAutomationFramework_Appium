package ebayAndroidAutomation.flows;

import ebayAndroidAutomation.config.CommonAppiumTest;
import ebayAndroidAutomation.config.DeviceInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ebayAndroidAutomation.Pages.LoginPage;
import ebayAndroidAutomation.Pages.WelcomePage;
import java.io.IOException;

public class iOSFlow extends CommonAppiumTest implements DeviceInterface {
    public iOSFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public void login(LoginPage loginPage, String username, String password) throws IOException, InterruptedException {
       // loginPage.enterUserAndPassword(username, password);
        //loginPage.signIn();
    }

    public void waitForHomePage(WelcomePage welcomePage) {
        // TODO Auto-generated method stub
        //welcomePage.acceptEditorToolTip();
        // welcomePage.selectBlog();

    }
}
