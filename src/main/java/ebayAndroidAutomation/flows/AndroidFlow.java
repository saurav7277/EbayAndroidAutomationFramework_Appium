package ebayAndroidAutomation.flows;

import ebayAndroidAutomation.config.CommonAppiumTest;
import ebayAndroidAutomation.config.DeviceInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ebayAndroidAutomation.Pages.LoginPage;
import ebayAndroidAutomation.Pages.WelcomePage;
import java.io.IOException;

public class AndroidFlow extends CommonAppiumTest implements DeviceInterface {

    public AndroidFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void login(LoginPage loginPage, String username, String password) throws IOException, InterruptedException {
        loginPage.enterUserAndPassword(username, password);
        driver.hideKeyboard();
        loginPage.signIn();
    }

    public void waitForHomePage(WelcomePage welcomePage) {
        welcomePage.waitForHomePageToLoad();
    }
}
