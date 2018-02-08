package ebayAndroidAutomation.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {

    AppiumDriver driver;


    public  LoginPage(AppiumDriver driver)
    {
        this.driver=driver;
    }
}
