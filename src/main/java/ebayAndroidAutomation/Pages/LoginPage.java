package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import ebayAndroidAutomation.config.ViewFactory;
import ebayAndroidAutomation.config.DeviceInterface;
import ebayAndroidAutomation.PageObjects.LoginPageObjects;

import java.io.IOException;

public class LoginPage extends CommonAppiumTest{
    public ViewFactory viewFactory = new ViewFactory(driver);
    public DeviceInterface runnerInfo;
    public LoginPageObjects loginPageObjects = new LoginPageObjects();

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
        runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
    }
    public WelcomePage enterValidCredentails(String username, String password) throws IOException, InterruptedException {
        runnerInfo.login(this, username, password);
        return new WelcomePage(driver);
    }
}
