package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import ebayAndroidAutomation.config.ViewFactory;
import ebayAndroidAutomation.config.DeviceInterface;
import ebayAndroidAutomation.PageObjects.WelcomePageObjects;

public class WelcomePage extends CommonAppiumTest {
    public ViewFactory viewFactory = new ViewFactory(driver);
    public DeviceInterface runnerInfo;
    WelcomePageObjects welcomePageObjects = new WelcomePageObjects();

    public WelcomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), welcomePageObjects);
        runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
    }

}
