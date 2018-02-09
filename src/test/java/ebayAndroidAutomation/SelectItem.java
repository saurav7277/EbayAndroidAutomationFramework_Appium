package ebayAndroidAutomation;

import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.annotations.Test;
import ebayAndroidAutomation.Pages.WelcomePage;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SelectItem{

    DriverManager driverManager;
    WelcomePage welcomepage;
    AppiumDriver driver;


    @Test
    public void SelectItems() throws InterruptedException, IOException
    {
        System.out.println("\n In test");
        driver=DriverManager.getDriver();
        welcomepage = new WelcomePage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),welcomepage);
        welcomepage.waitForAppToLoadLogo();
        welcomepage.SearchBox();
        //welcomepage.ClickOnSignIn();
        //welcomepage.selectItem();
    }

}
